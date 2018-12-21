
public class KosarajuSharirSCC {
	private boolean[] marked;
	private int[] id;
	private int count;

	public KosarajuSharirSCC(Graph G) {
		marked = new int[G.V()];
		id = new int[G.V()];
		DepthFirstOrder dfs = new DepthFirstOrder(G.reverse());
		for(int v = 0; v < V; v++) {
			if(!marked[v]) {
				dfs(G, v);
				count++;
			}
		}
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		id[v] = count;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				dfs(G, w);
			}
		}
	}

	public boolean stronglyConnected(int v, int w) {
		return id[v] == id[w];
	}
}