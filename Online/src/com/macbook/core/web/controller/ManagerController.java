package com.macbook.core.web.controller;

import com.macbook.core.pojo.User;
import com.macbook.core.service.ManagerUserService;
import com.mysql.cj.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author maweihong
 *
 */
@Controller
public class ManagerController {
	/**
	 * 跳转到关于系统部分
	 * @return
	 */
	@RequestMapping(value="/toManagerAbout.action",method = RequestMethod.GET)
	public String toManagerAbout(HttpServletRequest request) {
		User user = null;
		try {
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("USER_SESSION");
		}catch (Exception e){
			System.out.println("取不到session的值");
		}
		if (user.getIdentity().equals("管理员")){
			return "Manager/manager_about";
		}else if (user.getIdentity().equals("学生")){
			return "Student/student_about";
		}else {
			return "Teacher/teacher_about";
		}

	}

	/**
	 * 跳转到修改密码部分
	 * @return
	 */
	@RequestMapping(value="/toManagerChange.action",method = RequestMethod.GET)
	public String toManagerChange(HttpServletRequest request){
		User user = null;
		try {
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("USER_SESSION");
		}catch (Exception e){
			System.out.println("取不到session的值");
		}
		if (user.getIdentity().equals("管理员")){
			return "Manager/manager_change";
		}else if (user.getIdentity().equals("学生")){
			return "Student/student_change";
		}else {
			return "Teacher/teacher_change";
		}
	}

	/**
	 * 跳转到编辑信息部分
	 * @return
	 */
	@RequestMapping(value = "/toManagerInformation.action",method = RequestMethod.GET)
	public String toManagerInformation(HttpServletRequest request){
		User user = null;
		try {
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("USER_SESSION");
		}catch (Exception e){
			System.out.println("取不到session的值");
		}
		if (user.getIdentity().equals("管理员")){
			return "Manager/manager_information";
		}else if (user.getIdentity().equals("学生")){
			return "Student/student_information";
		}else {
			return "Teacher/teacher_information";
		}
	}

}
