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
		
		//m�е�ֵ�ı䣬�����ֵ����
//		newm.print();
//		System.out.println("out's is:"+s+",out'a is:"+a);
		
		s="new hi";
		a=110;
		newm.print1();
		//����ֵ�ı䣬m��ֵ����
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
