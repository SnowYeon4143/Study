package main;

public class Main {
	public static void main(String[] args) {
		
		//������ ����
		
		// ���1
//		Runnable r = new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("���� ���� ������ ~~~");
//			}
//		};
//		Thread t = new Thread(r);
//		t.start();
		
		// ���2
//		Thread t = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("���� �ȸ���� �ٷ� ����");
//			}
//		});
//		t.start();
		
		// ���3
		Thread t = new Thread( () -> {System.out.println("���ٽ����� ���� ����");} );
		t.start();
		
		
		
		
		
	}//main
}
