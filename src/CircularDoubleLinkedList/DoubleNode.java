package CircularDoubleLinkedList;

public class DoubleNode {
    private int value;
    private DoubleNode prev;
    private DoubleNode next;

    public int getValue() {
        return value;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }

    public void setNext(DoubleNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return value+"";
    }
}
