package OneDimensionalArray;

public class Main {

    public static void main(String[] args) {
        OneDArray first = new OneDArray(10);
        first.traverseArray();
        first.insert(0,0);
        first.insert(1,10);
        first.insert(2,20);
        first.insert(3,30);
        first.insert(4,40);
        first.insert(5,50);
        first.insert(6,60);
        first.insert(7,70);
        first.insert(8,80);
        first.insert(1,100);

        first.insert(11,4);

//        first.traverseArray();

        System.out.println();

        System.out.println("Accessing elements");
        first.access(5);
        System.out.println();

        System.out.println("Searching 30 in array");
        first.search(30);
        System.out.println("Searching 400 in array");
        first.search(400);

        System.out.println();
        System.out.println("Deleting values in array");
        System.out.println("Array before deleting");
        first.traverseArray();
        first.deleteValueFromValue(5);
        System.out.println("Array after deleting");
        first.traverseArray();
        System.out.println();
    }
}
