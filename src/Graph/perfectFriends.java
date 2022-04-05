package Graph;

import java.io.*;
import java.util.*;

public class perfectFriends {
    static class Edge{
        int src;
        int nbr;

        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int k = scn.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i = 0 ; i < n ; i++)
        {
            graph[i] = new ArrayList<>();
        }

        for(int j = 0 ; j < k ; j++)
        {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();

            graph[v1].add(new Edge(v1,v2));
            graph[v2].add(new Edge(v2,v1));
        }

        ArrayList<ArrayList<Integer>> comps =  new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i = 0 ; i < n ; i++)
        {
            if(visited[i] == false)
            {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(graph,i,visited,component);
                comps.add(component);
            }
        }

        int pairs = 0;

        for(int c1 = 0 ; c1 < comps.size(); c1++)
        {
            for(int c2 = c1 + 1; c2 < comps.size(); c2++)
            {
                int count = comps.get(c1).size() * comps.get(c2).size();
                pairs += count;
            }
        }

        System.out.println(pairs);

    }

    private static void dfs(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> component) {
        visited[src] = true;
        component.add(src);

        for(Edge edge : graph[src])
        {
            if(visited[edge.nbr] == false)
            {
                dfs(graph, edge.nbr, visited,component);
            }
        }
    }

}

/*

Sample Input

7
5
0 1
2 3
4 5
5 6
4 6

Sample Output
16

Time Complexity:
O(V+E) Because the DFS approach has been used.

Space Complexity:
O(v) for visited array
*/
