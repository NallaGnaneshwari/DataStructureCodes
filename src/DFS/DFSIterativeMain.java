package DFS;

import Node.GraphNode;

import java.util.ArrayList;

public class DFSIterativeMain {

    public static void main(String[] args) {

        //creating an arraylist to stote the list of vertices/nodes of the graph
        ArrayList<GraphNode> nodeList = new ArrayList<>();

        //adding vertices v1-v10 into the arraylist
        for (int i = 1; i < 11; i++) {
            nodeList.add(new GraphNode("V" + i));
        }

        //constructor
        DFSIterative graph = new DFSIterative(nodeList);


        // adding the edges following the graph into adjacency matrix or adjacency list
        graph.addUndirectedEdge(1,2);
        graph.addUndirectedEdge(1,4);
        graph.addUndirectedEdge(2,3);
        graph.addUndirectedEdge(2,5);
        graph.addUndirectedEdge(3,6);
        graph.addUndirectedEdge(3,10);
        graph.addUndirectedEdge(4,7);
        graph.addUndirectedEdge(5,8);
        graph.addUndirectedEdge(6,9);
        graph.addUndirectedEdge(7,8);
        graph.addUndirectedEdge(8,9);
        graph.addUndirectedEdge(9,10);

        //dfs from v1
        System.out.println("Printing DFS from source: V1");
        graph.dfs();
    }
}
