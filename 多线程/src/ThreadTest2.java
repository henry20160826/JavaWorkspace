
public class ThreadTest2 extends Thread {
	// 实现的线程同步
	// 一个线程运行结束run方法后，其他线程才能开始运行run方法
	private int threadNo;
	private String lock;

	public ThreadTest2(int threadNo, String lock) {
		this.threadNo = threadNo;
		this.lock = lock;
	}

	public static void main(String[] args) throws Exception {
		String lock = new String("lock");
		for (int i = 1; i < 10; i++) {
			new ThreadTest2(i, lock).start();
			Thread.sleep(1);
		}
	}

	public void run() {
		synchronized (lock) {
			// synchronized 中是临界区，一个线程释放后另一个线程才能运行
			System.out.println("No." + threadNo + ":" + lock);
			for (int i = 1; i < 1000; i++) {
				System.out.println("No." + threadNo + ":" + i);
			}
		}
	}
}