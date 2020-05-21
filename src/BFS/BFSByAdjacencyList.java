package BFS;

import Node.GraphNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFSByAdjacencyList {

    private ArrayList<GraphNode> nodeList = new ArrayList<>();


    //constructor
    public BFSByAdjacencyList(ArrayList<GraphNode> nodeList){
        this.nodeList= nodeList;
    }


    //BFS Algorithm:
    public void bfs(){
        for(GraphNode node:nodeList){
            if(!node.isVisited()){
                bfsVisit(node);
            }
        }
    }


    //BFS Internal method
    public void bfsVisit(GraphNode node){ //it uses a queue internally, and that queue is implemented using a LL
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            GraphNode presentNode = queue.remove(0);
            presentNode.setVisited(true);
            System.out.println(presentNode.getName()+" ");
            for(GraphNode neighbor:presentNode.getNeighbors()){
                if(!neighbor.isVisited()){
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                }
            }
        }

    }


    //add an undirected edge between two nodes - edges are stored in Adjacency list
    public void addUndirectedEdge(int i, int j){
        GraphNode first = nodeList.get(i-1);   //getting vertex at i-1th position in the 1d array
        GraphNode second = nodeList.get(j-1);

        //getting the list of neighbors and adding new neighbor node into it
        first.getNeighbors().add(second);//Neighbour of first is second. Store it.
        second.getNeighbors().add(first);//Neighbour of second is first. Store it.
    }


}
