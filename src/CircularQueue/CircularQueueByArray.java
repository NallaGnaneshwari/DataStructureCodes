package CircularQueue;

public class CircularQueueByArray {
    int[] arr;
    int topOfQueue;
    int beginningOfQueue;
    int size;

    public CircularQueueByArray(int size){
        arr=new int[size];
        topOfQueue=-1;
        beginningOfQueue=-1;
        this.size=size;
        System.out.println("Successfully created an empty queue of size: "+size);
    }


    public void printArray() {
        System.out.println("The Array now is....");
        if (isQueueEmpty()) {

            System.out.println("There is nothing to print");
        }
        else {
            for (int i = 0; i <size; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            System.out.println("Start = "+beginningOfQueue+" ,element at start is "+arr[beginningOfQueue]);
            System.out.println("End = "+topOfQueue+" ,element at the top is "+arr[topOfQueue]);
        }
    }


    public boolean isQueueEmpty(){
        if(topOfQueue==-1)
            return true;
        else
            return false;
    }


    public boolean isQueueFull(){
        if((beginningOfQueue==0)&&(topOfQueue+1==size))// Trivial case of Queue
            return true;
        else if(topOfQueue+1 == beginningOfQueue) //If we have completed one full circle
            return true;
        else
            return false;
    }

    public void initializeStartOfArray() {
        if (beginningOfQueue == -1) {
            beginningOfQueue = 0;
        }
    }

    public void enQueue(int value){

        if(arr==null){
            System.out.println("Array is not yet created.Please create one first.");
        }
        else if(isQueueFull()){
            System.out.println("Queue overflow error!! ");
        }

        else{
//            if(isQueueEmpty()){ // inserting 1st element into queue
//                beginningOfQueue=0;
//            }

            initializeStartOfArray();
            if(topOfQueue+1 == arr.length){
                topOfQueue=0;
            }
            else {
                topOfQueue++;
            }

            arr[topOfQueue]=value;
            System.out.println("Sucessfully inserted "+value+" in the queue");
        }
    }

    public void deQueue(){
        if(isQueueEmpty()){
            System.out.println("Queue underflow error!! ");
        }
        else{
            System.out.println("\n---------------------------------------");
            System.out.println("Before Dequeue...");
            printArray();
            System.out.println("Now let's dequeue "+arr[beginningOfQueue]);
            arr[beginningOfQueue]=0;
            if(beginningOfQueue==topOfQueue){ //only element in the queue
                beginningOfQueue=topOfQueue=-1;
            }
            else if(beginningOfQueue+1==arr.length){//if start has reached end of the array
                beginningOfQueue=0;
            }
            else{
                beginningOfQueue++;
            }
        }
        System.out.println("After Dequeing...");
        printArray();
        System.out.println("-------------------------------");
    }

    public void deleteQueue(){
        System.out.println("Deleting the entire Queue");
        arr=null;
        System.out.println("Queue is successfully deleted");
    }
}
