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
		
		//실행 전
		long startTime = System.currentTimeMillis();
		
		//실행
		Object result = jp.proceed();
		
		//실행 후
		
		long endTime = System.currentTimeMillis();
		
		//시간 계산
		long resultTime = endTime-startTime;
		log.warn("실행시간 ::: " + resultTime);
		
		return result;
	}
	
}
