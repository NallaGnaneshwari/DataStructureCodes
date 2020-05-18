package Queue;

public class QueueByArrayMain {

    public static void main(String[] args) {
        System.out.println("Creating an empty queue");
        QueueByArray queue = new QueueByArray(5);

        System.out.println("Enqueueing 6 values into the queue...");
        for(int i=1;i<=6;i++){
            queue.enQueue(i*10);
        }

        System.out.println("Peek value from queue");
          queue.peekOperation();


        System.out.println("Dequeueing 6 values from the queue...");
        for(int i=0;i<=5;i++){
            queue.deQueue();
        }

        System.out.println("Deleting the entire queue....");
        queue.deleteQueue();
    }
}
