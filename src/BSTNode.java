
public class BSTNode<T extends Comparable<T>> implements Comparable<BSTNode<T>> {
	private T data;
	private BSTNode<T> left;
	private BSTNode<T> right;

	public BSTNode(T d) {
		this.data = d;
		this.left = null;
		this.right = null;
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

	public int compareTo(T o) {
		return this.compareTo(o);
	}

	@Override
	public int compareTo(BSTNode<T> o) {
		return this.data.compareTo(o.getData());
	}
}

