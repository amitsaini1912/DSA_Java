import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graphs_Basic {

    static class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }


    //CREATE GRAPH
    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();      //Assign a ArrayList at each idx
        }

        // Vertex 0
        graph[0].add(new Edge(0,1,1));

        //Vertex 1
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,1));

        //Vertex 2
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,1));

        //Vertex 3
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,2,1));

        //Vertex 4
        graph[4].add(new Edge(4,2,1));
    }


    //BFS (BREADTH FIRST SEARCH)
    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean visit[] = new boolean[graph.length];

        q.add(0);

        while (!q.isEmpty()){
            int curr = q.remove();
            if (!visit[curr]){
                System.out.print(curr + " ");
                visit[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args){
        /*
             0 ------------ 1
                    5       | \
                          1 |   \ 3
                            |    \
                            2 --- 3
                           /   1
                       2  /
                         /
                        4
         */
        int V = 5; // No. of Total Nodes
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        bfs(graph);
    }
}
