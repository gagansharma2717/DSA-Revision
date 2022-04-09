package Graph;
import java.util.*;

// MINIMUM WIRE REQUIRED TO CONNECT ALL PCS
// A MST(Minimum Spanning Tree) is a subgraph, connected, acyclic and spanning (all vertices).

public class Prims {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }

    }

    static class Pair implements Comparable<Pair>{
        int v; // Vertex
        int av; // Acquired Vertex
        int wt; // Weight

        public Pair(int v, int av, int wt) {
            this.v = v;
            this.av = av;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int vtces = scn.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[vtces];

        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = scn.nextInt();

        for (int i = 0; i < edges; i++) {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int wt = scn.nextInt();

            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        boolean[] visited = new boolean[vtces];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,-1,0));

        while(pq.size() > 0) {

            Pair rem = pq.remove();

            if(visited[rem.v] == true)
            {
                continue;
            }

            visited[rem.v] = true;

            if(rem.av != -1) {
                System.out.println("[" + rem.v + "-" + rem.av + "@" + rem.wt + "]");
            }

            for(Edge edge  : graph[rem.v])
            {
                if(visited[edge.nbr] == false)
                {
                    pq.add(new Pair(edge.nbr,rem.v,edge.wt));
                }
            }

        }
    }
}

/*

Sample Input
7
8
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8

Sample Output
[1-0@10]
[2-1@10]
[3-2@10]
[4-3@2]
[5-4@3]
[6-5@3]

Time complexity O( (v+e)log v). Space complexity s=O(v+e)
*/

/*
Prim's and Dijkstra are almost similar. They both uses Priority Queue and Pair with Comparable Interface and also
Remove Mark* Work Add* Strategy.

The only difference is :
In Dijkstra, We use Vertex, PathSoFar and WeightSoFar and In adding Neighbours we do
pq.add(new Pair(edge.nbr,rem.psf+edge.nbr,rem.wsf+edge.wt));

In Prim's, We use Vertex (v), Acquired Vertex (av i.e, Previous Vertex) and Weight(wt) and In adding Neighbours we do
pq.add(new Pair(edge.nbr,rem.v,edge.wt));
and Initially, we add dummy node in pq as (v:0,av:-1,wt:0,) and we only print if(av != -1) in work section
*/