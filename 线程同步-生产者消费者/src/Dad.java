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
		System.out.println("���� ���� ƻ�� ");
		lock.lock();
		try {
			while (plate.getState())
				// һ��Ҫʹ��while��ʹ��if�ᷢ����ٻ�������������������
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

	public void run() {
		while (true)
			r();
	}
}
