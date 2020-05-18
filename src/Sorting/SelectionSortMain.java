package Sorting;

public class SelectionSortMain {
    public static void main(String[] args) {
        int[] array={10,3,2,5,8,4,3,1,2,9,7,8};

        System.out.println("Array Before Sorting");
        SelectionSort.printArray(array);

        SelectionSort.selectionSort(array);

        System.out.println("Array after Sorting");
        SelectionSort.printArray(array);
    }
}
