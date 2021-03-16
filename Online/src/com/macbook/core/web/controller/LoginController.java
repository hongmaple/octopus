package com.macbook.core.web.controller;

import com.macbook.core.pojo.User;
import com.macbook.core.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author maweihong
 * 登录控制类
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/toLogin.action",method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }
    @RequestMapping(value = "/login.action",method = RequestMethod.POST)
    public String login(String sno, String password,
                        Model model, HttpSession session,
                        HttpServletRequest request) throws IOException {
        String verifycode = request.getParameter("verifycode");
        verifycode = verifycode.toUpperCase();
        String verifycodeValue = (String) session.getAttribute("verifyCodeValue");
        if(sno == "" || password == "" || verifycode == ""){
            model.addAttribute("msg", "请完整输入登录信息!");
            return "login";
        }
        else{
            if (verifycode.equalsIgnoreCase(verifycodeValue)){
                User user = this.loginService.findUser(sno,password);
                if (user != null){
                    session.setAttribute("USER_SESSION",user);
                    if (user.getIdentity().equals("学生")) {
                    	 return "Student/student_main";
					}
                    else if(user.getIdentity().equals("教师")) {
                    	return "Teacher/teacher_main";
                    }
                    else {
                    	return "Manager/manager_main";
                    }
                }else {
                    model.addAttribute("msg", "账号或者密码错误!");
                    return "login";
                }
            }else{
                model.addAttribute("msg", "验证码错误!");
                return "login";
            }
        }
    }


    /**
     * 从其他类跳转到学生界面
     * @return
     */
    @RequestMapping(value = "/toStudent.action")
    public String toStudent()
    {
       return "Student/student_main";
    }

    /**
     * 从其他类跳转到教师界面
     * @return
     */
    @RequestMapping(value = "/toTeacher.action")
    public String toTeacher()
    {
        return "Teacher/teacher_main";
    }

    /**
     * 从其他类跳转到管理员界面
     * @return
     */
    @RequestMapping(value = "/toManager.action")
    public String toManager()
    {
        return "Manager/manager_main";
    }


    @RequestMapping(value = "/logout.action")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:toLogin.action";
    }
}
