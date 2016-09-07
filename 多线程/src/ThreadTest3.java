import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest3 extends Thread {
	// 实现的线程同步
	// 一个线程运行结束run方法后，其他线程才能开始运行run方法
	private int threadNo;
	private ReentrantLock lock;

	public ThreadTest3(int threadNo, ReentrantLock lock) {
		this.threadNo = threadNo;
		this.lock = lock;
	}

	public static void main(String[] args) throws Exception {
		ReentrantLock lock = new ReentrantLock();
		for (int i = 1; i < 10; i++) {
			new ThreadTest3(i, lock).start();
			Thread.sleep(1);
		}
	}

	public void run() {
		lock.lock();
		// synchronized 中是临界区，一个线程释放后另一个线程才能运行
		for (int i = 1; i < 1000; i++) {
			System.out.println("No." + threadNo + ":" + i);
		}
		lock.unlock();
	}
}