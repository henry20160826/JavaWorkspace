import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest3 extends Thread {
	// ʵ�ֵ��߳�ͬ��
	// һ���߳����н���run�����������̲߳��ܿ�ʼ����run����
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
		// synchronized �����ٽ�����һ���߳��ͷź���һ���̲߳�������
		for (int i = 1; i < 1000; i++) {
			System.out.println("No." + threadNo + ":" + i);
		}
		lock.unlock();
	}
}