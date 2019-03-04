import java.util.LinkedList;

public class Graph {
    int V;
    LinkedList<Integer> adjacencyList[];

    Graph(int v) {
        this.V = v;
        adjacencyList = new LinkedList[v];

        for (int i=0; i<V; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    //for directed graph
    public void addEdge(int source, int dest) {
        adjacencyList[source].add(dest);
        //adjacencyList[dest].add(source);
    }

    public void printGraph(Graph graph) {
        for (int i=0;i<V;i++) {
            System.out.println("List of vertex: "+i);
            System.out.print("head");
            for (Integer vertex: adjacencyList[i]) {
                System.out.print("->"+vertex);
            }
            System.out.println();
        }
    }
}
