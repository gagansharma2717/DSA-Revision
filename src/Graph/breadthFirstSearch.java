package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class breadthFirstSearch {
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
        int v; //vertex
        String psf; //pathsofar

        public Pair(int v, String psf) {
            this.v = v;
            this.psf = psf;
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

        ArrayDeque<Pair> queue = new ArrayDeque<>();

        boolean[] visited = new boolean[vtces];
        queue.add(new Pair(src,src+""));

        while(queue.size() > 0)
        {
//            BFS is Remove Mark* Work Add*
//            Pair removed
            Pair rem = queue.removeFirst();

//            Check if visited or not if visited then continue
            if(visited[rem.v] == true){
                continue;
            }

//            If not visited then mark that vertex as visited
            visited[rem.v] = true;

//            work
            System.out.println(rem.v + "@" + rem.psf);

            for(Edge edge : graph[rem.v])
            {
                if(visited[edge.nbr] == false)
                {
                    queue.add(new Pair(edge.nbr,rem.psf+edge.nbr));
                }
            }

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
1@21
3@23
0@210
4@234
5@2345
6@2346

Time complexity O( (v+e) ). Space complexity s=O(v)
*/
