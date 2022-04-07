package Graph;
import java.util.*;
import java.io.*;

/*
A graph is called bipartite if it is possible to split its vertices in two sets of mutually
exclusive and exhaustive vertices such that all edges are across sets.

In simple terms , graph ki vertices ko two sets m divide krna hai with two rules, i.e.
1. Ek vertex Ek hi set m nhi hongi. --> Exclusive
2. Har ek vertex kisi na kisi set m hongi either first or second. --> Exhaustive

Note: Every non-cyclic graph and also cyclic graph with even number of vertices is bipartite graph.
*/

public class isGraphBiPartite {
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

    static class Pair{
        int v;
        String psf;
        int level;

        public Pair(int v, String psf, int level) {
            this.v = v;
            this.psf = psf;
            this.level = level;
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

        int[] visited = new int[vtces];
        Arrays.fill(visited,-1);
        for(int v = 0 ; v < vtces; v++)
        {
            if(visited[v] == -1)
            {
                boolean checkBipartite = isBiPartite(graph,v,visited);
                if(!checkBipartite)
                {
                    System.out.println("false");
                    return;
                }
            }
        }
        System.out.println("true");
    }

    private static boolean isBiPartite(ArrayList<Edge>[] graph, int src, int[] visited) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(src,src+"",0));

        if(queue.size() > 0)
        {
            Pair rem = queue.removeFirst();

            if(visited[rem.level] != -1)
            {
//                Checking current level of vertex i.e rem.level with vertex previous level which is
//                stored in visited array i.e visited[rem.v]. If they both are not same, it means
//                there are odd number of cycles in graph which means it is not bipartite
                if(rem.level != visited[rem.v]) {
                    return false;
                }
            }
            else
            {
                visited[rem.level] = rem.level;
            }

            for(Edge edge : graph[rem.v])
            {
                if(visited[edge.nbr] == -1)
                {
                    queue.add(new Pair(edge.nbr,rem.psf+edge.nbr,rem.level+1));
                }
            }
        }


        return true;
    }
}

/*
Sample Input
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

Sample Output
false
*/

/*
Time Complexity:
We are simply doing a BFS traversal of the entire graph, which will take O(N + E) time,
where N = number of vertices, and E = number of edges.

Space Complexity:
We are using a queue data structure for the BFS traversal, which will store at max N vertices.
Hence, the space complexity is O(N). Please note that we are not taking into account the space
taken to build the adjacency list, as it was given to us as an input.*/
