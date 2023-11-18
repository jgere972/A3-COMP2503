
public interface Queue<T> {
	public void add(NodeForQueue<T> data);
	public NodeForQueue<T> remove();
	public int size();
	public boolean isEmpty();
}
