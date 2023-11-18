
public class SLL<T>{
	private class Node<T> {
		private T data;
		private Node<T> next;

		/**
		 * Constructor for objects of class Node
		 */
		public Node(T d) {
			data = d;
			next = null;
		}

		public T getData() {
			return data;
		}

		public void setData(T o) {
			data = o;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> n) {
			next = n;
		}

		public String toString() {
			return "Node: " + getData().toString();
		}
	}
	private Node<T> head, tail;
	private int size;

	public SLL() {
		head = null;
		tail = null;
		size = 0;
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
	public boolean Empty() {
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
	 * Return tail value
	 * 
	 * @return tail value, null if list is empty
	 */
	public T getTail() {
		if (tail == null)
			return null;
		else
			return tail.getData();
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

	/**
	 * Return the ith element of the list.
	 * 
	 * @param i the element to return
	 * @return the ith element, null if there isnt one.
	 */
	public T get(int i) {
		Node<T> curr = head;
		int j = 0;
		while (curr != null && j < i) {
			curr = curr.getNext();
			j++;
		}
		if (curr != null)
			return curr.getData();
		else
			return null;
	}
	/**
	 * Finding a node
	 * 
	 * @param str The data to find
	 * @return the node found
	 */
	public Node<T> find(Node<T> str) {
		return finding(str);
	}
	
	/**
	 * Delete a node 
	 * 
	 * @param str The key used to identify and delete node
	 * @return the node saved before deletion
	 */
	public Node<T> delete(Node<T> key) {
		return deleting(key);
	}
	
	public boolean exist(T key) {
		return exists(key);
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
	
	public SLL<T> getNext(){
		return getNextNode();
	}
	
	public Node<T> getData(){
		return getData();
	}
	public void setNext(SLL <T> n) {
		setNext(n);
	}
	
	/*
	 * Add a new Node to the tail of the list.
	 */
	private void addTailInternal(Node<T> n) {
		if(Empty()) {
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
	/*
	 * Finding a node using a key
	 */
	private boolean exists(T key) {
		Node<T> curr = head;
		while (curr != null) {
			if (curr == key) {
				return true;
			} else {
				curr = curr.getNext();
			}
		}
		return false;
	}
	/*
	 * Finding a node using a key
	 */
	private Node<T> finding(Node<T> key) {
		Node<T> curr = head;
		while (curr != null) {
			if (curr.getData() == key.getData()) {
				return curr;
			} else {
				curr = curr.getNext();
			}
		}
		return null;
	}
	/*
	 * Deleting a node identified with a key
	 */
	private Node<T> deleting(Node <T> key) {
		// implement delete
		if (finding(key) != null) { //Does key match any of the Strings in the List of Nodes?
			Node<T> nodeToDelete = finding(key);	
			Node<T> curr = head;
			while (curr.getNext() != null && !(curr.getNext().getData().equals(nodeToDelete.getData()))) { 
				//Stop when String in the Node after curr equals to String in nodeToDelete
				curr = curr.getNext();
				
			}
			Node<T> nodeDeleted = curr.getNext();
			curr.setNext(curr.getNext().getNext());
			return nodeDeleted;
		} else {
			return null;
		}
	}
	
	private SLL<T> getNextNode(){
		return getNext();
	}
	
}
