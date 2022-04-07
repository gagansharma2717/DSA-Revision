package Graph;
import java.io.*;
import java.util.*;

// DFS hi hai Bs Preorder m jaate hue vertices ko ek arraylist m store kr liya and main m us arraylist ko ek
// arraylist of arraylist m fill krke display kr diya
public class getConnectedComponents {
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
            for(int v = 0 ; v < vtces; v++) {
                if(visited[v] == false)
                {
                    ArrayList<Integer> component = new ArrayList<>();
                    dfs(graph,v,visited,component);
                    comps.add(component);
                }
            }
            System.out.println(comps);
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
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10

Sample Output
[[0, 1], [2, 3], [4, 5, 6]]

*/

/*
Time Complexity:
The time complexity of the above code is O(V) as we are going to visit every vertex exactly once.


Space Complexity:
The space complexity of the above code is O(h) where h is the height of the recursion stack.
*/