
//
public class Node {
	public int iData;
	public Node left;
	public Node right;

	// ����
	public Node(int iData) {
		this.iData = iData;
	}

	public void displayNode() {
		System.out.println("��� ��������Ϊ��" + iData);
	}
}