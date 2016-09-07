

public class main{
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] a={8,4,3,5,13,15};
		
		Tree tree=new Tree();
		for(int i=0;i<5;i++){
			tree.insert(a[i]);
		}
		tree.preOrder();
		
		System.out.println("LeafNum:"+tree.getLeafNum());
		System.out.println("Height:"+tree.getHeight());
	}
}
