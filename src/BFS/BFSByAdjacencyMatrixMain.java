package BFS;

import Node.GraphNode;

import java.util.ArrayList;

public class BFSByAdjacencyMatrixMain {

    public static void main(String[] args) {

        //will store node lost in this
        ArrayList<GraphNode> nodeList = new ArrayList<>();


        //creating 10 nodes v1-v10
        for(int i=1;i<11;i++){
            nodeList.add(new GraphNode("V"+i, i-1));
        }

        //pass Graph arrayList for further processing
        BFSByAdjacencyMatrix graph = new BFSByAdjacencyMatrix(nodeList);

        //Add edges in graph
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

        System.out.println("Printing BFS from source: V1");
        graph.bfs();
    }

}
