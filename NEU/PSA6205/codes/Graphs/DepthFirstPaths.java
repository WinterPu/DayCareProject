
public class DepthFirstPaths {

	private boolean[] marked;
	private int[] edgeTo;
	private int s;

	private boolean hasCycle;

	private boolean[] color;
	private boolean isTwoColorable = true;

	public DepthFirstPaths(Graph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		color = new int[G.V()];
		dfs(G, s, s);
	}

	private void dfs(Graph G, int v, int u) {
		marked[v] = true;
		for(int w : G.adj[v]) {
			if(!mark[w]) {
				color[w] = !color[v];
				dfs(G, w, v);
				edgeTo[w] = v;
			}
			if(marked[w] && w != u) hasCycle = true;
			if(marked[w] && color[w] == color[v]) isTwoColorable = false;
		}
	}

	public boolean hasCycle() {
		return hasCycle;
	}

	public boolean isTwoColorable() {
		return isTwoColorable;
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}


	// s -> v
	public Iterable<Integer> pathTo(int v) {
		if(!hasPathTo(v)) return null;

		Stack<Integer> path = new Stack<>();
		for(int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}
}