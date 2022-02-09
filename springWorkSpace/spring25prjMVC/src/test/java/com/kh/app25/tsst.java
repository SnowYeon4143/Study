package com.kh.app25;

import java.util.Scanner;

import org.junit.Test;

public class tsst {
	
		@Test
		public void test() {
			 Scanner sc = new Scanner(System.in);
			 
			 int x = sc.nextInt();
			   
			 String result = "";
			   
			 if(x%4 == 0 && x%100 != 0 || x%400 == 0) {
			     result = "yes";
			 }else {
			     result = "no";
			 }
			 
			 System.out.println(result);
		}
}
