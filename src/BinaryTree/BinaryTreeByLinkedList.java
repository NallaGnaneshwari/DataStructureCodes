package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeByLinkedList {
    BinaryNode root;

    //constructor for creating a binary tree
    public BinaryTreeByLinkedList() {
        this.root = null;
    }



    public void insert(int value){
        BinaryNode node = new BinaryNode();
        node.setValue(value);

        //if 1st node
        if(root==null){
            root = node;
            System.out.println("Successfully inserted new node at the Root");
            return;
        }
        //do a level-order traversal to find the vacant position
        //1.create an empty queue and add enqueue node
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        //find the 1st vacant node
        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            if(presentNode.getLeft()==null){
                presentNode.setLeft(node);
                System.out.println("Successfully inserted new node!");
                break;
            }
            else if(presentNode.getRight()==null){
                presentNode.setRight(node);
                System.out.println("Successfully inserted new node!");
                break;
            }
            else{
                queue.add(presentNode.getLeft());
                queue.add(presentNode.getRight());
            }
        }
    }


    public void search(int value){
        //do a level-order traversal to find if the value is present in the tree
        //1. create a blank queue and enqueue the root
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            if(presentNode.getValue()==value){
                System.out.println("Value: "+value+" is found in the Tree");
                return;
            }
            else{
                if(presentNode.getLeft()!=null)
                    queue.add(presentNode.getLeft());
                if(presentNode.getRight()!=null)
                    queue.add(presentNode.getRight());
            }
        }
        System.out.println("Value: "+value+" is not found in Tree!");
    }


    public void deleteNodeOfBinaryTree(int value){
        // 1st find the node
        //2nd find the deepest node
        //3rd replace node with the deepest node
        //delete the deepest node

        // 1st find the node - do a level order traversal to find the node
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            //if node is found, copy the deepest node here
            if(presentNode.getValue()==value){
                presentNode.setValue(getDeepestNode().getValue());
                deleteDeepestNode();
                System.out.println("Deleted the Node! ");
                return ;
            }
            else{
                if(presentNode.getLeft()!=null)
                    queue.add(presentNode.getLeft());
                if(presentNode.getRight()!=null)
                    queue.add(presentNode.getRight());
            }
        }
        System.out.println("Did not find the node in the Tree");

    }

    public BinaryNode getDeepestNode(){
        // do a level order traversal to find out the last node/deepest node
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode presentNode=null;
        while(!queue.isEmpty()){
            presentNode = queue.remove();
            if(presentNode.getLeft()!=null)
                queue.add(presentNode.getLeft());
            if(presentNode.getRight()!=null)
                queue.add(presentNode.getRight());
        }
        return presentNode;
    }



    //Delete deepest node
    public void deleteDeepestNode() {
        //do a level order traversal to find out the last node/deepest node
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);

        BinaryNode previousNode, presentNode = null;
        while (!queue.isEmpty()) {
            previousNode = presentNode; //initially when we start at root present and previous are both the same
            presentNode = queue.remove();

            if (presentNode.getLeft() == null) {
                previousNode.setRight(null);
                return;
            }else if ((presentNode.getRight() == null)) {
                presentNode.setLeft(null);
                return;
            }

            //if(presentNode.getLeft()!=null)
            queue.add(presentNode.getLeft());
            //if(presentNode.getRight()!=null)
            queue.add(presentNode.getRight());
        }
    }


    public void preOrder(BinaryNode node){
        if(node==null)
            return;
        System.out.print(node.getValue()+" ");
        preOrder(node.getLeft());
        preOrder(node.getRight());

    }


    public void postOrder(BinaryNode node){
        if(node==null)
            return;
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.print(node.getValue()+" ");
    }

    public void inOrder(BinaryNode node){
        if(node==null)
            return;
        inOrder(node.getLeft());
        System.out.print(node.getValue()+" ");
        inOrder(node.getRight());
    }

    public void levelOrder(){
        //create a blank queue
        // enqueue the root
        // repeat the below steps until the queue is not empty
        // deQueue the first element in queue
        // do any operation you want to do, like print or compare or whatever with the dequeued element
        // add the dequeued elements children into the queue.


        //create a blank queue and add the root/first element into the queue
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.getValue()+" ");
            if(presentNode.getLeft()!=null)
                queue.add(presentNode.getLeft());
            if(presentNode.getRight()!=null)
                queue.add(presentNode.getRight());
        }
        System.out.println();
    }


    public void deleteTree(){
        root=null;
        System.out.println("Binary Tree successfully deleted");
    }
}

