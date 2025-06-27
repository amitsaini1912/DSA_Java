import java.util.ArrayList;

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


        //Print Neighbors of Vertex 2
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.print(e.dest + " ");
        }
    }
}
