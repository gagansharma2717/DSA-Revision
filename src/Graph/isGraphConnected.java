package Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class isGraphConnected
{
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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();

        boolean[] visited = new boolean[vtces];
        for(int i = 0 ; i < vtces; i++)
        {
            if(visited[i] == false)
            {
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(graph,i,visited,comp);
                comps.add(comp);
            }
        }

//      This question is just a simple extension of Get Connected Components.
//      If Graph has only one arraylist of components that means it is connected else not connected.
        System.out.println(comps.size() == 1);
    }

    private static void dfs(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp) {
        visited[src] = true;
        comp.add(src);

        for(Edge edge : graph[src])
        {
            if(visited[edge.nbr] == false)
            {
                dfs(graph, edge.nbr, visited, comp);
            }
        }
    }


}

/*
Sample Input
7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10

Sample Output
false
*/

// Time complexity O( (v+e) ). Space complexity s=O(v)