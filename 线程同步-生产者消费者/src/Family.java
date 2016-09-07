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
		System.out.println("父亲 削好 苹果 ");
		lock.lock();
		try {
			while(plate.getState())//一定要使用while，使用if会发生虚假唤醒情况，虚拟机的问题
				empty.await();
			plate.setFruit("苹果");
			apple.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void mom() {
		System.out.println("母亲 剥好 橘子 ");
		lock.lock();
		try {
			while (plate.getState())
				empty.await();
			plate.setFruit("橘子");
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
			plate.getFruit("女儿");
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
			plate.getFruit("儿子");
			empty.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

}
