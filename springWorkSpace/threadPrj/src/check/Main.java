package check;

public class Main {

	public static void main(String[] args) {
		
		Thread t = Thread.currentThread(); //���� ������ ������ �� ����
		
		t.setName("cbj");
		t.setPriority(10); //���ڰ� �������� �켱������ ���� (1~10) // Thread.MAX,MIN,NORM_PRIORITY
		
		String name = t.getName();
		long id = t.getId();
		int proirity = t.getPriority();
		System.out.println("name ::: " + name);
		System.out.println("id ::: " + id);
		System.out.println("proirity ::: " + proirity);
		
	}

}
