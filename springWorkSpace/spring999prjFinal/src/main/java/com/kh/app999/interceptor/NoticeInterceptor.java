package com.kh.app999.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kh.app999.member.entity.MemberDto;

public class NoticeInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		MemberDto loginUser = (MemberDto) request.getSession().getAttribute("loginUser");
		
		if("admin".equals(loginUser.getUserId())) {
			return true;
		}else {
//			response.sendRedirect("/app999");
//			response.sendRedirect(request.getServletContext().getContextPath());
			request.setAttribute("msg", "¾îµå¹Î ¾Æ´Ï¸é ¾ÈµÊ");
			request.getRequestDispatcher("/WEB-INF/views/error/errorPage.jsp").forward(request, response);
			return false;
		}
		
	}
	
}
