package stack;

public class StackArray {
	static final int MAX = 2;
	int[] ar = new int[MAX];
	int top;

	StackArray() {
		top = -1;
	}

	boolean Push(int data) {
		if (top >= MAX - 1) {
			System.out.println("StackArray Ovrflow");
			return false;
		}

		ar[++top] = data;
		return true;
	}

	int Pop() {
		if (top < 0) {
			System.out.println("StackArray Underflow");
			return 0;
		}
		return ar[top--];
	}

	boolean isEmpty() {
		return (top < 0);
	}

	public static void main(String[] args) {
		StackArray st = new StackArray();
		System.out.println("Is StackArray Empty : " + st.isEmpty());
		
		st.Push(1);
		st.Push(2);
		st.Push(3);		
		System.out.println(st.Pop());
		
	}

}
