
//
public class Node {
	public int iData;
	public Node left;
	public Node right;

	// 方法
	public Node(int iData) {
		this.iData = iData;
	}

	public void displayNode() {
		System.out.println("这个 结点的数据为：" + iData);
	}
}