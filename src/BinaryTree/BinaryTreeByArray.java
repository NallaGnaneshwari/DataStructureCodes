package BinaryTree;

public class BinaryTreeByArray {
    int[] arr;
    int lastUsedIndex;


    //creating a blank binary tree
    public BinaryTreeByArray(int size){
        arr=new int[size];
        lastUsedIndex=0;
    }

    public boolean isTreeFull()
    {
        if(lastUsedIndex==arr.length-1){
            return true;
        }
            return false;
    }

    public boolean isEmpty(){
        if(lastUsedIndex==0)
            return true;
        return false;
    }


    public void insert(int value) {
        //value will always be inserted after the lastUsedIndex
        if (!isTreeFull()) {
            arr[lastUsedIndex + 1] = value;
            lastUsedIndex++;
            System.out.println("Successfully inserted " + value + " into the Tree");
        }
        else {
            System.out.println("Could not insert, the Tree is already full");
        }
    }


    public int search(int value){
        for(int i=1;i<=lastUsedIndex;i++){
            if(arr[i]==value){
                System.out.println(value+" exists in the Tree! It is at the location "+i);
                return i;
            }
        }
        System.out.println(value+" does not exist in the Tree!");
        return -1;
    }


    public void delete(int value){
        //1.find the value
        //2.find the deepest node (obvi last element in the array)
        //3. replace the value with the deepest node
        //4.delete the deepest node


        int location=search(value);
        if(location==-1){
           return;
        }

        else {
            arr[location] = arr[lastUsedIndex];
            lastUsedIndex--;
            System.out.println("Successfully delete " + value + " from the Tree!");
        }
    }

    public void deleteTree(){
        arr=null;
        System.out.println("Tree has been successfully deleted!!!");
    }



    //Traversals:

    public void levelOrder(){    // already arranged in a level-order fashion, so we just print it
        for(int i=1;i<=lastUsedIndex;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }


    public void inOrder(int index){
        if(index>lastUsedIndex){
            return;
        }
        else{
            inOrder(2*index);
            System.out.print(arr[index]+" ");
            inOrder(index*2+1);
        }
        //System.out.println();
    }



    public void preOrder(int index){
        if(index>lastUsedIndex){
            return; //do nothing,just go back
        }
        else{
            System.out.print(arr[index]+" ");
            preOrder(index*2);
            preOrder(index*2+1);
        }
       // System.out.println();
    }

    public void postOrder(int index){
        if(index>lastUsedIndex){
            return;
        }
        else{
            postOrder(index*2);
            System.out.print(arr[index]+" ");
            postOrder(index*2+1);
        }
       // System.out.println();
    }


}
