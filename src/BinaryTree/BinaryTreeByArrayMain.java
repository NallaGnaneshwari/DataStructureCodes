package BinaryTree;

public class BinaryTreeByArrayMain {
    public static void main(String[] args) {
        BinaryTreeByArray binaryTree = new BinaryTreeByArray(10);

        System.out.println("Inserting 10 elements into Binary Tree");
        for(int i=1;i<11;i++){
            binaryTree.insert(i*10);
        }

        System.out.println("\nLevel-Order Traversal:");
        binaryTree.levelOrder();

        System.out.println("\nPreOrder is:");
        binaryTree.preOrder(1);

        System.out.println("\nPreOrder is:");
        binaryTree.preOrder(3);

        System.out.println("\nPostOrder is:");
        binaryTree.postOrder(1);

        System.out.println("\nInOrder is:");
        binaryTree.inOrder(1);
        System.out.println();

        System.out.println("Searching for a value 500 in the Tree");
        binaryTree.search(500);

        System.out.println("Searching for a value 40 in the Tree");
        binaryTree.search(40);

        System.out.println("Deleting a value 500 in the tree");
        binaryTree.delete(500);

        System.out.println("Deleting a value 40 from the tree");
        binaryTree.delete(40);

        System.out.println("\nLevel Order Traversal after deleting: ");
        binaryTree.levelOrder();

        System.out.println("\nDeleting entire tree");
        binaryTree.deleteTree();
    }
}
