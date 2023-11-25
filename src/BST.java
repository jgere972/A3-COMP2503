import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BST<T extends Comparable<T>> implements Iterable<T>{
	private BSTNode<T> root;
	private int size;
	
	public BST() {
		root = null;
		size = 0;
	}
	
	public BST(Comparator<T> comparator) {
		root = null;
		size = 0;
	}
	
	public int size() {
		return counter(root);
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
			size++;
			add(root, n);
		}
	}
	
	public void add(T d, Comparator<T> comp) {
		BSTNode<T> n = new BSTNode<T>(d);
		if (root == null) {
			size++;
			root = n;
		} else {
			size++;
			add(root, n, comp);
		}
	}
	
	public void delete(T d) {
		root = delete(root, d);
	}
	
	public int height() {
		return height(root);
	}
	
	public int optimalHeight(int n) {
		return (int) Math.ceil(Math.log(n + 1) / Math.log(2) - 1);
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
		if (r == null || d == null) return null;
		int c = d.compareTo(r.getData());
		if (c == 0) return r.getData();
		else if (c < 0) return find(d, r.getLeft());
		else return find(d, r.getRight());
	}
	
	private void add(BSTNode<T> r, BSTNode<T> n) {
        if (r == null) {
            r = n;
            return;
        }
        int c = n.compareTo(r);
        if (c < 0) {   
            if (r.getLeft() == null) r.setLeft(n);
            else add(r.getLeft(), n);
        }
        else {
            if (r.getRight() == null) r.setRight(n);
            else add(r.getRight(), n);
        }
	}
	
	private void add(BSTNode<T> r, BSTNode<T> n, Comparator<T> comp) {
        if (r == null) {
            r = n;
            return;
        }
        int c = comp.compare(n.getData(), r.getData());
        if (c < 0) {   
            if (r.getLeft() == null) r.setLeft(n);
            else add(r.getLeft(), n, comp);
        }
        else {
            if (r.getRight() == null) r.setRight(n);
            else add(r.getRight(), n, comp);
        }
	}
	
	private BSTNode<T> delete(BSTNode<T> r, T d) {
	    if (r == null) return null;
	    int c = d.compareTo(r.getData());
	    if (c < 0) r.setLeft(delete(r.getLeft(), d));
	    else if (c > 0) r.setRight(delete(r.getRight(), d));
	    else {
	        if (r.getLeft() == null) return r.getRight();
	        else if (r.getRight() == null) return r.getLeft();
	        r.setData(minValue(r.getRight()));
	        r.setRight(delete(r.getRight(), r.getData()));
	    }
	    return r;
	}
	
	private T minValue(BSTNode<T> root) {
	    T minValue = root.getData();
	    while (root.getLeft() != null) {
	        minValue = root.getLeft().getData();
	        root = root.getLeft();
	    }
	    return minValue;
	}
	
	private int counter(BSTNode<T> r) {
		int count = 0;
		if (r == null) return count;
		int leftCount = counter(r.getLeft());
		int rightCount = counter(r.getRight());
		return leftCount + rightCount + 1;
	}
	
	private int height(BSTNode<T> r) {
		int h = -1;

        if (r == null) return h;
        else {
            int left = height(r.getLeft());
            left ++;
            int right = height(r.getRight());
            right ++;

            if (left > right) h = left;
            else if (left < right) h = right;
            else h = left;
        }
        return h;
	}
	
	private void visit(BSTNode<T> r) {
		if (r != null) System.out.println(r.getData());
	}

	private void inOrderTraversal(BSTNode<T> r) {
		if (r == null) return;
		else {
			inOrderTraversal(r.getLeft());
			visit(r);
			inOrderTraversal(r.getRight());
		}
	}

	private void preOrderTraversal(BSTNode<T> r) {
		if (r == null) return;
		else {
			visit(r);
			preOrderTraversal(r.getLeft());
			preOrderTraversal(r.getRight());
		}
	}

	private void postOrderTraversal(BSTNode<T> r) {
		if (r == null) return;
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

	private Queue<T> queue = new LinkedList<T>();
	
	private void addToQueue(BSTNode<T> root) {
		if (root != null) queue.add(root.getData());
	}
	
	public static final int INORDER = 0;
	public static final int PREORDER = 1;
	public static final int POSTORDER = 2;
	public static final int LEVELORDER = 3;
	
	public void traverse(int traversalType) {
		traverse(root, traversalType);
	}
	
	private void traverse(BSTNode<T> root, int traversalType) {
		if (root == null) return;
		else {
			switch(traversalType) {
			case INORDER: 
				traverse(root.getLeft(), traversalType);
				addToQueue(root);
				traverse(root.getRight(), traversalType);
				break;
			case PREORDER:
				addToQueue(root);
				traverse(root.getLeft(), traversalType);
				traverse(root.getRight(), traversalType);
				break;
			case POSTORDER:
				traverse(root.getLeft(), traversalType);
				traverse(root.getRight(), traversalType);
				addToQueue(root);
				break;
			}
		}
	}
	
	@Override
	public Iterator<T> iterator() {
		return new BSTIterator();
	}
	
	public class BSTIterator implements Iterator<T> {
		public BSTIterator() {
			queue.clear();
			traverse(root, INORDER);
		}
		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}
		@Override
		public T next() {
			return queue.remove();
		}
	}
}