

package AVLTree;

import Node.BinaryNode;

import java.util.LinkedList;
import java.util.Queue;


public class AVLTree {
    BinaryNode root;

    //creation
    public void AVLTree(){
        this.root = null;
    }

    // Traversals
    //Level Order Traversal
    public void levelOrderTraversal(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        System.out.println("Printing Level Order traversal of AVL Tree");

        if(root==null){
            System.out.println("Tree does not exists");
            return;   // returning back to the calling function
        }

        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.getValue()+" ");
            if(presentNode.getLeft()!=null){
                queue.add(presentNode.getLeft());
            }
            if(presentNode.getRight()!=null){
                queue.add(presentNode.getRight());
            }
        }
    }



//    public void search(int value){
//        search(root,value);
//    }

    public void insert(int value){
       root = insert(root,value);
    }

    public void delete(int value){
        root = delete(root,value);
    }

    //helper methods for above 3 methods.




    public BinaryNode insert(BinaryNode root, int value){
        if(root==null) {
            System.out.println("Successfully inserted "+value+" in AVL Tree");
            return createNewNode(value);
        }
        else if(value<=root.getValue()){
            root.setLeft(insert(root.getLeft(),value));

        }
        else{
            root.setRight(insert(root.getRight(),value));
        }


        // THIS IS WHERE WE DO AVL Specific work, check balancing
        int balance = checkBalance(root.getLeft(), root.getRight());
        if(balance>1){
            if(checkBalance(root.getLeft().getLeft(),root.getLeft().getRight())>0) {  //LL condition
                root = rightRotate(root);
            }

            else { //LR condition
                root.setLeft(leftRotate(root.getLeft()));
                root = rightRotate(root);  // right rotate returns a newRoot, and we are assigning that to root
            }
        }
        else if(balance<-1){
            if(checkBalance(root.getRight().getRight(), root.getRight().getLeft())>0){ // RR condition
                root= leftRotate(root);
            }

            else{ //RL Condition
                root.setRight(rightRotate(root.getRight()));
                root = leftRotate(root);// left rotate returns a newRoot, and we are assigning that to root
            }
        }

        //Height adjustments
        if(root.getLeft()!=null){
            root.getLeft().setHeight(calculateHeight(root.getLeft()));
        }
        if(root.getRight()!=null){
            root.getRight().setHeight(calculateHeight(root.getRight()));
        }
        root.setHeight(calculateHeight(root));

        return root;
    }


    public BinaryNode createNewNode(int value){
        BinaryNode node = new BinaryNode();
        node.setValue(value);
        node.setHeight(0);
        return node;
    }

    //Rotation methods
    public BinaryNode rightRotate(BinaryNode currentNode){
        BinaryNode newRoot = currentNode.getLeft();
        currentNode.setLeft(currentNode.getLeft().getRight());
        newRoot.setRight(currentNode);

        currentNode.setHeight(calculateHeight(currentNode));
        newRoot.setHeight(calculateHeight(newRoot));
        return newRoot;
    }



    public BinaryNode leftRotate(BinaryNode currentNode){
        BinaryNode newRoot = currentNode.getRight();
        newRoot.setLeft(currentNode);
        currentNode.setRight(currentNode.getRight().getLeft());

        currentNode.setHeight(calculateHeight(currentNode));
        newRoot.setHeight(calculateHeight(newRoot));
        return newRoot;
    }

    public int calculateHeight(BinaryNode currentNode){
        if(currentNode==null)
            return 0;  // if left and right nodes are null  max = -1 and then we add 1,  (-1)+1=0
        return 1+ Math.max((currentNode.getLeft()!=null?currentNode.getLeft().getHeight():-1),
                (currentNode.getRight()!=null?currentNode.getRight().getHeight():-1));

    }

    public int checkBalance(BinaryNode RootsLeftNode, BinaryNode RootsRightNode){
        if(RootsLeftNode==null && RootsRightNode==null){
            return 0;
        }
        else if(RootsLeftNode==null)
            return RootsRightNode.getHeight();
        else if(RootsRightNode==null)
            return RootsLeftNode.getHeight();
        else
          return RootsLeftNode.getHeight()-RootsRightNode.getHeight();
    }


    // root is nothing but currentElement in the below case, for easy unddrstanding i named it as "root"
    public BinaryNode delete(BinaryNode root, int value){
        if(root==null){
            return null;
        }
        else if(value<=root.getValue()){
            root.setLeft(delete(root.getLeft(),value));
        }
        else if(value>root.getValue()){
            root.setRight(delete(root.getRight(),value));
        }
        else{ //value found, now deletion happens
            if(root.getLeft()!=null && root.getRight()!=null){ //node to be deleted has 2 children (#Case3)
                //1.find the successor, i.e., least element in the right tree
                BinaryNode minimumElement = minimumElement(root.getRight());
                //2.replace the root with this minimum element
                root.setValue(minimumElement.getValue());
                //delete the minimumElement from the right subtree
                delete(root.getRight(),minimumElement.getValue());
            }
            else if(root.getLeft()!=null)  //Node to be deleted has left child (#Case2)
                root= root.getLeft();
            else if(root.getRight()!=null) //Node to be deleted has right child (#Case2)
                root = root.getRight();
            else  // if the node to be deleted is the leaf node;
                root = null;
        }

        //THIS IS WHERE WE DO AVL SPECIFIC WORK
        int balance = checkBalance(root.getLeft(),root.getRight());
        if(balance > 1) // left subtree has the overhead
        {
            if(checkBalance(root.getLeft().getLeft(),root.getLeft().getRight())>1){ //LL condition
                root=rightRotate(root);
            }
            else{ //LR condition
                root.setLeft(root.getLeft());
                root=rightRotate(root);
            }
        }
        else if(balance<-1){//right subtree has the overhead
            if(checkBalance(root.getRight().getRight(),root.getRight().getLeft())>1){ //RR Condition
                root=leftRotate(root);
            }
            else{ // RL Condition
                root.setRight(rightRotate(root.getRight()));
                root= leftRotate(root);
            }
        }

        //Height adjustments
        if(root.getLeft()!=null){
            root.getLeft().setHeight(calculateHeight(root.getLeft()));
        }
        if(root.getRight()!=null){
            root.getRight().setValue(calculateHeight(root.getRight()));
        }
        root.setHeight(calculateHeight(root));

        return root;  //sending root back to the calling function so that it establishes a connection
    }


    public BinaryNode minimumElement(BinaryNode rootsRightNode){
        if(rootsRightNode.getLeft()==null){
            return rootsRightNode;
        }
        else{
            return minimumElement(rootsRightNode.getLeft());
        }
    }

 public void deleteAVLTree(){
     System.out.println("Deleting AVL Tree....");
     root=null;
     System.out.println("Successfully deleted the Tree");
 }


    public void printTreeGraphically(){
        Queue<BinaryNode> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        if(root==null){
            System.out.println("Tree is empty, nothing to print");
            return; //just go back to calling function
        }

        queue.add(root);
        level.add(1);

        int currentLevel = 1;
        boolean previousWasLevelAllNull = false;

        while(!queue.isEmpty()){
            if(level.peek()==currentLevel){ //when in the same level
                if(queue.peek()==null){
                    queue.add(null);
                    level.add(currentLevel+1);
                }
                else{
                    queue.add(queue.peek().getLeft());
                    level.add(currentLevel+1);
                    queue.add(queue.peek().getRight());
                    level.add(currentLevel+1);
                }
                System.out.print(queue.remove());
                previousWasLevelAllNull=false;
            }
            else{ //when changed to different level
                System.out.println("\n");
                currentLevel++;

                // we have to write a break condition for while loop,
                // because we adding null values also,
                // so there has to be some break condition.
                if(previousWasLevelAllNull){
                    break;
                }
               previousWasLevelAllNull=true;
            }
        }
    }

}
