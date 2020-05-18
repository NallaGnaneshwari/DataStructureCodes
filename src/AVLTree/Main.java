package AVLTree;

public class Main {

    public static void main(String[] args) {
        // Constructor
        AVLTree tree = new AVLTree();

        // Insert values in AVL Tree


        tree.insert(30);


        tree.insert(10);
        tree.insert(5);
        tree.insert(3);
        tree.insert(4);
        tree.insert(50);
        tree.insert(65);
        tree.insert(1);

        tree.levelOrderTraversal();
        tree.printTreeGraphically();

        tree.delete(5);//LL Condition
        tree.printTreeGraphically();

        tree.insert(2);
        tree.printTreeGraphically();

        tree.delete(4);//LR Condition
        tree.printTreeGraphically();

        tree.insert(20);
        tree.delete(65);//RR Condition
        tree.printTreeGraphically();

        tree.insert(40);
        tree.delete(20);//RL Condition
        tree.printTreeGraphically();
    }
}
