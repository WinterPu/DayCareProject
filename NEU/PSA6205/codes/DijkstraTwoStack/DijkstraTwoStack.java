
import java.util.Stack;

public class DijkstraTwoStack {
	private Stack<Integer> val;
	private Stack<Character> opa;

	public DijkstraTwoStack() {
		val = new Stack<>();
		opa = new Stack<>();
	}

	public void demo() {
		String cal = "(1+((2+3)*(4*5)))";

		for(int i = 0; i < cal.length(); i++) {
			char c = cal.charAt(i);
			if(c > 47 && c < 58) {
				val.push(Integer.parseInt(Character.toString(c)));
			}
			else if(c == '+' || c == '-' || c == '*' || c == '/') opa.push(c);
			else if(c == ')') {
				int v1 = val.pop();
				int v2 = val.pop();
				char o = opa.pop();
				if(o == '+') val.push(v2+v1);
				else if(o == '-') val.push(v2-v1);
				else if(o == '*') val.push(v2*v1);
				else val.push(v2/v1);
			}
		}

		System.out.println("Result: " + val.pop());
	}

	public static void main(String[] args) {
		DijkstraTwoStack dts = new DijkstraTwoStack();
		dts.demo();
	}
}