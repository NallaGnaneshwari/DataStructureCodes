package Stack;

public class StackByLinkedList {
 SingleLinkedList list;

    public StackByLinkedList() {
        list=new SingleLinkedList();
    }

    public void push(int value) {
        if (list.getHead() == null) {
            list.createSingleLinkedList(value);
        }
        else {
            list.insertInLinkedList(value, 0);
            System.out.println("Inserted "+value+" into the stack");
        }
    }
    public int pop(){
        int value=-1;
        if(isEmpty())
            System.out.println("Stack underflow error!!");
        else {
            value = list.getHead().getValue();
            list.deletionOfNode(0);
        }
        return value;
    }

    public int peek(){
        if(!isEmpty()){
            return list.getHead().getValue();
        }
        else{
            System.out.println("The stack is empty");
            return -1;
        }
    }

    public boolean isEmpty(){
        if (list.getHead()==null){
            return true;
        }
        return false;
    }

    public void deleteStack(){
        list.setHead(null);
    }
}
