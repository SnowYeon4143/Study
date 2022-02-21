package main;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		
		// A B C 받고 계산하기
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int result = a*b*c;
		
		int[] memo = new int[10];
		
		// 수에서 숫자 하나씩 가져오기 (/, %)
		while(result != 0) {
			//맨 뒤 숫자 가져오기
			int num = result % 10;
			//맨 뒤 숫자 없애기
			result = result / 10;
			// 기록하기 (int[] memo = new int[10]) memo[내가 가져온 숫자]++;
			memo[num]++;
		}
		
		// 기록한 내용 출력
		for(int i = 0; i < memo.length; i++) {
			System.out.println(memo[i]);
		}
		
	}

}