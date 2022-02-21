package com.kh.app999.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@EnableAspectJAutoProxy
@Component
@Aspect
@Slf4j
public class TimerAspect {
	
	@Around("execution(* com.kh.app999..*.NoticeServiceImpl.*(..))")
	public Object checkTime(ProceedingJoinPoint jp) throws Throwable {
		
		//���� ��
		long startTime = System.currentTimeMillis();
		
		//����
		Object result = jp.proceed();
		
		//���� ��
		
		long endTime = System.currentTimeMillis();
		
		//�ð� ���
		long resultTime = endTime-startTime;
		log.warn("����ð� ::: " + resultTime);
		
		return result;
	}
	
}
