package check;

public class Main {

	public static void main(String[] args) {
		
		Thread t = Thread.currentThread(); //현재 스레드 가져올 수 있음
		
		t.setName("cbj");
		t.setPriority(10); //숫자가 높을수록 우선순위가 높다 (1~10) // Thread.MAX,MIN,NORM_PRIORITY
		
		String name = t.getName();
		long id = t.getId();
		int proirity = t.getPriority();
		System.out.println("name ::: " + name);
		System.out.println("id ::: " + id);
		System.out.println("proirity ::: " + proirity);
		
	}

}
