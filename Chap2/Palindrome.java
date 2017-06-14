public class Palindrome {
	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(5);
		Node e = new Node(1);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		Palindrome pldrm = new Palindrome();
		boolean result = pldrm.isPalindrome(a);
		System.out.println(result);
	}
	public static class Node {
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
			next = null;
		}
	}

	public boolean isPalindrome(Node n) {
		Node m = reverseList(n);
		boolean isIdentical = isSameList(m, n);
		return isIdentical;
	}
	public Node reverseList(Node n) {
		Node pre = new Node(n.val);
		pre.next = null;
		while (n.next != null) {
			n = n.next;
			Node next = new Node(n.val);
			next.next = pre;
			pre = next;
		}
		return pre;
	}

	public boolean isSameList(Node m, Node n) {
		while (m != null) {
			if (m.val != n.val) {
				return false;
			}
			m = m.next;
			n = n.next;
		}
		return true;
	} 
}
