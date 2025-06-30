import java.util.*;

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

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-1));

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


    //GRAPHS: TOPOLOGICAL SORTING FOR DAG's (Directed Acyclic Graphs)
    public static void topSort(ArrayList<Edge>[] graph){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]){
                topSortUtil(graph, i, vis, s);
            }
        }

        while (!s.isEmpty()){
            System.out.print(s.peek()+" ");
            s.remove(s.peek());
        }
    }
    public static void topSortUtil(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s){
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest])
                topSortUtil(graph, e.dest, vis, s);
        }
        s.add(curr);
    }


    //GRAPHS: TOPOLOGICAL SORT FOR DAG's [Using KAHN's ALGORITHM] - BFS
    public static void calcIndeg(ArrayList<Edge>[] graph, int [] indeg){
        for (int i = 0; i < graph.length; i++) {//To traverse connected components of a graph
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }
    public static void KahnsTopSort(ArrayList<Edge>[] graph){
        int inDeg[] = new int[graph.length];
        calcIndeg(graph, inDeg);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i]==0)
                q.add(i); //Add all vertices that have inDegree 0
        }

        while (!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" "); //Topological Sort Print
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                inDeg[e.dest]--;
                if(inDeg[e.dest]==0)
                   q.add(e.dest);
            }
        }
    }


    //GRAPHS: ALL PAIRS SHORTEST PATH FROM SOURCE TO DESTINATION [Using DFS]
    public static void printAllPath(ArrayList<Edge> graph[], int src, int dest, String path){
        if (src==dest) {
            System.out.println(path+dest);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path+src);
        }
    }

    //GRAPHS: DIJKSTRAS's ALGORITHM To FIND SHORTEST PATH FROM SOURCE TO ALL VERTICES [Uses BFS With PQ]
    static class Pair implements Comaparable<Pair>{
        int n;
        int path;
        public Pair(int n, int path){
            this.path = path;
            this.n=n;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path;
        }
    }
    public static void dijkstra(ArrayList<Edge>[] graph, int src){
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if(i != src)
                dist[i] = Integer.MAX_VALUE;
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()){
            Pair curr = pq.remove();
            if (!vis[curr.n]){
                vis[curr.n] = true;
                for (int i = 0; i < graph[curr.n].size(); i++) {
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;

                    if (dist[u]+wt < dist[v]){
                        dist[v] = dist[u]+wt;
                        pq.add(new Pair(e.dest, dist[v]));
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println(dist[i]+ " ");
        }
    }


    //GRAPHS: BELLMAN FORD ALGORITHM To FIND SHORTEST PATH FROM SOURCE TO ALL VERTICES  [FOR NEGATIVE EDGES]
    public static void bellmanFord(ArrayList<Edge>[] graph, int src){
        int dist[] = new int[graph.length];
        for (int i = 0; i < dist.length; i++) {
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        int V = graph.length;;
        //Algo - O(V*E)
        for (int i = 0; i < V-1; i++) {
            //find edges of graph - O(E)
            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.weight;
                    //Relaxation Step
                    if (dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v])
                        dist[v]=dist[u]+wt;
                }
            }
        }
        //Print Dist Array
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
    //Bellman Ford V2
    public static void createGraph2(ArrayList<Edge> graph){

        graph.add(new Edge(0,1,2));
        graph.add(new Edge(0,2,4));

        graph.add(new Edge(1,2,-4));

        graph.add(new Edge(2,3,2));

        graph.add(new Edge(3,4,4));

        graph.add(new Edge(4,1,-1));

    }
    public static void bellmanFordV2 (ArrayList<Edge> graph, int src, int V){
        int dist[] = new int[V];
        for (int i = 0; i < dist.length; i++) {
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }


        //Algo - O(V*E)
        for (int i = 0; i < V-1; i++) {
            //find edges of graph - O(E)
            for (int k = 0; k < graph.size(); k++) {
                Edge e = graph.get(k);
                int u = e.src;
                int v = e.dest;
                int wt = e.weight;
                //Relaxation Step
                if (dist[u]!=Integer.MAX_VALUE && dist[u]+wt<dist[v])
                    dist[v]=dist[u]+wt;
            }
        }
        //Print Dist Array
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args){

        int V = 5; // No. of Total Nodes
        ArrayList<Edge>[] graph = new ArrayList[V];
        boolean vis[] = new boolean[V];

        createGraph(graph);

        bellmanFord(graph, 0);

        ArrayList<Edge> edges = new ArrayList<>();
        createGraph2(edges);
        bellmanFordV2(edges, 0, 5);

    }
}
