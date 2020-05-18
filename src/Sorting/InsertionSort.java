package Sorting;

public class InsertionSort {


    public static void insertionSort(int[] arr){

        // outer loop tells how many times to do the iteration
        for(int i=1;i<arr.length;i++){  // starting from 1 because, 1st element picked has nothing to compare with, so we directly place it
            int tmp = arr[i], j=i;
            while(j>0 && tmp<arr[j-1]){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=tmp;
        }
    }


    public static void printArray(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}




//Time: O(n^2)
//Space: O(1)