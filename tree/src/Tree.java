public class Tree {
	public Node root;

	// ����
	// ����
	public void find() {
	}

	// ɾ��
	public void delete() {
	}

	// �����������
	public void preOrder() {
		preOrder(root);
	}

	public void preOrder(Node localRoot) {
		if (localRoot != null) {
			localRoot.displayNode();// ��������ڵ�
			preOrder(localRoot.left);// ��������������������
			preOrder(localRoot.right);// ��������������������
		}
	}

	// �����������
	public void inOrder() {
		inOrder(root);
	}

	public void inOrder(Node localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.left);// ��������������������
			localRoot.displayNode();// ��������ڵ�
			inOrder(localRoot.right);// ��������������������
		}
	}

	// �����ӽڵ�
	public void insert(int iData) {
		Node newNode = new Node(iData);

		if (root == null)
			root = newNode;
		else {
			Node current = root;
			Node parent;
			while (true)// Ѱ�Ҳ����λ��
			{
				parent = current;
				if (iData < current.iData) {
					current = current.left;
					if (current == null) {
						parent.left = newNode;
						return;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}

	// ��Ҷ������
	public int getLeafNum() {
		return getLeafNum(root);
	}

	public int getLeafNum(Node node) {
		int leafNum = 0, left = 0, right = 0;
		if (node != null) {
			if (node.left == null && node.right == null) {
				leafNum++;
			} else {
				left = getLeafNum(node.left);
				right = getLeafNum(node.right);
			}
			leafNum += left + right;
			System.out.println("node:" + node.iData + ",leafNum:" + leafNum);
			return leafNum;
		}
		return 0;
	}

	// ������
	public int getHeight() {
		return getHeight(root);
	}

	public int getHeight(Node node) {
		int height = 0, left = 0, right = 0;
		if (node != null) {
			left = getHeight(node.left);
			right = getHeight(node.right);
			height++;
		}
		else{
			return 0;
		}
		height += left>right?left:right;
		System.out.println("node:" + node.iData + ",Height:" + height);
		return height;
	}
}
