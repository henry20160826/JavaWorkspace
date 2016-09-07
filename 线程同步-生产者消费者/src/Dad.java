import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Dad extends Thread {
	private ReentrantLock lock;
	private Condition apple;
	private Condition empty;
	private Plate plate;

	public Dad(ReentrantLock lock, Condition apple, Condition empty, Plate plate) {
		this.lock = lock;
		this.apple = apple;
		this.empty = empty;
		this.plate = plate;
	}

	public void r() {
		System.out.println("父亲 削好 苹果 ");
		lock.lock();
		try {
			while (plate.getState())
				// 一定要使用while，使用if会发生虚假唤醒情况，虚拟机的问题
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

	public void run() {
		while (true)
			r();
	}
}
