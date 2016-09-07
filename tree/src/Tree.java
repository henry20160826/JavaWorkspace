public class Tree {
	public Node root;

	// 方法
	// 查找
	public void find() {
	}

	// 删除
	public void delete() {
	}

	// 先序遍历方法
	public void preOrder() {
		preOrder(root);
	}

	public void preOrder(Node localRoot) {
		if (localRoot != null) {
			localRoot.displayNode();// 访问这个节点
			preOrder(localRoot.left);// 调用自身来遍历左子树
			preOrder(localRoot.right);// 调用自身来遍历右子树
		}
	}

	// 中序遍历方法
	public void inOrder() {
		inOrder(root);
	}

	public void inOrder(Node localRoot) {
		if (localRoot != null) {
			inOrder(localRoot.left);// 调用自身来遍历左子树
			localRoot.displayNode();// 访问这个节点
			inOrder(localRoot.right);// 调用自身来遍历右子树
		}
	}

	// 插入子节点
	public void insert(int iData) {
		Node newNode = new Node(iData);

		if (root == null)
			root = newNode;
		else {
			Node current = root;
			Node parent;
			while (true)// 寻找插入的位置
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

	// 求叶结点个数
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

	// 求树高
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
