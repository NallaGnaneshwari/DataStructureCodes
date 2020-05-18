



package BinaryHeap;



public class HeapByArray {

  private int[] arr;
  private int sizeOfHeap;

    public HeapByArray(int size){
        arr = new int[size+1];
        this.sizeOfHeap=0; //keeps track of elements in array,
        // since we store the 1st element of tree at index=1,
        // we initialize this to '0' when there are no elements in the array.
        System.out.println("Empty Heap has been created");
    }

    public int sizeOfArray(){
        return arr.length;
    }

    public int sizeOfTree(){
        System.out.println("Size Of Tree: " + sizeOfHeap);
        return sizeOfHeap;
    }

    public boolean isHeapEmpty() {
        if (sizeOfHeap <= 0) {
            System.out.println("Tree is empty !");
            return true;
        }else {
            System.out.println("Tree is not empty !");
            return false;
        }
    }//end of method

    public void peek(){
        if(sizeOfHeap==0)
            System.out.println("The Tree is empty!!");
        else
        {
            System.out.println("Head/Root of Heap is: "+arr[1]);
        }
    }

    public void deleteHeap(){
        System.out.println("Deleting the Heap");
        arr=null;
        System.out.println("Heap has been successfully deleted");
    }

    public void insertInHeap(int value){
        //step 1: insert at the 1st vacant position
        System.out.println("Inserting value "+value+" into the Heap");
        arr[sizeOfHeap+1]=value;
        sizeOfHeap++;
        //step 2: Heapify bottom to top
        heapifyBottomToTop(sizeOfHeap);
        System.out.println("Insertion successfull");
        printHeap();
    }


    public int extractFromHeap(){
        if(sizeOfHeap==0){
            System.out.println("The Binary Heap Tree is empty to delete!");
            return -1;
        }
        else {
            //step 1: delete the root element
            System.out.println("The Head of Heap is:  "+arr[1]);
            System.out.println("Extracting it now....");
            int extractedValue = arr[1];


            //step 2: place last element at the root
            arr[1]=arr[sizeOfHeap];
            sizeOfHeap--;
            //step 3: Heapify top to bottom
            heapifyTopToBottom(1);
            System.out.println("Successfully extracted");
            printHeap();

            return extractedValue;
        }
    }

    // we are doing for minHeap Tree
    public void heapifyBottomToTop(int index){
        int parent = index/2;
        if(index<=1){ // we are already at the root of the tree. Hence no more Heapifying is required.
                return;
            }
             // If Current value is smaller than its parent, then we need to swap
            if (arr[index] < arr[parent]) {
                int tmp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = tmp;
            }
        heapifyBottomToTop(parent);  // why parent? Because the node which was initially is at index is now moved to parents location. So compare it with further nodes

        }

    // we are doing for minHeap Tree
    public void heapifyTopToBottom(int index){
        int left= index*2;
        int right = (index*2)+1;
        int smallestChild =0;


        if(sizeOfHeap<left){ //if there is no child of this node, then nothing to do.Just return.
            return ;
        }
        else if(sizeOfHeap == left){ // it has left child but no right child, then do a comparison and return.
            if(arr[index]>arr[left]){
                int tmp = arr[index];
                arr[index]=arr[left];
                arr[left]=tmp;
            }
            return;
        }
        else{ // when the element at given index has both right and left child

                 // 1st find the smallest element among both the nodes
                 if(arr[left]<arr[right])
                    {
                   smallestChild= left;
                     }
               else{
                   smallestChild = right;
                    }

           // 2nd:  if parent is greater than smallest child, then swap
            if(arr[index]>arr[smallestChild]){
                int temp= arr[index];
                arr[index]= arr[smallestChild];
                arr[smallestChild]=temp;
            }
        }
        heapifyTopToBottom(smallestChild);

    }



    public void printHeap(){
        System.out.println("Printing all the elements in the heap .... ");
        for(int i=1;i<=sizeOfHeap;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");
    }
}
