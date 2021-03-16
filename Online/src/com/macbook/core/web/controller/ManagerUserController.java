package com.macbook.core.web.controller;

import com.macbook.common.utils.Page;
import com.macbook.core.pojo.User;
import com.macbook.core.rule.Rule;
import com.macbook.core.service.ManagerUserService;
import com.macbook.core.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;


@Controller
public class ManagerUserController {
    @Autowired
    private ManagerUserService managerUserService;
    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/toManagerMain.action",method = RequestMethod.GET)
    public String toManagerMain(){
        return "Manager/manager_main";
    }

    @RequestMapping(value = "/toManagerUser.action",method = RequestMethod.GET)
    public String toManagerUser(){
        return "Manager/manager_user";
    }

    @RequestMapping(value = "/list.action")
    public String list(@RequestParam(defaultValue = "1")Integer page,
                       @RequestParam(defaultValue = "7")Integer rows,
                       String sno, String name, String identity, String college,
                       Model model){
        Page<User> users = managerUserService.findUserList(page,rows,sno,name,identity,college);
        model.addAttribute("page",users);
        return "Manager/manager_user";
    }

    @RequestMapping(value = "/deleteUser.action")
    @ResponseBody
    public String deleteUser(String sno){
        int rows = managerUserService.deleteUser(sno);
        if(rows > 0){
            return "OK";
        }
        else{
            return "FALL";
        }
    }

    @RequestMapping(value = "/createManagerUser.action")
    @ResponseBody
    public String createManagerUser(User user){
        if(user.getSno() == "" || user.getName() == "" || user.getPassword() == ""
                || user.getSex() == "" || user.getSex() == "" || user.getIdentity() == ""
                || user.getPhone() == ""){
            return "FALL1";
        }
        else {
            if(!Rule.isNum(user.getSno())) {
                return "FALL2";
            }
            else{
                User user2 = registerService.findUserBySno(user.getSno());
                if(user2 != null){
                    return "FALL3";
                }
                else{
                    int rows = managerUserService.createManagerUser(user);
                    if(rows > 0){
                        return "OK";
                    }
                    else {
                        return "FALL";
                    }
                }
            }
        }
    }

    @RequestMapping(value = "/findManagerUserBySno.action")
    @ResponseBody
    public User findManagerUserBySno(String sno){
        User user = managerUserService.findManagerUserBySno(sno);
        return user;
    }

    @RequestMapping(value = "/updateManagerUser.action")
    @ResponseBody
    public String updateManagerUser(User user){
//        System.out.println(user.getSno());
//        System.out.println(user.getName());
//        System.out.println(user.getPassword());
//        System.out.println(user.getIdentity());
//        System.out.println(user.getSex());
//        System.out.println(user.getPhone());
//        System.out.println(user.getCollege());
        int rows = managerUserService.updateManagerUser(user);
        if (rows > 0){
            return "OK";
        }
        else {
            return "FALL";
        }
    }
}
