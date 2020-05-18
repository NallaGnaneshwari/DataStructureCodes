package Sorting;

public class MergeSort {

    public static void mergeSort(int[] Array, int left, int right){
        //left --> start index
        //right --> end index
        if(right>left){ //array has more than 1 elements
            int middle = (left+right)/2;
            mergeSort(Array,left,middle);
            mergeSort(Array,middle+1,right);
            merge(Array,left,middle,right);
        }
    }

    public static void merge(int[] A,int left, int middle, int right){
        int[] leftTmpArray = new int[middle-left+2]; //creating temporary arrays
        int[] rightTmpArray = new int[right-middle+1];

        //copy values from array A to these tmp arrays
        for(int i=0;i<=middle-left;i++){
            leftTmpArray[i]=A[left+i];
        }
        for(int i=0;i<right-middle;i++){
            rightTmpArray[i]=A[middle+1+i];
        }

        //Merge values and insert into Array 'A'
        leftTmpArray[middle-left+1]= Integer.MAX_VALUE;
        rightTmpArray[right-middle] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = left; k <= right; k++) {
            if (leftTmpArray[i] < rightTmpArray[j]) {
                A[k] = leftTmpArray[i];
                i++;
            } else {
                A[k] = rightTmpArray[j];
                j++;
            }
        }

    }



    public static void printArray(int []array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+"  ");
        }
    }//end of method
}
