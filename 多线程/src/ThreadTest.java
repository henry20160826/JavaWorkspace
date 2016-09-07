public class ThreadTest extends Thread {
	//没有实现线程同步
	//不同线程有不同的run方法，每个run方法可以独立执行
	private int threadNo;

	public ThreadTest(int threadNo) {
		this.threadNo = threadNo;
	}

	public static void main(String[] args) throws Exception {
		for (int i = 1; i < 10; i++) {
			new ThreadTest(i).start();
			Thread.sleep(1);
		}
	}

	@Override
	public synchronized void run() {
		for (int i = 1; i < 1000; i++) {
			System.out.println("No." + threadNo + ":" + i);
		}
	}
}