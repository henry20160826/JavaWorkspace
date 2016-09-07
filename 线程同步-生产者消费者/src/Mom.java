import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Mom extends Thread {
	private ReentrantLock lock;
	private Condition orange;
	private Condition empty;
	private Plate plate = new Plate();

	public Mom(ReentrantLock lock, Condition orange, Condition empty,
			Plate plate) {
		this.lock = lock;
		this.orange = orange;
		this.empty = empty;
		this.plate = plate;
	}

	public void r() {
		System.out.println("Ä¸Ç× °þºÃ éÙ×Ó ");
		lock.lock();
		try {
			while (plate.getState())
				empty.await();
			plate.setFruit("éÙ×Ó");
			orange.signal();
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
