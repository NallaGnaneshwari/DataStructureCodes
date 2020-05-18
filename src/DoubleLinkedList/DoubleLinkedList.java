package DoubleLinkedList;

public class DoubleLinkedList {

    DoubleNode head;
    DoubleNode tail;
    int size;

    public DoubleNode getHead() {
        return head;
    }

    public DoubleNode getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public void setHead(DoubleNode head) {
        this.head = head;
    }

    public void setTail(DoubleNode tail) {
        this.tail = tail;
    }

    public void setSize(int size) {
        this.size = size;
    }

    DoubleNode createDoubleLinkedList(int nodeValue){
        //head = new DoubleNode();
        //tail = new DoubleNode();
        DoubleNode node = new DoubleNode();
        node.setValue(nodeValue);
        node.setNext(null);
        node.setPrev(null);
        head=node;
        tail=node;
        size=1;
        return head;
    }

    boolean existsLinkedList(){
        return head!=null;
    }

    void insertInLinkedList(int nodeValue, int location){
        DoubleNode node = new DoubleNode();
        node.setValue(nodeValue);
        if(!existsLinkedList()){
            System.out.println("Linked List does not exists");
            return;
        }
        else if(location==0){
            node.setNext(head);
            node.setPrev(null);
            head.setPrev(node);
            head=node;
        }
        else if(location>=size){
            node.setNext(null);
            node.setPrev(tail);
            tail.setNext(node);
            tail=node;
        }
        else{
            DoubleNode tempNode = head;
            for(int i=0;i<location-1;i++){
                tempNode=tempNode.getNext();
            }
            node.setNext(tempNode.getNext());
            node.setPrev(tempNode);
            tempNode.setNext(node);
            node.getNext().setPrev(node);
        }

        size++;
    }

    void traverseLinkedList(){
        if(existsLinkedList()) {
            DoubleNode tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.getValue());
                if (i != size - 1) {
                    System.out.print(" --> ");
                }
                tempNode = tempNode.getNext();
            }
        }
        else{
            System.out.println("Linked List does not exists");
        }
        System.out.println("\n");
    }

    void traverseLinkedListInReverseOrder(){
        if(existsLinkedList()) {
            DoubleNode tempNode = tail;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.getValue());
                if (i != size - 1) {
                    System.out.print(" --> ");
                }
                tempNode = tempNode.getPrev();
            }
        }
        else{
            System.out.println("Linked List does not exists");
        }
        System.out.println("\n");
    }

    void deleteLinkedList(){
        System.out.println("Deleting linked List....");
        DoubleNode tempNode=head;
        for(int i=0;i<size;i++){
            tempNode.setPrev(null);
            tempNode=tempNode.getNext();
        }
        head=null;
        tail=null;
        System.out.println("Linked list successfully deleted");
    }


    boolean searchNode(int nodeValue){

        if(existsLinkedList()){

            DoubleNode tempNode= head;
            for(int i=0;i<size;i++){
                if(tempNode.getValue()==nodeValue){
                    System.out.println("Node found at location: "+i);
                    return true;
                }
                tempNode=tempNode.getNext();
            }
        }
        System.out.println("Node not found!");
        return false;
    }


    public void deletionOfNode(int location) {
        if (!existsLinkedList()) {
            System.out.println("The linked list does not exist!!");// Linked List does not exists
            return;
        } else if (location == 0) { // we want to delete first element
            if (getSize() == 1) { // if this is the only node in this list
                head = tail = null;
                setSize(getSize() - 1);
                return;
            }else {
                head = head.getNext();
                head.setPrev(null);
                setSize(getSize() - 1);
            }
        } else if (location >= getSize()) { // If location is not in range or equal, then delete last node
            DoubleNode tempNode = tail.getPrev(); // temp node points to 2nd last node
            if (tempNode == head) { // if this is the only element in the list
                tail = head = null;
                setSize(getSize() - 1);
                return;
            }
            tail=tail.getPrev();
            tail.setNext(null);
//            tempNode.setNext(null);
//            tail = tempNode;
            setSize(getSize() - 1);

        } else { // if any inside node is to be deleted
            DoubleNode tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.getNext(); // we need to traverse till we find the location
            }
            tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
            tempNode.getNext().setPrev(tempNode);
            setSize(getSize() - 1);  //or size--;
        } // end of else

    }// end of method
}
