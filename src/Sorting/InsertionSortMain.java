package Sorting;

public class InsertionSortMain {
    public static void main(String[] args) {
        int[] array={10,3,2,5,8,4,3,1,2,9,7,8};

        System.out.println("Array Before Sorting");
        InsertionSort.printArray(array);

        InsertionSort.insertionSort(array);

        System.out.println("Array after Sorting");
        InsertionSort.printArray(array);
    }
}
