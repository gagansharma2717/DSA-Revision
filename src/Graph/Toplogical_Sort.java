package Graph;
import java.util.*;

// Order of Compilation
// Topological sort -> A permutation of vertices for a directed acyclic graph is called topological sort if
// for all directed edges uv, u appears before v in the graph.
public class Toplogical_Sort {
    static class Edge{
        int src;
        int nbr;

        public Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
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
        for(int i =0 ; i < edges ; i++)
        {
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();

            graph[v1].add(new Edge(v1,v2));
        }

        boolean[] visited = new boolean[vtces];
        Stack<Integer> st = new Stack<>();
//      Visited and Stack liya and Get Connected Components Jaise hr vertex se call lgayi
        for(int i = 0 ; i < vtces; i++){
            if(visited[i] == false)
            {
                topologicalSort(graph,i,visited,st);
            }
        }

//        Just Printed Whatever is present in stack
        while(st.size() > 0)
        {
            System.out.println(st.pop());
        }

    }

    private static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean[] visited, Stack<Integer> st) {

//        Mark Visited
        visited[src] = true;

//        Added Neighbours
        for(Edge edge : graph[src])
        {
            if(visited[edge.nbr] == false)
            {
                topologicalSort(graph,edge.nbr,visited,st);
            }
        }

//      Post-Order m source vertex ko stack m add kr liya
        st.push(src);
    }

}

/* Important Points :
* Stack mai add post-order m krna h
* Stack ko print main m jaakr krna hai Agar Post Order m print krenge toh toplogical sort ka reverse print hoga
* Baaki toh Get Connected Components Jaisi Calls and BFS are visit mark krna and neighbours add krna hi h
*/
/*
Input
7
7
0 1
1 2
2 3
0 3
4 5
5 6
4 6

Output
4
5
6
0
1
2
3

*/

/*

Time Complexity:
Well, there is nothing magical here, just a simple variation of DFS to store the elements in a stack data structure.
Hence the time complexity will be O(N + E) where N = number of vertices and E = number of edges.

Space Complexity:
Since, we are storing all the vertices in a stack data structure, also we will be using a visited array, the space
complexity will be O(N). We are not considering the space of O(E) of the adjacency list, as it has been given to us
in the form of input.
*/