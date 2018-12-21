
import java.util.Collection;

public class Graph extends AbstractGraphs {
	private int edge;
	private final int V;
	private Bag<Integer>[] adj;

	public Graph(int V) {
		edge = 0;
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V];
		for(int v = 0; v < V; v++) adj[v] = new Bag<Integer>();
	}

	@Override
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		edge++;
	}

	@Override
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	@Override
	public int V() {
		return V;
	}

	@Override
	public int E() {
		return edge;
	}
}