
public class Digraph {
	private final int V;
	private final Bag<Integer>[] adj;

	public Digraph(int V) {
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
	}

	public void addEdge(int v, int w) {
		adj[v] = w;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
}