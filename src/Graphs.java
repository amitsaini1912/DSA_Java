import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graphs {
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
    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();//Assign a ArrayList at each idx
        }

        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        graph[6].add(new Edge(6,5,1));
    }


    //BFS (BREADTH FIRST SEARCH)
    public static void bfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!vis[i])
               bfsUtil(graph , vis);
        }
    }
    public static void bfsUtil(ArrayList<Edge>[] graph, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();

        q.add(0);

        while (!q.isEmpty()){
            int curr = q.remove();
            if (!vis[curr]){
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }


    //DFS (DEPTH FIRST SEARCH) - RECURSION
    public static void dfs(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i])
               dfsUtil(graph, i , vis);
        }
    }
    public static void dfsUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis){

        System.out.print(curr+ " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph, e.dest, vis);
            }
        }
    }


    //GRAPHS: CYCLE DETECTION IN UNDIRECTED GRAPH USING DFS
    public static boolean detectCycle(ArrayList<Edge> [] graph){
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]){
                if (detectCycleUtil(graph,vis,i,-1))
                    return true;
            }
        }
        return false;
    }
    public static boolean detectCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int par){
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            //case 3
            if(!vis[e.dest]){
                if (detectCycleUtil(graph, vis, e.dest, curr))
                    return true;
            }
            //case 1
            else if (vis[e.dest] && e.dest != curr) { //here curr is parent for e.dest
                return true;
            }
            //case 2 continue loop
        }
        return false;
    }


    //GRAPHS: WEATHER A GRAPH BIPARTITE OR NOT USING BFS AND GRAPH COLORING
    public static boolean isBipartite(ArrayList<Edge>[] graph){
        int col[] = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1;
        }

        for (int i = 0; i < graph.length; i++) {
            if (col[i]==-1){
                boolean isTrue = isBipartiteUitl(graph, i, col);
                if (!isTrue)
                    return false;
            }
        }
        return true;
    }
    public static boolean isBipartiteUitl(ArrayList<Edge>[] graph, int i, int[] col){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        col[i] = 1;
        while (!q.isEmpty()){
            int curr = q.remove();
            //find neighbors of curr
            for (int j = 0; j < graph[curr].size(); j++) {
                Edge e = graph[curr].get(j);
                //case 1 if neighbor not have color
                if (col[e.dest]==-1) {
                    int nextCol = col[curr] == 0 ? 1 : 0;
                    col[e.dest] = nextCol;
                    q.add(e.dest);
                }
                //case 2 neighbor and curr have same color
                else if (col[e.dest]==col[curr]) {
                    return false;  //Not Bipartite
                }
            }
        }
        return true;
    }


    //GRAPHS: CYCLE DETECTION IN DIRECTED GRAPH USING DFS + Explicit Recursion Stack
    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]){
                boolean isTrue = isCycleUtil(graph, i, vis, stack);
                if (isTrue)
                    return true;
            }
        }
        return false;
    }
    public static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] stack){

        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(stack[e.dest] == true)
                return true;
            if (!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)){
                return true;
            }
        }
        stack[curr] = false;

        return false;
    }

    public static void main(String[] args){
        /*
                1 --- 3
               /      | \
              0       |   5 -- 6
               \      |  /
                2 --- 4

         */
        int V = 7; // No. of Total Nodes
        ArrayList<Edge>[] graph = new ArrayList[V];
        boolean vis[] = new boolean[V];

        createGraph(graph);

        System.out.println(isCycle(graph));

    }
}
