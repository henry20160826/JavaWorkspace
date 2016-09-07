import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Daughter extends Thread {
	private ReentrantLock lock;
	private Condition apple;
	private Condition empty;
	private Plate plate = new Plate();

	public Daughter(ReentrantLock lock, Condition apple, Condition empty,
			Plate plate) {
		this.lock = lock;
		this.apple = apple;
		this.empty = empty;
		this.plate = plate;
	}

	public void r() {
		lock.lock();
		try {
			while (plate.getInfo() != 1)
				apple.await();
			plate.getFruit("Å®¶ù");
			empty.signal();
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
