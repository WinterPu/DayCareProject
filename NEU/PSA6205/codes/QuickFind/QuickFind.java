
public class QuickFind {
	private int[] id;

	public QuickFind(int n) {
		id = new int[n];
		for(int i = 0; i < n; i++) id[i] = i;
	}

	public void showId() {
		for(int i : id) {
			System.out.println(i);
		}
	}

	public int find(int index) {
		if(index > id.length || index < 0) return -1;
		else return id[index];
	}

	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);

		if(pRoot == qRoot) return;

		for(int i = 0; i < id.length; i++) {
			if(id[i] == pRoot) id[i] = qRoot;
		}
	}

	public static void main(String[] args) {
		QuickFind uf = new QuickFind(10);
		uf.union(4, 7);
		uf.union(3, 8);
		uf.union(3, 4);

		uf.showId();
	}

}