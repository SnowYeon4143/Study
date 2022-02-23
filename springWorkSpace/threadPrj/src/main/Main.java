package main;

public class Main {
	public static void main(String[] args) {
		
		//스레드 생성
		
		// 방법1
//		Runnable r = new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("내가 만든 스레드 ~~~");
//			}
//		};
//		Thread t = new Thread(r);
//		t.start();
		
		// 방법2
//		Thread t = new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("변수 안만들고 바로 넣음");
//			}
//		});
//		t.start();
		
		// 방법3
		Thread t = new Thread( () -> {System.out.println("람다식으로 만들어봄 ㅋㅋ");} );
		t.start();
		
		
		
		
		
	}//main
}
