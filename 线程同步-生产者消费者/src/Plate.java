public class Plate {

	public String fruit;

	public Plate() {
	}

	public boolean getState() {
		if(fruit!=null)
			return true;
		return false;
	}

	public int getInfo(){
		if(fruit==null)
			return 0;
		if(fruit.equals("ƻ��")){
			return 1;
		}
		else if(fruit.equals("����")){
			return 2;
		}
		return 0;
	}
	
	public void setFruit(String fruit) {
		// ʵ�ָ�ĸ��Ļ���
		// lock.lock();
		this.fruit = fruit;
		System.out.println("������" + fruit);
	}

	public void getFruit(String who) {
		System.out.println(who + " ���� " + fruit);
		this.fruit = null;
		// lock.unlock();
	}
}
