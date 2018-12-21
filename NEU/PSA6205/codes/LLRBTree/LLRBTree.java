
public class LLRBTree {

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private Node root = null;

	private class Node {
		int val;
		Node left, right;
		boolean color;

		public Node(int val) {
			this.val = val;
		}
	}

	private boolean isRed(Node x) {
		if(x == null) return false;
		return x.color == RED;
	}

	private Node leftRotate(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	private Node rightRotate(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	private void flipColor(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}

	public void put(int x) {
		root = put(root, x);
	}

	private Node put(Node n, int x) {
		if(n == null) return new Node(x);
		if(x > n.val) n.right = put(n.right, x);
		else if(x < n.val) n.left = put(n.left, x);
		else n.val = x;

		if(isRed(n.right) && !isRed(n.left)) n = leftRotate(n);
		if(isRed(n.left) && isRed(n.left.left)) n = rightRotate(n);
		if(isRed(n.left) && isRed(n.right)) flipColor(n);

		return n;
	}

	public static void demo() {
		LLRBTree tree = new LLRBTree();
		tree.put(50);
		tree.put(23);
		tree.put(60);
	}
}



