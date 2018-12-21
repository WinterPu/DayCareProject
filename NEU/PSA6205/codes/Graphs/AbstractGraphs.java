
import java.lang.Iterable;

public abstract class AbstractGraphs {
	public abstract void addEdge(int v, int w);
	public abstract Iterable<Integer> adj(int v);
	public abstract int V();
	public abstract int E();
}
