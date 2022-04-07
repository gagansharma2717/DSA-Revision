package Graph;

import java.util.*;
import java.io.*;

public class isGraphCyclic {

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

    static class Pair {
        int v;
        String psf;

        public Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
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

        for (int i = 0; i < vtces; i++) {
            if (visited[i] == false) {
                boolean cycleCheck = isCyclic(graph, i, visited);

                if (cycleCheck) {
                    System.out.println("true");
                    return;
                }
            }
        }

        System.out.println("false");

    }

    public static boolean isCyclic(ArrayList<Edge>[] graph, int src, boolean[] visited)
    {
        ArrayDeque<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(src,src+""));

        while(queue.size() > 0)
        {
            Pair rem = queue.removeFirst();

//            If some vertex that is already visted is coming again that means we have a cycle here.
//            So we will return true here
            if(visited[rem.v] == true)
            {
                return true;
            }

            visited[rem.v] = true;

            for(Edge edge : graph[rem.v])
            {
                if(visited[edge.nbr] == false)
                {
                    queue.add(new Pair(edge.nbr, rem.psf + edge.nbr));
                }
            }
        }

        return false;
    }
}

/*

Sample Input
7
6
0 1 10
1 2 10
2 3 10
3 4 10
4 5 10
5 6 10

Sample Output
false

 */


/*
Time Complexity:
We are doing a simple BFS traversal of the graph. Hence the time complexity will be O(N + E)
where N = number of vertices and E = number of edges.

Space Complexity:
We are building a visited array and a parent array of size equal to the number of vertices.
Also, we are taking the queue data structure to perform BFS traversal, which will store at max n nodes.
Hence, the total space complexity will be O(n + n + n) = O(n) only.

Please note that we are not taking into account the space taken to build the adjacency list,
as it was given to us as an input.

Follow Up: O(h) There are many methods of cycle detection in graphs, such as:
1.Cycle Detection in Undirected Graph Using DFS
2.Cycle Detection in Undirected Graph Using BFS
3.Cycle Detection in Undirected Graph Using DSU (Disjoint Set Union)
4.Cycle Detection in Directed Graph using DFS 5.Cycle Detection in Directed Graph using Graph Coloring
6.Cycle Detection in Directed Graph using Topological Sort (Kahn's Algorithm/BFS)
6.(Kahn's Algorithm/BFS) All these algorithms are different from each other, and can be used interchangeably
depending upon the type of graph (directed/undirected) and the type of problem.
*/
