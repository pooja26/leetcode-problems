import java.util.Iterator;
import java.util.List;

public class GraphDFS {
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);
    }
    public void dfsUtil(int s,boolean visited[]) {

        visited[s] = true;
    }
    public void dfs(int s, Graph graph) {
        boolean visited[] = new boolean[graph.V];
        dfsUtil(s,visited);
    }
}
