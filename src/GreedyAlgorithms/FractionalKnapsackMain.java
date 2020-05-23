package GreedyAlgorithms;

import java.util.ArrayList;

public class FractionalKnapsackMain {
    public static void main(String[] args) {

        //Create ArrayList of Objects
        ArrayList<FractionalKnapsackItem> items = new ArrayList<>();
        int[] value = {6,2,1,8,3,5};
        int[] weight = {6,10,3,5,1,3};
        int capacity = 10;

        for(int i=0;i<value.length;i++){
            items.add(new FractionalKnapsackItem(i+1,value[i],weight[i]));
        }

        //calling Knapsack algorithm
        FractionalKnapsack.knapSack(items,capacity);

    }
}
