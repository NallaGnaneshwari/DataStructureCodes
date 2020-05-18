package CircularDoubleLinkedList;

public class DoubleCircularLinkedList {
    private int size;
    private DoubleNode head;
    private DoubleNode tail;

    public int getSize() {
        return size;
    }

    public DoubleNode getHead() {
        return head;
    }

    public DoubleNode getTail() {
        return tail;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setHead(DoubleNode head) {
        this.head = head;
    }

    public void setTail(DoubleNode tail) {
        this.tail = tail;
    }

    public DoubleNode createDoubleLinkedList(int nodeValue){
        head = new DoubleNode();
        tail = new DoubleNode();
        DoubleNode node=new DoubleNode();
        node.setValue(nodeValue);
        node.setNext(node);
        node.setPrev(node);
        head=node;
        tail=node;
        size=1;
        return head;
    }

    public boolean existsLinkedList(){
        return head!=null;
    }

    public void insertInLinkedList(int nodeValue,int location){
        DoubleNode node=new DoubleNode();
        node.setValue(nodeValue);
        if(!existsLinkedList()){
            System.out.println("Linked List does not exists");
            return ;
        }
        else if(location==0){
          node.setNext(head);
          node.setPrev(tail);
          head.setPrev(node);
          tail.setNext(node);   //head.setNext(node)
          head=node;
        }
        else if(location>=size){
            node.setNext(head);
            node.setPrev(tail);
            tail.setNext(node);
            head.setPrev(node);
            tail=node;
        }
        else{
            DoubleNode tempNode =head;
            for(int i=0;i<location-1;i++){
                tempNode = tempNode.getNext();
            }
            node.setNext(tempNode.getNext());
            node.setPrev(tempNode);
            tempNode.setNext(node);
            node.getNext().setPrev(node);
        }

        size++;

    }



    void traverseLinkedList(){
        DoubleNode tempNode=head;
        if(existsLinkedList()){
        System.out.println("Printing Linked List");
        for(int i=0;i<size;i++){
            System.out.print(tempNode.getValue());
            if(i!=size-1){
                System.out.print(" --> ");
            }
            tempNode = tempNode.getNext();
        }
            System.out.println();
        }
        else{
            System.out.println("Linked List does not exist!");
        }
    }

    void traverseLinkedListInReverseOrder(){
        DoubleNode tempNode=tail;
        if(existsLinkedList()){
            System.out.println("Printing Linked List");
            for(int i=0;i<size;i++){
                System.out.print(tempNode.getValue());
                if(i!=size-1){
                    System.out.print(" <-- ");
                }
                tempNode = tempNode.getPrev();
            }
            System.out.println();
        }
        else{
            System.out.println("Linked List does not exist!");
        }
    }

    void printHeadUsingTail(){
        if(existsLinkedList()){
            System.out.println("Printing Tail....");
            System.out.println(tail.getValue());

            System.out.println("Printing Head using Head reference");
            System.out.println(head.getValue());

            System.out.println("Printing Head using tail reference");
            System.out.println(tail.getNext().getValue());
        }

        else
        {
            System.out.println("Linked List does not exists");
        }

    }



    public void deleteLinkedList(){
        System.out.println("Deleting Linked list: ");
        DoubleNode tempNode=head;
        if(tail==null){
            System.out.println("Linked List already deleted");
        }

        for(int i=0;i<size;i++){
            tempNode.setPrev(null);
        }

      // head.setPrev(null);
        tail.setNext(null);
        head=null;
        tail=null;
        System.out.println("Linked List deleted successfully");
    }


    public boolean searchNode(int nodeValue) {

        if (existsLinkedList()) {
            DoubleNode tempNode = head;
            for (int i = 0; i < size; i++) {
                if(tempNode.getValue()==nodeValue){
                    System.out.println("Found node at location: "+i);
                    return true;
                }
                tempNode=tempNode.getNext();
            }
        }
        System.out.println("Node not found");
         return false;
    }


    public void deletionOfNode(int location){
        if(!existsLinkedList()){
            System.out.println("Linked List does not exists");
        }
        else if(location==0){
            if(getSize()==1){
                head.setNext(null);
                head.setPrev(null);
                head=null;
                tail=null;
                size--;
                return;
            }

            head=head.getNext();
            head.setPrev(tail);
            tail.setNext(head);
            size--;
        }
        else if(location>=size){
            if(getSize()==1){
                head.setNext(null);
                head.setPrev(null);
                head=null;
                tail=null;
                size--;
                return;
            }
                tail=tail.getPrev();
                tail.setNext(head);
                head.setPrev(tail);
                size--;
        }
        else{
            DoubleNode tempNode = head;
            for(int i=0;i<location-1;i++){
                tempNode=tempNode.getNext();
            }
            tempNode.setNext(tempNode.getNext().getNext());
            tempNode.getNext().setPrev(tempNode);
            size--;
        }
    }
}
