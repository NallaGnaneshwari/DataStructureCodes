package Node;



public class SingleNode {
    private int value;
    private SingleNode next;


    public int getValue() {
        return value;
    }

    public SingleNode getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(SingleNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value+"";
    }
}

