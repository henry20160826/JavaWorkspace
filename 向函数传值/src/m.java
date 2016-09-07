public class m {
	public String s;
	public int a;
	public m(String s,int a)
	{
		this.s=s;
		this.a=a;
	}
	public static void main(String args[]) {
		String s=new String("hi");
		int a=10;
		m newm=new m(s,a);
		
		//m中的值改变，外面的值不变
//		newm.print();
//		System.out.println("out's is:"+s+",out'a is:"+a);
		
		s="new hi";
		a=110;
		newm.print1();
		//外面值改变，m中值不变
	}
	public void print()
	{
		s="new hi";
		a=110;
		System.out.println("m's is:"+s+",m'a is:"+a);
	}
	
	public void print1()
	{
		System.out.println("m's is:"+s+",m'a is:"+a);
	}
}
