
public interface Queue<T> {
	public void add(Node<T> data);
	public Node<T> remove();
	public int size();
	public boolean isEmpty();
}
