package Sorting;

public class BubbleSortMain {
    public static void main(String[] args) {
        BubbleSort bs=new BubbleSort();
        int arr[] = {10,5,30,15,50,6};
        System.out.println("Array Before Sorting");
        bs.printArray(arr);
        bs.bubbleSort(arr);
        System.out.println("Array After Sorting");
        bs.printArray(arr);
    }
}
