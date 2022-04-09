package Graph;
import java.util.*;

public class iterativeDFS {
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

        boolean[] visited = new boolean[vtces];
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(src,src+""));

        while(stack.size() > 0)
        {
            Pair rem = stack.pop();

            if(visited[rem.v] == true)
            {
                continue;
            }

            visited[rem.v] = true;

            System.out.println(rem.v + "@" + rem.psf);

            for(Edge edge : graph[rem.v])
            {
                if(visited[edge.nbr] == false)
                {
                    stack.add(new Pair(edge.nbr,rem.psf+edge.nbr));
                }
            }

        }
    }

    static class Pair{
        int v;
        String psf;

        public Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
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
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2

Sample Output
2@2
3@23
4@234
6@2346
5@23465
0@230
1@2301

Time Complexity:
We have just replaced the queue data structure with stack, and the rest of the code remains the same. Hence, the
time complexity will also remain O(N + E) where N = number of vertices and E = number of edges.

Space Complexity:
We are using a stack data structure, which will store at max N nodes. Also, we are using a visited array of size N.
Hence the total space complexity is o(N).
*/