public class SumLists {
	public static class Node {
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
			next = null;
		}
	}
	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(0);
		Node f = new Node(9);
		a.next = b;
		b.next = c;
		
		d.next = e;
		e.next = f;

		SumLists computer = new SumLists();
		Node result = computer.add(a, d);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	public Node add(Node l1, Node l2) {
		//pad l1 or l2
		int len1 = length(l1);
		int len2 = length(l2);
		if (len1 < len2) {
			l1 = padList(l1, len2 - len1);
		}
		else {
			l2 = padList(l2, len1 - len2);
		}

		//merge
		PartialSum sum =  merge(l1, l2);

		//append carry
		if (sum.carry == 0) {
			return sum.sum;
		}
		else {
			Node result = addBefore(sum.sum, sum.carry);
			return result;
		}

	}

	public PartialSum merge(Node n1, Node n2) {
		if (n1 == null && n2 == null) {
			PartialSum sum = new PartialSum();
			return sum;
		}
		PartialSum sum = merge(n1.next, n2.next);
		int val = sum.carry + n1.val + n2.val;
		Node full_result = addBefore(sum.sum, val % 10);
		sum.sum = full_result;
		sum.carry = val / 10;
		return sum;
	}

	public int length(Node n) {
		int count = 0;
		while (n != null) {
			n = n.next;
			count++;
		}
		return count;
	}

	public Node padList(Node n, int padCount) {
		Node head = n;
		for (int i = 0; i < padCount; i++) {
			head = addBefore(head, 0);
		}
		return head;
	}

	public Node addBefore(Node n, int val) {
		Node nodeBefore = new Node(val);
		if (n != null) {
			nodeBefore.next = n;
		}
		return nodeBefore;
	}

	public class PartialSum {
		Node sum = null;
		int carry = 0;
	}
}