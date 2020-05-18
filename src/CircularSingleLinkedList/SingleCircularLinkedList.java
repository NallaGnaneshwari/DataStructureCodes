package CircularSingleLinkedList;

public class SingleCircularLinkedList {
private SingleNode head;
private SingleNode tail;
private int size;

    public SingleNode getHead() {
        return head;
    }

    public SingleNode getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public void setHead(SingleNode head) {
        this.head = head;
    }

    public void setTail(SingleNode tail) {
        this.tail = tail;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public SingleNode createSingleLinkedList(int nodeValue){
    head = new SingleNode();
    tail = new SingleNode();
    SingleNode node = new SingleNode();
    node.setValue(nodeValue);
    node.setNext(node);
    head= node;
    tail=node;
    size=1;
    return head;
}

public boolean existsLinkedList(){
        return head!=null;
}

public void insertInLinkedList(int nodeValue, int location){
        SingleNode node = new SingleNode();
        node.setValue(nodeValue);
    System.out.println("Inserting new node at location: "+location);
        if(!existsLinkedList()){
            System.out.println("The LinkedList does not exists");
            return;
        }
        else if(location==0){

            node.setNext(head);
            head=node;
            tail.setNext(node);
        }
        else if(location>=size){
            tail.setNext(node);
            tail=node;
            tail.setNext(head);
        }
        else{
            SingleNode tempNode = head;
            for(int i=0;i<location-1;i++){
                tempNode = tempNode.getNext();
            }
            node.setNext(tempNode.getNext());
            tempNode.setNext(node);
        }
    size++;
}


public void traverseLinkedList(){
        if(existsLinkedList()){
            SingleNode tempNode = head;
            for(int i=0;i<size;i++){
                System.out.print(tempNode.getValue());
                if(i!=size-1){
                    System.out.print("-->");
                }
                tempNode=tempNode.getNext();
            }
            System.out.println();
        }
        else{
            System.out.println("\n LinkedList does not exists");
        }
}


public void deleteLinkedList(){
        if(existsLinkedList()){
            System.out.println("Deleteing Linked List");
            head=null;
            if(tail==null){
                System.out.println("Linked list is already deleted, there is nothing left to be deleted");
                return;
            }

            tail.setNext(null);
            tail=null;
            System.out.println("Linked List deleted successfully");
        }
}

boolean searchNode(int nodeValue){
        SingleNode tempNode = head;
        for(int i=0;i<size;i++){
            if(tempNode.getValue()==nodeValue){
                System.out.println("Found the node at location: "+i);
                return true;
            }
            tempNode=tempNode.getNext();
        }
        System.out.println("Node not found");
        return false;

}


public void deletionOfNode(int location){
        if(!existsLinkedList()){
            System.out.println("The Linked list does not exist!!");
            return;
        }
        else if(location==0){
            head=head.getNext();
            tail.setNext(head);
            size--;

            if(getSize()==0){
                tail=null;
            }
        }
        else if(location>=size){
            SingleNode tempNode = head;
            for(int i=0;i<location-1;i++){
                tempNode = tempNode.getNext();
            }

            if(tempNode==head){
                tail=head=null;
                setSize(getSize()-1);
                return;
            }
            tempNode.setNext(head);
            tail=tempNode;
            size--;
        }

        else{
            SingleNode tempNode = head;
            for (int i = 0; i < location - 1; i++) {
                tempNode = tempNode.getNext(); // we need to traverse till we find the location
            }
            tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
            setSize(getSize()-1);
        }
}

    void printHeadUsingTail() {
        if (existsLinkedList()) {
            System.out.println("Printing Tail...");
            System.out.println(tail.getValue());

            System.out.println("Printing Head using Head reference...");
            System.out.println(head.getValue());

            System.out.println("Printing Head using Tail reference...");
            System.out.println(tail.getNext().getValue());

        }else{
            System.out.println("Linked List does not exists");
        }
    }

}
