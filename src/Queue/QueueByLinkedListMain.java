package Queue;

public class QueueByLinkedListMain {
    public static void main(String[] args) {

        System.out.println("Creating a Queue");
        QueueByLinkedList queue = new QueueByLinkedList();

        System.out.println("EnQueueing 6 values into the queue");
        for(int i=1;i<=6;i++){
            queue.enQueue(i*10);
        }


        System.out.println("Peeking Value");
        System.out.println(queue.peek());
        System.out.println();


        System.out.println("DeQueueing 6 values from the queue");
        for(int i=0;i<=6;i++){
            System.out.println(queue.deQueue());
        }


    }
}
