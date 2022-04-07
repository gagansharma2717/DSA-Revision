package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class spreadOfInfection {
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

    static class Pair{
        public Pair(int v, int time) {
            this.v = v;
            this.time = time;
        }

        int v;
        int time;
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
        int t = scn.nextInt();

        int[] visited = new int[vtces];
        int count = 0;

        ArrayDeque<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(src,1));

        while(queue.size() > 0)
        {
            Pair rem = queue.removeFirst();

            if(visited[rem.v] > 0)
            {
                continue;
            }

            visited[rem.v] = rem.time;
            if(rem.time > t)
            {
                break;
            }
            count++;

            for(Edge edge : graph[rem.v])
            {
                if(visited[edge.nbr] == 0){
                    queue.add(new Pair(edge.nbr,rem.time + 1));
                }
            }
        }

        System.out.println(count);

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
6
3

Sample Output
4

*/

/*
Time Complexity :
 We are simply doing a BFS traversal, hence the time complexity will be O(N + E) where
 N = number of vertices in the graph and E = number of edges in the graph.

Space Complexity :
To perform BFS, we use queue data structure, which will take O(N) auxiliary space.
Please note that we are not taking into account the space taken to build the adjacency list,
as it was given to us as an input.

Follow Up: O(h)
In this problem, only one person was infected in the beginning (at time t = 0).
What if there were more than one person who were infected initially?
This variation is known as "Rotten Oranges" and simply, we can start the bfs by pushing all the infected people
(rotten oranges) in the queue with time = 0.
*/