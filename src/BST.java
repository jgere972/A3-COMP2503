import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BST<T extends Comparable<T>> extends BSTNode<T> implements Iterable<T> {
	@Override
	public Iterator<T> iterator() {
		return new BSTIterator<T>(root);
	}

	private class BSTIterator<T> implements Iterator<T>{
		SLL<T> queue;

		public BSTIterator(BSTNode<T> root) {
			queue = new SLL<T>();
			
			
		}
		public void AddToQueue(BSTNode<T> root) {
			if (root == null)
				return;
			else {
				queue.add(inOrderTraversal(root.getLeft()));
				queue.add(root);
				queue.add(inOrderTraversal(root.getRight()));
			}
			
		}

		public boolean hasNext() {
			if(queue == null) {
				return false;
			}else {
				return true;
			}
		}

		@Override
		public T next() {
			return queue.removeNode();
		}
	}
}

class BSTNode<T extends Comparable<T>> {
	private T data;
	private BSTNode<T> left;
	private BSTNode<T> right;

	public BSTNode(T d) {
		setLeft(null);
		setRight(null);
		setData(d);
	}

	public T getData() {
		return data;
	}

	public void setData(T d) {
		data = d;
	}

	public void setLeft(BSTNode<T> l) {
		left = l;
	}

	public void setRight(BSTNode<T> r) {
		right = r;
	}

	public BSTNode<T> getLeft() {
		return left;
	}

	public BSTNode<T> getRight() {
		return right;
	}

	public boolean isLeaf() {
		return (getLeft() == null) && (getRight() == null);
	}

	public int compareTo(BSTNode<T> o) {
		return this.getData().compareTo(o.getData());
	}

	protected BSTNode<T> root;
	private int size;

	public BSTNode() {
		root = null;
		size = 0;
	}

	/**
	 * Return the number of nodes in the tree.
	 */
	public int size() {
		return size;
	}

	/**
	 * Return true if element d is present in the tree.
	 */
	public T find(T d) {
		return find(d, root);
	}

	/**
	 * Add element d to the tree.
	 */
	public void add(T d) {
		BSTNode<T> n = new BSTNode<T>(d);
		if (root == null) {
			size++;
			root = n;
		} else {
			add(root, n);
		}
	}

	/**
	 * Return the height of the tree.
	 */
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

	// Private methods.

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

	/* Do the actual add of node r to tree rooted at n */
	private void add(BSTNode<T> r, BSTNode<T> n) {
		int c = n.compareTo(r);
		if (c < 0) {
			// TODO
			if (r.getLeft() == null) {
				r.setLeft(n);
			} else {
				add(root, n);
			}
		} else {
			if (r.getRight() == null) {
				r.setRight(n);
			} else {
				add(root, n);
			}

		}
	}

	/* Implement a height method. */
	private int height(BSTNode<T> r) {
		int h = -1;
		// TODO
		if (r.isLeaf()) {
			return h;
		} else {
			while (r.getLeft() != null) {
				visit(r);
				h++;
			}
			while (r.getRight() != null) {
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
		// TODO:
		if (r == null)
			return;
		else {
			visit(r);
			preOrderTraversal(r.getLeft());
			preOrderTraversal(r.getRight());
		}
	}

	private void postOrderTraversal(BSTNode<T> r) {
		// TODO:
		if (r == null)
			return;
		else {
			postOrderTraversal(r.getLeft());
			postOrderTraversal(r.getRight());
			visit(r);
		}
	}

	private void levelOrderTraversal(BSTNode<T> r) {
		// TODO:
		// Implement java.Queue
		Queue<BSTNode<T>> list = new LinkedList<>();
		if (r != null) {
			list.add(r);
		}
		while (!list.isEmpty()) {
			BSTNode<T> curr = list.remove();
			visit(curr);
			list.add(curr.getLeft());
			list.add(curr.getRight());
		}

	}
}
