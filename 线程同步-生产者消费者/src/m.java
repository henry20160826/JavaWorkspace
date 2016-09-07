import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class m {
	final static ReentrantLock lock = new ReentrantLock();
	final static Condition apple = lock.newCondition();
	final static Condition orange = lock.newCondition();
	final static Condition empty = lock.newCondition();
	public static Plate plate = new Plate();

	public static void main(String args[]) {
		new Dad(lock, apple, empty, plate).start();
		new Mom(lock, orange, empty, plate).start();
		new Daughter(lock, apple, empty, plate).start();
		new Son(lock, orange, empty, plate).start();
	}
}
