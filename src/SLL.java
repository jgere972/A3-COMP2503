public class SLL<T> implements customQueue<T>{
	public T removeNode() {
		return deleteHead();
	}
		
	
	public void add(T t) {
		addTail(t);
	}
	
	private Node<T> head, tail;
	private int size;

	public SLL(BSTNode<T> root) {
		head = null;
		addTail(root.getData());
		size = 1;
	}

	// Public Methods

	/**
	 * Return the number of elements in the list.
	 * 
	 * @return int number of elements in the list.
	 */
	public int size() {
		int size = 0;
		Node<T> curr = head;
		while(curr != null) {
			curr = curr.getNext();
			size++;
		}
		return size;
	}
	
	/**
	 * Checking if List is empty
	 * @return boolean value to check if linked List is empty
	 */
	public boolean isEmpty() {
		return(head == null && tail == null || size() == 0);
	}

	/**
	 * Empty the list.
	 */
	public void emptyList() {
		head = null;
		tail = null;
		size = 0;
	}

	/**
	 * Add a new object t to the head of the list.
	 * 
	 * @param t the object to add.
	 */
	public void addHead(T t) {
		addHead(new Node<T>(t));
	}
	/**
	 * Add a new object t to the tail of the list.
	 * 
	 * @param t the object to add.
	 */
	public void addTail(T t) {
		addTail(new Node<T>(t));
	}
	

	/**
	 * Return head value
	 * 
	 * @return head value, null if list is empty
	 */
	public Node <T> getHead() {
		if (head == null)
			return null;
		else
			return head;
	}

	/**
	 * Delete the element at the head of the list.
	 * 
	 * @return the deleted element.
	 */
	public T deleteHead() {
		Node<T> n = delHead();
		if (n == null)
			return null;
		else
			return n.getData();
	}
	
	public void setHead(Node<T> newNode) {
	    setToHead(newNode);
	 }

				// Private methods
	private void setToHead(Node<T> newNode) {
	    if (newNode != null) {
	        newNode.setNext(newNode); // Set the next of the new node to the current head
	        head = newNode; // Update the head to be the new node
	    }
	 }
	
	/*
	 * Add a new Node to the head of the list.
	 */
	public void addHead(Node<T> n) {
		if (head == null) // empty list
		{
			head = n;
			tail = n;
		} else {
			n.setNext(head);
			head = n;
		}
		size++;
	}
	public void addTail(Node<T> n) {
		addTailInternal(n);
	}
	
	public Node<T> getNext(){
		return getNextNode();
	}
	
	public T getData(){
		return getData();
	}
	public void setNext(SLL <T> n) {
		setNext(n);
	}
	
	/*
	 * Add a new Node to the tail of the list.
	 */
	private void addTailInternal(Node<T> n) {
		if(isEmpty()) {
			addHead(n);
		}else {
			tail.setNext(n);
			tail = n;
		}	
	}

	/*
	 * Delete the node at the head of the list and return a pointer to it.
	 */
	private Node<T> delHead() {
		Node<T> n = null;
		if (head != null) {
			n = head;
			head = head.getNext();
			size--;
		}
		return n;
	}
	
	private Node<T> getNextNode(){
		return getNext();
	}
	
}