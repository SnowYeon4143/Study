package com.kh.app18;

import org.junit.Test;

public class MyClass {
	
	@Test
	public void test01() {
		System.out.println("test01 called...");
		
		MemberVo vo = MemberVo.builder()
		.id("iii")
		.pwd("ppppwwwddd")
		.name("cccbbbjjj")
		.build();
		
		System.out.println(vo);
	}
}
