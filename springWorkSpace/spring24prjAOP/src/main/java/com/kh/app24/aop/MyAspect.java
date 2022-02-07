package com.kh.app24.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@EnableAspectJAutoProxy
@Component
@Aspect
@Slf4j
public class MyAspect {
	/**
	 * aop에 대해서는 크게 2가지를 알면 됨
	 * 
	 * 1. 언제(어노테이션)
	 * @Before
	 * @After
	 * @AfterReturning
	 * @AfterThrowing
	 * @Around
	 * 
	 * 2. 대상 where (어노테이션 괄호 부분)
	 * - target : 클래스 || 인터페이스
	 * - within : 클래스 || 패키지
	 * - execution :  표현식 ( 접근제한자 반환형 패키지명.클래스명.메소드이름(매개변수) )
	 *  * : 와일드카드
	 *  . : 현재 패키지 전체
	 *  .. : 현재 패키지 및 하위패키지 전체
	 */
	
	
	// advice : 우리가 만든 메소드
	// joinPoint : 프록시와 aspect가 연결되는 지점
	// pointCut : 대상
	
	// 언제 before 어노테이션으로 설정
	// 대상 target 괄호 안에다 설정
//	@Before("target(com.kh.app24.HomeController)")
	public void myAdvice01() {
		log.info("before =================");
	}
	
//	@After("target(com.kh.app24.HomeController)")
	public void myAdvice02() {
		log.info("after =================");
	}
	
//	@Before("target(com.kh.app24.aop.service.MyService)")
	public void myServiceAdvice01() {
		log.info("before ~~~");
	}
	
//	@AfterReturning 타겟 안에서 에러가 일어났을때만 aop 적용
//	@AfterThrowing 타겟 안에서 에러가 일어났을때만 aop 적용
//	@After("target(com.kh.app24.aop.service.MyService)")
	public void myServiceAdvice02() {
		long time = System.currentTimeMillis();
		
		log.info("현재시간 ::: {}", time);
	}
	
	/**
	 * @Around 메소드 구조
	 * 리턴타입 : 오브젝트
	 * 파라미터 : 조인포인트
	 * 예외 : trowable
	 * 
	 * before랑
	 * after
	 * 2개의 시점을 다 간섭할 수 있음
	 */
	
	//@Around 메소드 구조
//	@Around("execution(public void com.kh.app24.aop.dao.MyDao.test())")
//	@Around("execution(void com.kh.app24.aop.dao.MyDao.test())") // 퍼블릭 안써도 됨
//	@Around("execution(* com.kh.app24.aop.dao.MyDao.test())") //리턴타입 * : 상관없다, java.lang.String : String
//	@Around("execution(* com.kh.app24.aop.dao.MyDao.test(*))") //매개변수의 *은 1개 이상
//	@Around("execution(* com.kh.app24.aop.dao.MyDao.test(..))") //매개변수의 ..은 0개 이상
//	@Around("execution(* com.kh.app24.aop.dao.MyDao.test(int))") //매개변수 직접 지정 가능
//	@Around("execution(* com.kh.app24.aop.dao.MyDao.te*(..))") //메소드 이름 표현식으로 처리 가능
//	@Around("execution(* com.kh.app24.aop.dao.MyDao.*st(..))") //메소드 이름 표현식으로 처리 가능
//	@Around("execution(* com.kh.app24.aop.dao.MyDao.*(..))") //메소드 이름 표현식으로 처리 가능
//	@Around("execution(* com.kh.app24.aop.dao.My*.*(..))") //클래스 이름 표현식으로 처리 가능
//	@Around("execution(* com.kh.app24.aop.dao.*Dao.*(..))") //클래스 이름 표현식으로 처리 가능
//	@Around("execution(* com.kh.app24.aop.dao.*.*(..))") //클래스 이름 표현식으로 처리 가능
	@Around("execution(* com.kh.app24..*.*(..))") //패키지 이름 표현식으로 처리 가능
	public Object MyAdvice04(ProceedingJoinPoint jp) throws Throwable {
		
		System.out.println("elapse check start ==========");
		
		//before ~~~
		long start = System.currentTimeMillis();
		
		log.info("시작시간 ::: {}", start);
		
		//타겟 메소드 호출
		Object obj = jp.proceed();
		
		//after ~~~
		long end = System.currentTimeMillis();
		
		log.info("종료시간 ::: {}", end);
		
		long elapse = end - start;
		
		log.info("elapse : {}ms", elapse);
		
		return obj;
	}
	
}
