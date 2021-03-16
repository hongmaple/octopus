package com.macbook.core.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.macbook.core.pojo.User;
import com.macbook.core.service.ChangePasswordService;

/**
 *
 * @author maweihong
 *登录前修改密码
 */
@Controller
public class ChangePasswordController {
	/**
	 * 注入ChangePasswordService
	 */
	@Autowired
	private ChangePasswordService changePasswordService;

	@RequestMapping(value = "/toChange.action",method = RequestMethod.GET)
	public String changePassword(String sno,String password,
								 HttpServletRequest request,HttpServletResponse response) throws IOException {
		String phone1 = request.getParameter("phone");
		String tPassword = request.getParameter("t_password");
		if(sno == null || password == null || tPassword == null || phone1 == null) {
			request.setAttribute("msg1", "请完整输入修改信息！");
			return "changePassword";
		}
		else {
			User user = this.changePasswordService.findUserBySno(sno);
			if(user == null) {
				request.setAttribute("msg1", "该用户还未注册！");
				return "changePassword";
			}
			else {
				if(!user.getPhone().equals(phone1)) {
					request.setAttribute("msg1", "验证的手机号码错误！");
					return "changePassword";
				}
				else {
					if(password.equals(tPassword)) {
						int rows = this.changePasswordService.updatePassword(sno,password);
						if(rows > 0) {
							request.setAttribute("msg1", "修改成功,请按返回键进行登录！");
							return "changePassword";
						}
						else {
							request.setAttribute("msg1", "修改失败！");
							return "changePassword";
						}
					}
					else {
						request.setAttribute("msg1", "两次输入的密码不一致！");
						return "changePassword";
					}

				}
			}
		}
	}
}
