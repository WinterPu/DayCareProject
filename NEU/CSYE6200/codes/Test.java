
import java.util.HashMap;

public class Test {
	HashMap map;

	public Test() {
		map = new HashMap();
	}

	public static void main(String[] args) {
		Test t = new Test();
		t.map.put(null, null);
		System.out.println(t.map);
	}
}