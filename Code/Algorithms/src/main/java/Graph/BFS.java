package Graph;

import java.util.Iterator;
import java.util.LinkedList;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];
    Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i=0;i<V;i++) {
            adj[i] = new LinkedList();
        }
    }
    public void addEdge(int source, int dest) {
        adj[source].add(dest);
    }

    public int getV() {
        return V;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }
}
public class BFS {

    public void bfs(Graph g, int s) {
        boolean visited[] = new boolean[g.getV()];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (queue.size()>0) {
            visited[s] = true;
            Integer node = queue.poll();
            Iterator<Integer> it = g.getAdj()[node].listIterator();
            while (it.hasNext()) {
                if (!visited[it.next()]) {
                    int n = it.next();
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        BFS b = new BFS();
        b.bfs(g,2);
    }
}

