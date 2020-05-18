package Queue;

public class QueueByLinkedList {

    SingleLinkedList list;

    public QueueByLinkedList(){
        list=new SingleLinkedList();
        System.out.println("Successfully created an empty queue with LL at backend");
    }

    public void enQueue(int value){
        if(list.getHead()==null){
            list.createSingleLinkedList(value);
            System.out.println("Inserted 1st value into the queue"+value);
        }
        else{
            list.insertInLinkedList(value,list.getSize());
            System.out.println("Inserted "+value+" into linked list");
        }
    }

    public int deQueue(){
        int value=-1;
        if(isQueueEmpty()){
            System.out.println("Queue underflow error");
        }
        else{
            value=list.getHead().getValue();
            list.deletionOfNode(0);
        }
        return value;
    }

    public int peek(){
        if(!isQueueEmpty()){
            return list.getHead().getValue();
        }
        else{
            System.out.println("The Queue is empty");
            return -1;
        }
    }

    public boolean isQueueEmpty(){
        if(list.getHead()==null)
            return true;
        else
            return false;
    }

    public void deleteQueue(){
        list.setHead(null);
    }

    }
