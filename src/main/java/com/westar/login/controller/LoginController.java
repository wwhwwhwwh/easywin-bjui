package com.westar.login.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.westar.common.controller.BaseController;
import com.westar.common.model.UserInfo;
import com.westar.login.services.LoginService;

@Controller
public class LoginController extends BaseController{
	
	@Resource
	private LoginService loginService;
	
	@RequestMapping("/loginAccount")
	public ModelAndView login(String username,String passwordhash,String yzm) {
		ModelAndView mav = new ModelAndView("/toIndex");
		System.out.println(username);
		UserInfo userInfo = loginService.queryUserInfo(null);
				
		
		String sid = this.addSessionUser(userInfo);
		System.out.println(sid);
		return mav;
	}
	
	/**
	 * 注销
	 * 
	 * @return
	 */
	@RequestMapping("/exit")
	public ModelAndView exit(String sid) {
		ModelAndView view = new ModelAndView("redirect:/logout.jsp");
		this.logOut(sid);
		view.addObject("sid", sid);
		return view;
	}
}
