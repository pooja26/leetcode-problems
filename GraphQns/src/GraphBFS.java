import java.util.Iterator;
import java.util.LinkedList;

public class GraphBFS {
    public static void main(String[] args) {

        Graph graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);

        GraphBFS bfs = new GraphBFS();
        bfs.bfs(2,graph);
    }

    public void bfs(int s, Graph graph) {
        boolean[] visited = new boolean[graph.V];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0){
            s = queue.poll();
            System.out.println(s+" ");

            Iterator<Integer> list = graph.adjacencyList[s].listIterator();
            while(list.hasNext()){
                int n = list.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }

            }

        }
    }

}
