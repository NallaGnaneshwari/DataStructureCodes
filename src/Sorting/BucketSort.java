package Sorting;
import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    int arr[];


    //Constructor
    public BucketSort(int arr[]) {
        this.arr = arr;
    }


    //Sorting method
    public void bucketSort() {

        //step1: Find out number of buckets needed
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;


        //Find the min and max value from the array
        for(int value: arr) {
            if(value < minValue) {
                minValue = value;
            }else if (value > maxValue) {
                maxValue = value;
            }
        }


        //Step2: Create an array of buckets
        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];


        //Step3: initializing empty buckets
        for(int i =0;i<buckets.length;i++) {
            buckets[i] = new ArrayList<Integer>();
        }


        for(int value: arr) {
            int bucketNumber = (int) Math.ceil ((value *  numberOfBuckets) / maxValue);
            //System.out.println("bucketNumber: " + bucketNumber);
            buckets[bucketNumber-1].add(value);
        }


        System.out.println("\n\nPrinting buckets before Sorting...");
        printBucket(buckets);


        //Step4: Sort Buckets
        for(ArrayList<Integer> bucket: buckets) {
            Collections.sort(bucket);
        }


        System.out.println("\n\nPrinting buckets after Sorting...");
        printBucket(buckets);


        //Step5: Merge sorted buckets
        int index=0;
        for(ArrayList<Integer> bucket: buckets) {
            for(int value: bucket) {
                arr[index] = value;
                index++;
            }
        }
    }//end of method

    //Prints Array
    public void printArray() {
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
            tmp++;
            if(tmp == 20) {
                System.out.println();
                tmp = 0;
            }
        }
    }


    //Prints Buckets
    public void printBucket(ArrayList<Integer>[] buckets) {
        for(int i=0; i<buckets.length; i++) {
            System.out.println("\nBucket#" + i + " :");
            for (int j=0; j<buckets[i].size(); j++) {
                System.out.print(buckets[i].get(j)+"  ");
            }
        }

    }
}//end of class





//package sorting;
//
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class BucketSort {
//
//    int[] arr;
//
//    public BucketSort(int[] arr){
//        this.arr=arr;
//    }
//
//    public void bucketSort(){
//
//        int numberOfBuckets = (int)Math.ceil(Math.sqrt(arr.length));
//        int maxValue = Integer.MAX_VALUE;
//        int minValue = Integer.MIN_VALUE;
//
//
//        //finding min and max value in the array
//        for(int value:arr){
//            if(value<minValue){
//                minValue=value;
//            }
//            else if(value>maxValue){
//                maxValue=value;
//            }
//        }
//
//
//        //step2: Create an array of buckets
//        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
//
//
//        for(int i=0;i<buckets.length;i++){
//            buckets[i]= new ArrayList<Integer>();
//        }
//
//        for(int value:arr){
//            int bucketNumber = (int)Math.ceil((value*numberOfBuckets)/maxValue);
//            System.out.println("bucketNumber: " + bucketNumber);
//            buckets[bucketNumber-1].add(value);
//        }
//
//        System.out.println("Printing buckets before sorting");
//        printBuckets(buckets);
//
//
//        for(ArrayList<Integer> bucket: buckets){
//            Collections.sort(bucket);
//        }
//
//        System.out.println("Printing buckets after sorting");
//        printBuckets(buckets);
//
//        //step5: merge sorted buckets
//        int index=0;
//        for(ArrayList<Integer>bucket: buckets){
//            for(int value:bucket){
//                arr[index]= value;
//                index++;
//            }
//        }
//
//    }
//
//    public void printBuckets(ArrayList<Integer>[] buckets){
//        for(int i=0;i<buckets.length;i++){
//            System.out.println("\nBucket#"+i+" :");
//            for(int j=0;j<buckets[i].size();j++){
//                System.out.println(buckets[i].get(j)+" ");
//            }
//        }
//    }
//
//
//    //Prints Array
//    public void printArray() {
//        int tmp = 0;
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i]+" ");
//            tmp++;
//            if(tmp == 20) {
//                System.out.println();
//                tmp = 0;
//            }
//        }
//    }
//
//}





//Time: O(n)+O(nlogn)+O(n) --> assuming we use merge sort for sorting buckets
//Space: O(n) --> since we create buckets and store our 'n' elements into buckets