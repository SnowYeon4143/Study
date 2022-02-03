package com.kh.app19.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//���ͼ��� ����� ��� 2����
// 1. HandlerInterceptor �������̽� ���
// 2. HandlerInterceptorAdapter Ŭ���� ���

public class MyInterceptor extends HandlerInterceptorAdapter {

	//���ͼ��ʹ� 3���� ������ ������ ��
	//1. 1. handle ����
	//2. 2. handle ������
	//3. 3. ȭ�� �Ѱ��ֱ� ����
	
	//1. handle ����
	//���� ���� ���� ��û�� �����ų�� ���� ���� ����
	//�ڵ鷯 : ó���� �޼ҵ� ���� Ȯ�� ����
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("preHandle called ~~~");
		System.out.println("�ڵ鷯 : " + handler);
		
		return true;
	}
	
	//2. handle ������
	//���� ���� ����
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("postHandle called ~~~");
		
		super.postHandle(request, response, handler, modelAndView);
	}
	
	//3. ȭ�� �Ѱ��ֱ� ����
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("afterCompletion called ~~~");
		System.out.println(ex);
		
		super.afterCompletion(request, response, handler, ex);
	}
}
