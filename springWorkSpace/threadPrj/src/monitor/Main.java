package monitor;

public class Main {
	
	public static void main(String[] args) {
		
		//스레드 2개 만들고
		//각각 메소드 a, b 계속 호출하기
		
		Worker worker = new Worker();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {Thread.sleep(1000);} catch (InterruptedException e) {}
					worker.methodA();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {Thread.sleep(1000);} catch (InterruptedException e) {}
					worker.methodB();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		//스레드의 상태
		// new, runnable, wait, 종료
		
		
	}
	
}
