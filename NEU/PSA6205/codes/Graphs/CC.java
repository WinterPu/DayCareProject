
public class CC {
	private boolean[] marked;
	private int[] id;
	private int count; // number of components

	public CC(Graph G) {
		marked = new marked[G.V()];
		id = new int[G.V()];
		for(int v = 0; v < G.V(); v++) {
			if(!marked[v]) {
				dfs(G, v);
				count++;
			}
		}
	}

	// return the number of components
	public int count() {
		return count;
	}

	public int id(int v) {
		return id[v];
	}

	public boolean connected(int v, int w) {
		return id[v] == id[w];
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj[v]) {
			if(!mark[w]) {
				dfs(G, w);
			}
		}
	}
}