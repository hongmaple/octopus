package com.macbook.core.web.controller;

import com.macbook.core.pojo.User;
import com.macbook.core.rule.Rule;
import com.macbook.core.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;

/**
 * @author maweihong
 * 添加用户的控制类
 */
@Controller
public class RegisterController {

    @Autowired
    public RegisterService registerService;
    /**
     * 跳转到注册界面
     * @return
     */
    @RequestMapping(value = "/toRegister.action",method = RequestMethod.GET)
    public String toRegister(){
        return "register";
    }

    @RequestMapping(value = "/register.action",method = RequestMethod.POST)
    public String register(User user, HttpServletRequest request) {
//    	request.setCharacterEncoding("UTF-8");
//    	response.setCharacterEncoding("UTF-8");
        String tpass = request.getParameter("tpass");
        if(user.getSno() == "" || user.getName() == "" || user.getPassword() == ""
        || user.getSex() == "" || user.getSex() == "" || user.getIdentity() == ""
        || user.getPhone() == "" || tpass == ""){
        	request.setAttribute("msg3", "请完整输入注册信息！");
        	   return "register";
        }
        else {
//        	System.out.println(user.getSno());
//        	System.out.println(user.getName());
//        	System.out.println(user.getPassword());
//        	System.out.println(tpass);
//        	System.out.println(user.getPhone());
//        	System.out.println(user.getIdentity());
//        	System.out.println(user.getSex());
//        	System.out.println(user.getCollege());
        	if(!Rule.isNum(user.getSno())) {
        		request.setAttribute("msg3", "账号必须是数字");
        		return "register";
        	}
        	else if(user.getSno().length() != 12) {
        		request.setAttribute("msg3", "请输入12位学号或工号！");
        		return "register";
        	}
        	else if(!Rule.isChinese(user.getName())) {
        		request.setAttribute("msg3", "姓名必须是中文");
        		return "register";
        	}
        	else if (!user.getPassword().equals(tpass)){
            	request.setAttribute("msg3","两次输入的密码不一致!");
                return "register";
            }
            else{
            	User user1 = this.registerService.findUserBySno(user.getSno());
            	if(user1 != null) {
            		request.setAttribute("msg3", "该账户已经存在，请直接返回登录界面登录！");
            		return "register";
            	}
            	else {
            	    int row = this.registerService.createUser(user);  
                    if(row > 0){
                    	request.setAttribute("msg3","注册成功，请返回登录界面进行登录!");
                    	return "register";
                    }
                    else{
                    	request.setAttribute("msg3","注册失败");
                    	return "register";
                    }
            	}
            
            }
        }
    }
}

