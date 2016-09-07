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
		if(fruit.equals("苹果")){
			return 1;
		}
		else if(fruit.equals("橘子")){
			return 2;
		}
		return 0;
	}
	
	public void setFruit(String fruit) {
		// 实现父母间的互斥
		// lock.lock();
		this.fruit = fruit;
		System.out.println("盘中是" + fruit);
	}

	public void getFruit(String who) {
		System.out.println(who + " 拿走 " + fruit);
		this.fruit = null;
		// lock.unlock();
	}
}
