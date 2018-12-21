
public class QuickUnion {
	private int[] id;
	
	public QuickUnion(int n) {
		id = new int[n];
		for(int i = 0; i < n; i++) id[i] = i;
	}

	public void showId() {
		for(int i : id) 
			System.out.println(i);
	}
	
	public int find(int index) {
		if(index > id.length || index < 0) return -1;

		int target = index;
		while(id[target] != target) {
			target = id[target];
		}
		return target;
	}

	public void union(int p, int q) {
		// Change root of q to root of p
		int i = find(p);
		int j = find(q);

		id[j] = i;
	}

	public static void main(String[] args) {
		QuickUnion uq = new QuickUnion(10);
		uq.union(4, 7);
		uq.union(3, 8);
		uq.union(3, 4);

		uq.showId();
	}
}