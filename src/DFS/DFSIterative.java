package DFS;

import Node.GraphNode;

import java.util.ArrayList;
import java.util.Stack;

//This is a linked list implementation pf DFS

public class DFSIterative {

    private ArrayList<GraphNode> nodeList = new ArrayList<>();

    //constructor
    public DFSIterative(ArrayList<GraphNode> nodeList){
        this.nodeList = nodeList;
    }

    //DFS Algorithm:
    public void dfs(){
        for(GraphNode node:nodeList){
            if(!node.isVisited()){
                dfsVisit(node);
            }
        }
    }

    public void dfsVisit(GraphNode node){
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            GraphNode presentNode = stack.pop();
            presentNode.setVisited(true);
            System.out.println(presentNode.getName());

            for(GraphNode neighbor:presentNode.getNeighbors()){
                if(!neighbor.isVisited()){
                    stack.add(neighbor);
                    neighbor.setVisited(true);
                }
            }
        }
    }


    //add an undirected edge between 2 nodes into the linkedlist
    public void addUndirectedEdge(int i, int j){
        GraphNode first = nodeList.get(i-1); //getting the reference of node at index i-1 in the 1d array
        GraphNode second = nodeList.get(j-1);
        first.getNeighbors().add(second);
        second.getNeighbors().add(first);
    }
}
