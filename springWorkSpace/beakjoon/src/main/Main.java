package main;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		
		// A B C �ް� ����ϱ�
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		int result = a*b*c;
		
		int[] memo = new int[10];
		
		// ������ ���� �ϳ��� �������� (/, %)
		while(result != 0) {
			//�� �� ���� ��������
			int num = result % 10;
			//�� �� ���� ���ֱ�
			result = result / 10;
			// ����ϱ� (int[] memo = new int[10]) memo[���� ������ ����]++;
			memo[num]++;
		}
		
		// ����� ���� ���
		for(int i = 0; i < memo.length; i++) {
			System.out.println(memo[i]);
		}
		
	}

}