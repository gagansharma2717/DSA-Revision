package Graph;

/*
Possible Questions
1. has path (Path is there or not between two given vertices
2. All Paths (Print all paths between two given vertices)
3. Shortest Path between two vertices (BFS --> Breadth First Search)
4. Shortest path between two vertices in terms of weight (Dijkstra)
5. MST --> Minimum Spanning Tree ( Prim's and Kruskal)
6. Topological Sort in Directed Graph
 */

import java.util.ArrayList;
import java.util.Scanner;

/*
Graph Representations
1. Adjacency Matrix --> Vertices should be less than 10,000. It takes more space.
   This matrix is basically 2d array and suppose we want to show an edge between 2 and 3 vertex in undirected graph.
   So, we will place weight of edges in {2,3} and {3,2} else if there is no edge then we will place 0 or -1
2. Adjacency List --> More popular representation that we will cover in the program below
    This list is basically an Array of Arraylists. Array is basically all the vertices
    and ArrayList store the values of edges like src, nbr and wt
    So, arr[1] will store all the info of all the edges from 1 vertex in form of arraylists.
*/
public class Graph_Constructor {

//    This is an edge class which store all information of edge like source, neighbour and weight.
    static class Edge {
    int src;
    int nbr;
    int wt;

//  For Weighted graph
    public Edge(int src, int nbr, int wt) {
        this.src = src;
        this.nbr = nbr;
        this.wt = wt;
    }

//  For Unweighted Graph
    public Edge(int src, int nbr) {
        this.src = src;
        this.nbr = nbr;
    }
}

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
//      Declaration
//      Vertices
        int vtces = scn.nextInt();

//      Graph
        ArrayList<Edge>[] graph = new ArrayList[vtces];
//      Adding Blank ArrayList in front of each vertex
        for(int i = 0 ; i < vtces ; i++) {
            graph[i] = new ArrayList<>();
        }
//      Edges Creation
//      Number of Edges
        int edges = scn.nextInt();
//      Inputs of vertices and weights for each edge
        for(int i = 0 ; i < edges ; i++){
            int v1 = scn.nextInt();
            int v2 = scn.nextInt();
            int wt = scn.nextInt();
//          Creating Edge for v1 and v2 considering it as Undirected or Bidirectional Graph
            graph[v1].add(new Edge(v1,v2,wt));
            graph[v2].add(new Edge(v2,v1,wt));
        }

        display(graph);

    }

    private static void display(ArrayList<Edge>[] graph) {
//        Number of Vertices
        int vtces = graph.length;

//        Traversing Each Vertex
        for(int i = 0  ; i < vtces; i++)
        {
            System.out.println(i + " : ");
//          Traversing Each Edge of those Vertex
            for(Edge e : graph[i])
            {
                System.out.println(" { " + e.src + " , " + e.nbr + " , " + e.wt + " } ");
            }
            System.out.println();
        }
    }

}
/*
Input
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

*/
