public class Partition {
	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(0);
		Node f = new Node(-2);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		int k = 2;
		Node result = reorderByNode(a, k);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
		
	}
	public static class Node {
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
			next = null;
		}
	}
	public static Node reorderByNode (Node node, int pivot) {
		Node head = node;
		Node tail = node;
		while (node != null) {
			Node next = node.next;
			if (node.val < pivot) {
				node.next = head;
				head = node;
			}
			else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;
	}
}
