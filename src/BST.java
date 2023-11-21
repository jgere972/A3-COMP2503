import java.util.Comparator;
import java.util.LinkedList;

public class BST<T extends Comparable<T>> {
	private BSTNode<T> root;
	private int size;
	
	public BST() {
		root = null;
		size = 0;
	}
	
	public BST(Comparator<T> comparator) {
		
	}
	
	public int size() {
		return size;
	}
	
	public T find(T d) {
		return find(d, root);
	}
	
	public void add(T d) {
		BSTNode<T> n = new BSTNode<T>(d);
		if (root == null) {
			size++;
			root = n;
		} else {
			add(root, n);
		}
	}
	
	public int height() {
		return height(root);
	}

	public void printInOrder() {
		inOrderTraversal(root);
	}

	public void printPreOrder() {
		preOrderTraversal(root);
	}

	public void printPostOrder() {
		postOrderTraversal(root);
	}

	public void printLevelOrder() {
		levelOrderTraversal(root);
	}
	
	private T find(T d, BSTNode<T> r) {
		if (r == null)
			return null;
		int c = d.compareTo(r.getData());
		if (c == 0)
			return r.getData();
		else if (c < 0)
			return find(d, r.getLeft());
		else
			return find(d, r.getRight());
	}
	
	private void add(BSTNode<T> r, BSTNode<T> n) {
		int c = n.getData().compareTo(r.getData());
		if (c < 0) {
			if(r.getLeft() == null)
				r.setLeft(n);
			else
				add(root.getLeft(),n);
		}
		else {
			if(r.getRight() == null)
				r.setRight(n);
			else
				add(root.getRight(),n);			
		}
	}
	
	private int height(BSTNode<T> r) {
		int h = -1;
		if(r.isLeaf())
			return h;
		else {
			while(r.getLeft() != null) {
				visit(r);
				h++;
			}
			while(r.getRight() != null) {
				visit(r);
				h++;
			}
		}
		return h;
	}
	
	private void visit(BSTNode<T> r) {
		if (r != null)
			System.out.println(r.getData());
	}

	private void inOrderTraversal(BSTNode<T> r) {
		if (r == null)
			return;
		else {
			inOrderTraversal(r.getLeft());
			visit(r);
			inOrderTraversal(r.getRight());
		}
	}

	private void preOrderTraversal(BSTNode<T> r) {
		if (r == null)
			return;
		else {
			visit(r);
			preOrderTraversal(r.getLeft());
			preOrderTraversal(r.getRight());
		}
	}

	private void postOrderTraversal(BSTNode<T> r) {
		if (r == null)
			return;
		else {
			postOrderTraversal(r.getLeft());
			postOrderTraversal(r.getRight());
			visit(r);
		}
	}

	private void levelOrderTraversal(BSTNode<T> r) {
//		Queue<BSTNode<T>> list = new LinkedList<>();
//		if(r != null)
//			list.add(r);
//		while(!list.isEmpty()) {
//			BSTNode<T> curr = list.remove();
//			visit(curr);
//			list.add(curr.getLeft());
//			list.add(curr.getRight());
//		}
	}
}