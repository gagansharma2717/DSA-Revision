package Graph;

import java.util.ArrayList;
import java.util.Scanner;

// DFS
public class printAllPaths {

    static class Edge{
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
        int dest = scn.nextInt();

        boolean[] visited = new boolean[vtces];
        allPaths(graph,src,dest,visited,src+"");
    }

    private static void allPaths(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf) {
        if(src == dest)
        {
            System.out.println(psf);
            return;
        }

        visited[src] = true;

        for(Edge edge : graph[src])
        {
            if(visited[edge.nbr] == false)
            {
                allPaths(graph, edge.nbr, dest,visited,psf+edge.nbr);
            }
        }

        visited[src] = false;

    }
}

/*

Test Case :

7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
0
6

 */

/*

Time Complexity:
O(V+E)

Space Complexity:
O(V)
*/