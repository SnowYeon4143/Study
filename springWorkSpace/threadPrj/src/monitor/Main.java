package monitor;

public class Main {
	
	public static void main(String[] args) {
		
		//������ 2�� �����
		//���� �޼ҵ� a, b ��� ȣ���ϱ�
		
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
		
		//�������� ����
		// new, runnable, wait, ����
		
		
	}
	
}
