package Queue;

public class QueueByArray {

    int[] arr;
    int beginningOfQueue;
    int topOfQueue;

    public QueueByArray(int size){
        arr = new int[size];
        topOfQueue=-1;
        beginningOfQueue=-1;
        System.out.println("Successfully created an empty queue of size: "+size);
    }

    public void enQueue(int value){
        if(isQueueFull()){
            System.out.println("Queue overflow error!");
        }
        else if(isQueueEmpty()){
            beginningOfQueue=0;
            topOfQueue++;
            arr[topOfQueue]=value;
            System.out.println("Successfully inserted "+value+" into the queue");

        }
        else{
            topOfQueue++;
            arr[topOfQueue]=value;
            System.out.println("Successfully inserted "+value+" into the queue");
        }

       printQueue();
    }

    public void printQueue(){
        if(!isQueueEmpty()){
            System.out.println("Queue now is..");
            for(int i=beginningOfQueue;i<=topOfQueue;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
        else{
            System.out.println("There are no elements to print the Queue");
        }
    }

    public boolean isQueueEmpty(){
        if(beginningOfQueue==-1)
            return true;
        else
            return false;
    }

    public boolean isQueueFull(){
        if(topOfQueue==arr.length-1)
            return true;
        else
            return false;
    }

    public void deQueue(){
        if(isQueueEmpty()){
            System.out.println("Queue underflow error");
        }
        else{
            System.out.println("Dequeing value from the Queue...");
            System.out.println("Dequeued: "+arr[beginningOfQueue]+" from queue");
            beginningOfQueue++;

            if(beginningOfQueue>topOfQueue)
                beginningOfQueue=topOfQueue=-1;
        }

        printQueue();
    }

    public void peekOperation(){
        if(isQueueEmpty()){
            System.out.println("The Queue is empty!!! Can't peek");
        }
        else
            System.out.println(arr[beginningOfQueue]);
    }

    public void deleteQueue(){
        arr=null;
        System.out.println("Successfully deleted the Queue!!!");
    }
}
