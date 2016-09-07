import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Family{
	final static ReentrantLock lock = new ReentrantLock();
	final static Condition apple = lock.newCondition();
	final static Condition orange = lock.newCondition();
	final static Condition empty = lock.newCondition();
	public static Plate plate = new Plate();

	public static void main(String args[]) {
		new Dad().start();
		new Mom().start();
		new Daughter().start();
		new Son().start();
	}

	public static class Dad extends Thread {
		public void run() {
			while (true)
				dad();
		}
	}
	
	static class  Mom extends Thread {
		public void run() {
			while (true)
				mom();
		}
	}

	static class Daughter extends Thread {
		public void run() {
			while (true)
				daughter();
		}
	}

	static class Son extends Thread {
		public void run() {
			while (true)
				son();
		}
	}

	public static void dad() {
		System.out.println("���� ���� ƻ�� ");
		lock.lock();
		try {
			while(plate.getState())//һ��Ҫʹ��while��ʹ��if�ᷢ����ٻ�������������������
				empty.await();
			plate.setFruit("ƻ��");
			apple.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void mom() {
		System.out.println("ĸ�� ���� ���� ");
		lock.lock();
		try {
			while (plate.getState())
				empty.await();
			plate.setFruit("����");
			orange.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void daughter() {
		lock.lock();
		try {
			while (plate.getInfo() != 1)
				apple.await();
			plate.getFruit("Ů��");
			empty.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void son() {
		lock.lock();
		try {
			while (plate.getInfo() != 2)
				orange.await();
			plate.getFruit("����");
			empty.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
