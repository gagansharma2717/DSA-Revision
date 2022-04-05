package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/*
A hamiltonian path is such which visits all vertices without visiting any twice.
A hamiltonian path becomes a cycle if there is an edge between first and last vertex.
*/

public class hamiltonianPathAndCycle {
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

        int src = scn.nextInt();

        HashSet<Integer> visited = new HashSet<>();
        dfs(graph,src,visited,src+"",src);

    }

    private static void dfs(ArrayList<Edge>[] graph, int src, HashSet<Integer> visited, String psf, int osrc) {
        if(visited.size() == graph.length-1)
        {
            boolean edgeFound = false;

            for(Edge edge : graph[src])
            {
                if(edge.nbr == osrc)
                {
                    edgeFound = true;
                    break;
                }
            }

            if(edgeFound == true)
            {
                System.out.println(psf + "*");
            }
            else {
                System.out.println(psf + ".");
            }
        }

       visited.add(src);

        for(Edge edge : graph[src])
        {
            if(visited.contains(edge.nbr) == false)
            {
                dfs(graph, edge.nbr,visited,psf+edge.nbr,osrc);
            }
        }

        visited.remove(src);
    }
}


/*

Sample Input
7
9
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2 5 10
0

Sample Output
0123456.
0123465.
0125643*
0346521*

Time Complexity :
The time complexity of the code is O(V+E) because of the DFS approach used in this solution,
where V is the number of vertices and E is the number of edges in the graph.


Space Complexity :
The space complexity of the solution is O(V), since we used a hashset to store the number of vertices
which acts as a visited array for this solution.
*/