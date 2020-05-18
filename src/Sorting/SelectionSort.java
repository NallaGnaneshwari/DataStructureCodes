package Sorting;

public class SelectionSort {

    public static void selectionSort(int[] arr) {


        for (int i = 0; i < arr.length; i++) {
            int minimumIndex = i;

            //find which is the smallest element to right of 'i'
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minimumIndex]) {
                    minimumIndex = j;
                }
            }//end of inner loop
            //checking if this is the only element left to swap, if not we can swap
            if (minimumIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minimumIndex];
                arr[minimumIndex] = temp;
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }
}


//Time: O(n^2)
//Space: O(1)