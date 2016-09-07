import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Son extends Thread {
	private ReentrantLock lock;
	private Condition orange;
	private Condition empty;
	private Plate plate = new Plate();

	public Son(ReentrantLock lock, Condition orange, Condition empty,
			Plate plate) {
		this.lock = lock;
		this.orange = orange;
		this.empty = empty;
		this.plate = plate;
	}

	public void r() {
		lock.lock();
		try {
			while (plate.getInfo() != 2)
				orange.await();
			plate.getFruit("Жљзг");
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
