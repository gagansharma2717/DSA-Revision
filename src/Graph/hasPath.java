package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class hasPath {
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

        for(int i = 0 ; i < vtces; i++)
        {
            graph[i] = new ArrayList<>();
        }

        int edges = scn.nextInt();

        for(int i = 0 ; i < edges; i++)
        {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int wt = scn.nextInt();

            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }

        int src = scn.nextInt();
        int dest = scn.nextInt();


        boolean[] visited = new boolean[vtces];
        boolean hasPathRes = hasPath(graph,src,dest,visited);
        System.out.println(hasPathRes);
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src , int dest, boolean[] visited)
    {
        if(src == dest){
            return true;
        }

        visited[src] = true;

        for(Edge edge : graph[src])
        {
            if(visited[edge.nbr] == false)
            {
                boolean hasNbrPath = hasPath(graph,edge.nbr, dest , visited);
                if(hasNbrPath == true)
                {
                    return true;
                }
            }
        }

        return false;
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
