package Stack;

public class SingleLinkedList {



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
            node.setNext(null);
            head = node;
            tail=node;
            size=1;
            return head;
        }

        public void insertInLinkedList(int nodeValue, int location){
            SingleNode node = new SingleNode();
            node.setValue(nodeValue);
            if(!existsLinkedList()){
                System.out.println("The linked list does not exists");
                return ;
            }
            else if(location==0){
                node.setNext(head);
                head=node;
            }
            else if(location>=size){
                tail.setNext(node);
                node.setNext(null);
                tail = node;
            }
            else {
                SingleNode tempNode = head;
                int index=0;
                while(index<location-1){
                    tempNode = tempNode.getNext();
                    index++;
                }
                node.setNext(tempNode.getNext());
                tempNode.setNext(node);

                //for(int index=0;index<location-1;index++){
                // tempNode = tempNode.next()}
            }
            setSize(getSize()+1);
        }

        public boolean existsLinkedList(){
            return head!=null;
        }


        void traverseLinkedList(){
            if(existsLinkedList()){
                SingleNode tempNode =head;
                for(int i=0;i<getSize();i++){
                    System.out.print(tempNode.getValue()+" ");
                    tempNode = tempNode.getNext();
                }
            }
            else{
                System.out.println("Linked List does not exists!");
            }
            System.out.println("\n");
        }


        void deleteLinkedList(){
            System.out.println(" Deleting linked list....");
            head = null;
            tail = null;
            System.out.println("Linked list deleted successfully");
        }

        // Searches a node with given value
        boolean searchNode(int nodeValue){
            if(existsLinkedList()){
                SingleNode tempNode = head;
                for(int i=0;i<getSize();i++){
                    if(tempNode.getValue()==nodeValue){
                        System.out.println("Found the node at location: "+i+"\n");
                        return true;
                    }
                    tempNode = tempNode.getNext();
                }
            }
            System.out.println("Node not found! \n");
            return false;
        }

        public void deletionOfNode(int location){
            if(!existsLinkedList()){
                System.out.println("The linked list does not exist!");
                return;
            }
            else if(location==0){
                head = head.getNext();
                setSize(getSize()-1);

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
                    head=tail=null;
                    setSize(getSize()-1);
                    return;
                }

                tempNode.setNext(null);
                tail=tempNode;
                setSize(getSize()-1);

            }
            else{
                SingleNode tempNode=head;
                for(int i=0;i<location-1;i++){
                    tempNode=tempNode.getNext();
                }
                tempNode.setNext((tempNode.getNext().getNext()));
                setSize(getSize()-1);
            }
        }


}
