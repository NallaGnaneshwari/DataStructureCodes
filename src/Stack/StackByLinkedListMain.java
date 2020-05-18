package Stack;

public class StackByLinkedListMain {
    public static void main(String[] args) {

        StackByLinkedList stack = new StackByLinkedList();
        System.out.println("Pushing 10 values into stack");
        for(int i=0;i<10;i++){
        stack.push(i*10);
        }
        System.out.println();

        System.out.println("Peeking value");
        System.out.println(stack.peek());
        System.out.println();

        System.out.println("Popping 11 values from the stack");
        for(int i=1;i<=11;i++){
            System.out.println(stack.pop());
        }
    }
}
