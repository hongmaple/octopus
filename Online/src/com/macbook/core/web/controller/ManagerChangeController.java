package com.macbook.core.web.controller;

import com.macbook.core.service.ManagerChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author maweihong
 */
@Controller
public class ManagerChangeController {
    @Autowired
    private ManagerChangeService managerChangeService;

    @RequestMapping(value = "/toUpdatePassword.action",method = RequestMethod.POST)
    @ResponseBody
    public String updatePassword(String sno, String password,
                                 HttpServletRequest request){
        String tpass = request.getParameter("tpass");

        if(password == "" || tpass == ""){
            return "FALL1";
        }
        else{
            if(!password.equals(tpass)){
                return "FALL2";
            }
            else{
                int rows = managerChangeService.updatePassword(sno,password);
                if(rows > 0){
                    return "OK";
                }
                else{
                    return "FALL3";
                }
            }
        }
    }
}
