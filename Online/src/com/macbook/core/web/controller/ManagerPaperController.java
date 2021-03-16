package com.macbook.core.web.controller;

import com.macbook.common.utils.Page;
import com.macbook.core.pojo.Paper;
import com.macbook.core.pojo.User;
import com.macbook.core.rule.Rule;
import com.macbook.core.service.ManagerPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author maweihong
 */
@Controller
public class ManagerPaperController {

    @Autowired
    private ManagerPaperService managerPaperService;

    @RequestMapping(value = "/toManagerPaper.action",method = RequestMethod.GET)
    public String toManagerPaper(){
        return "Manager/manager_paper";
    }

    @RequestMapping(value = "/listPaper.action")
    public String list(@RequestParam(defaultValue = "1")Integer page,
                       @RequestParam(defaultValue = "7")Integer rows,
                       Integer id, String qty_name, Integer qty_time,
                       Model model, HttpServletRequest request){
        Page<Paper> papers = managerPaperService.findPaperList(page,rows,id,qty_name,qty_time);
        model.addAttribute("page",papers);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        if (user.getIdentity().equals("管理员")){
            return "Manager/manager_paper";
        }
        else{
            return "Teacher/teacher_paper";
        }

    }

    @RequestMapping(value = "/toCreateManagerPaper.action")
    @ResponseBody
    public String createManagerPaper(Paper paper){
        if(paper.getQty_name()=="" || paper.getQty_time()==null ||paper.getQty_sing()==null
        || paper.getQty_muti()==null || paper.getQty_jud()==null || paper.getQty_fill()==null
        || paper.getQty_ess()==null || paper.getId()==null){
            return "FALL1";
        }
        else{
            Paper paper2 = managerPaperService.findManagerPaperById(paper.getId());
            if(paper2 != null){
                return "FALL3";
            }
            else{
                int rows = managerPaperService.createManagerPaper(paper);
                if(rows > 0){
                    return "OK";
                }
                else{
                    return "FALL2";
                }
            }
        }

    }

    @RequestMapping(value = "/toDeleteManagerPaper.action")
    @ResponseBody
    public String deleteManagerPaper(Integer id){
        int rows = managerPaperService.deleteManagerPaper(id);
        if(rows > 0){
            return "OK";
        }
        else{
            return "FALL";
        }
    }

    @RequestMapping(value = "/toFindManagerPaper.action")
    @ResponseBody
    public Paper findManagerPaperById(Integer id){
        Paper paper = managerPaperService.findManagerPaperById(id);
        return paper;
    }

    @RequestMapping(value = "/toUpdateManagerPaper.action")
    @ResponseBody
    public String updateManagerPaper(Paper paper){
        int rows = managerPaperService.updateManagerPaper(paper);
        if (rows > 0){
            return "OK";
        }
        else{
            return "FALL";
        }
    }
}
