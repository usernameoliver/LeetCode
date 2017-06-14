import java.util.Stack;
public class StackMin {
	public static void main(String[] args) {
		StackMin minStack = new StackMin();
		minStack.push(2);
		minStack.push(5);
		minStack.push(3);
		int result = minStack.getMin();
		System.out.println(result);
		minStack.push(7);
		minStack.push(0);
		result = minStack.getMin();
		System.out.println(result);
	}
	private Stack<Integer> orderStack;
	private Stack<Integer> smallStack;
	public StackMin() {
		orderStack = new Stack<>();
		smallStack = new Stack<>();
	}

	public void push(int num) {

		orderStack.push(num);
		if (!smallStack.isEmpty()) {
			int smallest = smallStack.peek();
			if (num < smallest) {
				smallStack.push(num);
			}
			else {
				smallStack.push(smallest);
			}
		}
		else {
			smallStack.push(num);
		}
		

	}

	public int pop() {
		if (orderStack.isEmpty())	return -1;
		int number = orderStack.pop();
		int currentSmallest = smallStack.pop();
		return number;
	}

	public int getMin() {
		if (orderStack.isEmpty())	return -1;
		int currentSmallest = smallStack.peek();
		return currentSmallest;
	}


}