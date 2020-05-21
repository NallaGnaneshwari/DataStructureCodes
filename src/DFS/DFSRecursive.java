package DFS;

import Node.GraphNode;

import java.util.ArrayList;

public class DFSRecursive {
    ArrayList<GraphNode> nodeList = new ArrayList<>();

    //constructor
    public DFSRecursive(ArrayList<GraphNode>nodeList){
        this.nodeList=nodeList;
    }

    //DFS Algorithm
    public void dfs(){
        for(GraphNode node:nodeList){
            if(!node.isVisited()){
                dfsVisit(node);
            }
        }
    }

    public void dfsVisit(GraphNode node){

        node.setVisited(true);
        System.out.println(node.getName());
        for(GraphNode neighbor:node.getNeighbors()){
            if(!neighbor.isVisited()){
                //recursive call to dfs function
                dfsVisit(neighbor);
            }
        }
    }

    // add an undirected edge between two nodes
    public void addUndirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i-1);
        GraphNode second = nodeList.get(j-1);
        first.getNeighbors().add(second);
        second.getNeighbors().add(first);
    }

    }
