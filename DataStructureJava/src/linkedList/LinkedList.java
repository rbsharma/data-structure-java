package linkedList;

class Node {
	int data;
	Node next;

	public Node(int _data) {
		data = _data;
		next = null;
	}
}

public class LinkedList {
	Node head = new Node(1);

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Node second = new Node(2);
		Node third = new Node(3);

		list.head.next = second;
		second.next = third;

		list.Push(0);
		list.Append(4);
		list.InsertAfter(third, 5);
		list.DeleteNode(4);
		list.DeleteNodeAt(0);
		list.Delete();
		list.PrintList();
	}

	public void Delete() {
		head = null;
	}

	public void DeleteNode(int key) {
		if (head == null) {
			return;
		}
		if (head.data == key) {
			head = head.next;
			return;
		}

		Node current = head;
		while (current.next != null) {
			if (current.next.data == key) {
				Node temp = current.next.next;
				current.next.next = null;
				current.next = temp;

				return;
			}
			current = current.next;
		}
		return;
	}

	public void DeleteNodeAt(int position) {
		if (head == null) {
			return;
		}
		if (position == 0) {
			head = head.next;
			return;
		}

		Node temp = head;
		int counter = 0;
		while (counter < position - 1 && temp != null) {
			temp = temp.next;
			if (temp == null || temp.next == null) {
				return;
			}
			counter++;
		}
		temp.next = temp.next.next;
	}

	public void Push(int newData) {
		Node newNode = new Node(newData);
		newNode.next = head;
		head = newNode;
	}

	public void Append(int newData) {
		Node newNode = new Node(newData);
		if (head == null) {
			head = newNode;
			return;
		}

		Node last = head;
		while (last.next != null) {
			last = last.next;
		}

		last.next = newNode;
		return;
	}

	public void InsertAfter(Node prev_Node, int newData) {
		if (prev_Node == null) {
			System.out.println("Previous node cannot be null");
			return;
		}
		Node newNode = new Node(newData);
		newNode.next = prev_Node.next;
		prev_Node.next = newNode;
	}

	public void PrintList() {
		System.out.println("Linked List : ");
		Node node = head;
		while (node != null) {
			System.out.println(node.data);
			node = node.next;
		}
	}

}