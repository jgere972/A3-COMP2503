public class NodeForQueue<T> {

	private T data;
	private NodeForQueue<T> next;

	/**
	 * Constructor for objects of class Node
	 */
	public NodeForQueue(T d) {
		data = d;
		next = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T o) {
		data = o;
	}

	public NodeForQueue<T> getNext() {
		return next;
	}

	public void setNext(NodeForQueue<T> n) {
		next = n;
	}

	public String toString() {
		return "Node: " + getData().toString();
	}
}