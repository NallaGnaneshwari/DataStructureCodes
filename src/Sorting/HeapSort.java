package Sorting;

import heap.*;

public class HeapSort {

    int[] arr=null;
    public HeapSort(int[] arr){
        this.arr=arr;
    }

    public void heapSort() {
        //using HeapByArray class to do the sorting
        HeapByArray hba = new HeapByArray(arr.length);
        for (int i = 0; i < arr.length; i++) { //inserting array elements into Heap
            hba.insertInHeap(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {//extracting from heap and putting back in array
            arr[i] = hba.extractFromHeap();
        }
    }

    public void printArray(){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}
