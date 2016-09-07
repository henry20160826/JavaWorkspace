
public class ThreadTest2 extends Thread {
	// ʵ�ֵ��߳�ͬ��
	// һ���߳����н���run�����������̲߳��ܿ�ʼ����run����
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
			// synchronized �����ٽ�����һ���߳��ͷź���һ���̲߳�������
			System.out.println("No." + threadNo + ":" + lock);
			for (int i = 1; i < 1000; i++) {
				System.out.println("No." + threadNo + ":" + i);
			}
		}
	}
}