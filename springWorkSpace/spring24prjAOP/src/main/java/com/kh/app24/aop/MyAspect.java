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
	 * aop�� ���ؼ��� ũ�� 2������ �˸� ��
	 * 
	 * 1. ����(������̼�)
	 * @Before
	 * @After
	 * @AfterReturning
	 * @AfterThrowing
	 * @Around
	 * 
	 * 2. ��� where (������̼� ��ȣ �κ�)
	 * - target : Ŭ���� || �������̽�
	 * - within : Ŭ���� || ��Ű��
	 * - execution :  ǥ���� ( ���������� ��ȯ�� ��Ű����.Ŭ������.�޼ҵ��̸�(�Ű�����) )
	 *  * : ���ϵ�ī��
	 *  . : ���� ��Ű�� ��ü
	 *  .. : ���� ��Ű�� �� ������Ű�� ��ü
	 */
	
	
	// advice : �츮�� ���� �޼ҵ�
	// joinPoint : ���Ͻÿ� aspect�� ����Ǵ� ����
	// pointCut : ���
	
	// ���� before ������̼����� ����
	// ��� target ��ȣ �ȿ��� ����
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
	
//	@AfterReturning Ÿ�� �ȿ��� ������ �Ͼ������ aop ����
//	@AfterThrowing Ÿ�� �ȿ��� ������ �Ͼ������ aop ����
//	@After("target(com.kh.app24.aop.service.MyService)")
	public void myServiceAdvice02() {
		long time = System.currentTimeMillis();
		
		log.info("����ð� ::: {}", time);
	}
	
	/**
	 * @Around �޼ҵ� ����
	 * ����Ÿ�� : ������Ʈ
	 * �Ķ���� : ��������Ʈ
	 * ���� : trowable
	 * 
	 * before��
	 * after
	 * 2���� ������ �� ������ �� ����
	 */
	
	//@Around �޼ҵ� ����
//	@Around("execution(public void com.kh.app24.aop.dao.MyDao.test())")
//	@Around("execution(void com.kh.app24.aop.dao.MyDao.test())") // �ۺ� �Ƚᵵ ��
//	@Around("execution(* com.kh.app24.aop.dao.MyDao.test())") //����Ÿ�� * : �������, java.lang.String : String
//	@Around("execution(* com.kh.app24.aop.dao.MyDao.test(*))") //�Ű������� *�� 1�� �̻�
//	@Around("execution(* com.kh.app24.aop.dao.MyDao.test(..))") //�Ű������� ..�� 0�� �̻�
//	@Around("execution(* com.kh.app24.aop.dao.MyDao.test(int))") //�Ű����� ���� ���� ����
//	@Around("execution(* com.kh.app24.aop.dao.MyDao.te*(..))") //�޼ҵ� �̸� ǥ�������� ó�� ����
//	@Around("execution(* com.kh.app24.aop.dao.MyDao.*st(..))") //�޼ҵ� �̸� ǥ�������� ó�� ����
//	@Around("execution(* com.kh.app24.aop.dao.MyDao.*(..))") //�޼ҵ� �̸� ǥ�������� ó�� ����
//	@Around("execution(* com.kh.app24.aop.dao.My*.*(..))") //Ŭ���� �̸� ǥ�������� ó�� ����
//	@Around("execution(* com.kh.app24.aop.dao.*Dao.*(..))") //Ŭ���� �̸� ǥ�������� ó�� ����
//	@Around("execution(* com.kh.app24.aop.dao.*.*(..))") //Ŭ���� �̸� ǥ�������� ó�� ����
	@Around("execution(* com.kh.app24..*.*(..))") //��Ű�� �̸� ǥ�������� ó�� ����
	public Object MyAdvice04(ProceedingJoinPoint jp) throws Throwable {
		
		System.out.println("elapse check start ==========");
		
		//before ~~~
		long start = System.currentTimeMillis();
		
		log.info("���۽ð� ::: {}", start);
		
		//Ÿ�� �޼ҵ� ȣ��
		Object obj = jp.proceed();
		
		//after ~~~
		long end = System.currentTimeMillis();
		
		log.info("����ð� ::: {}", end);
		
		long elapse = end - start;
		
		log.info("elapse : {}ms", elapse);
		
		return obj;
	}
	
}
