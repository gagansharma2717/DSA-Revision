package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class multisolver {
    static class Edge{
        int src;
        int nbr;
        int wt;

        public Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }

    }

    static class Pair implements Comparable<Pair>
    {

        int wsf;
        String psf;

        public Pair(int wsf, String psf) {
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(Pair o)
        {
            return this.wsf - o.wsf;
        }
    }
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int vtces = scn.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[vtces];

        for(int i = 0 ; i < vtces; i++)
        {
            graph[i] = new ArrayList<>();
        }

        int edges = scn.nextInt();

        for(int i = 0 ; i < edges ; i++)
        {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int wt = scn.nextInt();

            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }

        int src = scn.nextInt();
        int dest = scn.nextInt();
        int criteria = scn.nextInt();
        int k = scn.nextInt();

        boolean[] visited = new boolean[vtces];

        multiSolver(graph,src,dest,visited,criteria,k,src+"",0);

        System.out.println("Smallest Path = " + spath + " @ " + spathwt);
        System.out.println("Largest Path = " + lpath + " @ " + lpathwt);
        System.out.println("Just Larger Path than" + criteria + "=" + cpath + " @ " + cpathwt);
        System.out.println("Just Smaller Path than" + criteria + "=" + fpath + " @ " + fpathwt);
        System.out.println(k + "th largest path = " + pq.peek().psf + " @ " + pq.peek().wsf);

    }

    static String spath; // smallest path
    static Integer spathwt = Integer.MAX_VALUE; // Smallest path weight and Smallest Integer ka Identity is Plus Infinity
    static String lpath; //largest path
    static Integer lpathwt = Integer.MIN_VALUE; // largest path weight and Largest Integer ka Identity is Minus Infinity
    static String cpath; //ceil path given value se just bda is ceil
    static Integer cpathwt = Integer.MAX_VALUE; // ceil path weight
    static String fpath ; // floor path given value se just chota is floor
    static Integer fpathwt = Integer.MIN_VALUE;
    static PriorityQueue<Pair> pq = new PriorityQueue<Pair>();

    private static void multiSolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
        if(src == dest)
        {
            if(wsf < spathwt)
            {
                spath = psf;
                spathwt = wsf;
            }

            if(wsf > lpathwt)
            {
                lpath = psf;
                lpathwt = wsf;
            }

            if(wsf > criteria && wsf < cpathwt)
            {
                cpath = psf;
                cpathwt = wsf;

            }

            if(wsf < criteria && wsf > fpathwt)
            {
                fpath = psf;
                fpathwt = wsf;
            }

            if(pq.size() < k )
            {
                pq.add(new Pair(wsf,psf));
            }
            else {
                if(wsf > pq.peek().wsf)
                {
                     pq.remove();
                    pq.add(new Pair(wsf,psf));
                }
            }
            return;
        }

        visited[src] = true;

        for(Edge edge : graph[src])
        {
            if(visited[edge.nbr] == false)
            {
                multiSolver(graph,edge.nbr,dest,visited,criteria,k,psf + edge.nbr, wsf + edge.wt);
            }
        }

        visited[src] = false;
    }

}

/*
Input
7
9
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
2 5 5
0
6
30
4


Smallest Path = 01256@28
Largest Path = 032546@66
Just Larger Path than 30 = 012546@36
Just Smaller Path than 30 = 01256@28
4th largest path = 03456@48
*/

/*
4. ANALYSIS :
Time Complexity :
We are simply doing a DFS traversal, hence the time complexity will be O(V + E) where V = number of vertices in
the graph and E = number of edges in the graph.

Space Complexity :
To perform BFS, we use priority queue data structure to find kth largest path and a visited array, which will
take O(V) space, where V is the number of vertices in the graph.
*/

