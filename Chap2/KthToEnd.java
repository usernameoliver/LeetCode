public class KthToEnd {
	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		a.next = b;
		b.next = c;
		c.next = d;
		int k = 3;
		Node result = getkthNodeFromEnd(a, k);
		System.out.println(result.val);
	}

	public static Node getkthNodeFromEnd(Node head, int k) {
		Node first = head;
		Node second = head;
		for (int i = 0; i < k; i++) {
			if (first == null)	return head;
			first = first.next;
		}
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		return second;
	}
	public static class Node {
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
			next = null;
		}
	}
}
