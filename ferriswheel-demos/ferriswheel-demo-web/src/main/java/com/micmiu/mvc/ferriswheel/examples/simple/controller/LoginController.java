package com.micmiu.mvc.ferriswheel.examples.simple.controller;

import com.micmiu.mvc.ferriswheel.examples.Constant;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * LoginAction负责打开登录页面(GET请求)和登录出错页面(POST请求)， 真正登录的POST请求由Filter完成,
 *
 * @author <a href="http://www.micmiu.com">Michael Sun</a>
 */
@Controller
public class LoginController {

	private static final String PREFIX = Constant.VIEW_PREFIX + "system" + Constant.LAYOUT_SPLIT;

	@Autowired
	private LocaleResolver localeResolver;

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginShow(HttpServletRequest req, HttpServletResponse resp) {

		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser.isAuthenticated()) {
			return "redirect:/index.do";
		}
		Locale loc = localeResolver.resolveLocale(req);
		localeResolver.setLocale(req, resp, loc);
		return PREFIX + "login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(
			@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName,
			Model model, HttpServletRequest req) {
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM,
				userName);
		return PREFIX + "login";
	}

}
