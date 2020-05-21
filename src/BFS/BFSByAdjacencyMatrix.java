package BFS;

import Node.GraphNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFSByAdjacencyMatrix {

    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    private int[][] adjacencyMatrix;

    //constructor
    public BFSByAdjacencyMatrix(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    //BFS Algorithm:
    public void bfs(){
        for(GraphNode node:nodeList){
            if(!node.isVisited()){
                bfsVisit(node);
            }
        }
    }

    // BFS internal method
    public void bfsVisit(GraphNode node){ //bfs uses a queue, queue implemented by linkedlist
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            GraphNode presentNode = queue.remove(0);
            presentNode.setVisited(true);
            System.out.println(presentNode.getName()+" ");

            ArrayList<GraphNode> neighbors = getNeighbors(presentNode);
            for(GraphNode neighbor:neighbors){
                if(!neighbor.isVisited()){
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                }
            }
        }
    }


    //get all neighbors of a particular node by checking adjacency matrix and add it to the neighbors array list
    public ArrayList<GraphNode> getNeighbors(GraphNode node){
        ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();

        //gets row# to search in node index
        int nodeIndex = node.getIndex();

        for(int i=0;i<adjacencyMatrix.length;i++){
            // if a column has 1 in that row then there is a neighbor and add it to the list
            if(adjacencyMatrix[nodeIndex][i]==1)
                neighbors.add(nodeList.get(i));
        }
        return neighbors;
    }


    //add an undirected edge between 2 nodes  (populating fields of adjacency matrix
    public void addUndirectedEdge(int i,int j){
        i--;
        j--;   //since index in adjacency matrix starts from 0, (but user gives 1 => 1-1=0 or 2-1=1)
        adjacencyMatrix[i][j]=1;
        adjacencyMatrix[j][i]=1;
    }


}
