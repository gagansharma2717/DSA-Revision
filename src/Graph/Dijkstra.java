package Graph;

// Shortest Path in terms of weight
// Similar to BFS just instead of queue, priority queue is used here.

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {
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
    static class Pair implements Comparable<Pair>{
        int v;
        String psf;
        int wsf;

        public Pair(int v, String psf, int wsf) {
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }

        public int compareTo(Pair others)
        {
            return this.wsf - others.wsf;
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

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,src+"",0));

        while(pq.size() > 0)
        {
            Pair rem = pq.remove();

            if(visited[rem.v] == true)
            {
                continue;
            }

            visited[rem.v] = true;

            System.out.println(rem.v + " via " + rem.psf + " @ " + rem.wsf );

            for(Edge edge : graph[rem.v])
            {
                if(visited[edge.nbr] == false)
                {
                    pq.add(new Pair(edge.nbr,rem.psf+edge.nbr,rem.wsf + edge.wt));
                }
            }
        }

    }
}

/*
Sample Input
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

Sample Output
0 via 0 @ 0
1 via 01 @ 10
2 via 012 @ 20
5 via 0125 @ 25
4 via 01254 @ 28
6 via 01256 @ 28
3 via 012543 @ 30

*/


/*
Time Complexity:
This is an interesting analysis. The time complexity of Dijkstra's algorithm will be O(E + V logV) where V = number
of vertices and E = number of edges. This is because, we are iterating over all the edges once during the entire
run of the algorithm In each iteration, we are popping one node and pushing the unvisited neighbour nodes. Since
the priority queue can contain all the vertices, the push or pop operation will be O(log V). Hence the total time
complexity will be O(E) + O(V) * O(log V) = O(E + V log V). Note: You can argue that we might be having multiple
Pairs having the same node's value. So, the maximum size of the priority queue will be not O(N) but O(E). But, even
if you replace log V with Log E (cost of one push/pop operation), then there will be no difference in the time
complexity as: O(E + VlogE) = O(E + Vlog(V^2)) = O(E + 2V logV) = O(E + V logV) only.

Space Complexity:
We are taking a priority queue of Pair nodes. Hence, the space complexity will be O(N) where N = maximum Pair nodes
in the queue, which is equivalent to O(V).
*/
