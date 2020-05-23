package GreedyAlgorithms;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FractionalKnapsack {


    static void knapSack(ArrayList<FractionalKnapsackItem> items, int capacity) {

        //sort items based on the ratio in a descneding order
        // Implement comparator interface and specify which variable('Ratio') of user defined class should the "compare" method use
        // This needs to be done because the Collections.sort() method will use the comparator in the sort() method.

        Comparator<FractionalKnapsackItem> comparator = new Comparator<FractionalKnapsackItem>() {
            @Override
            public int compare(FractionalKnapsackItem o1, FractionalKnapsackItem o2) {
                if(o2.getRatio()>o1.getRatio())return 1;
                else return -1;
            }
        };


        //Sort all the objects stored in the Arraylist by 'Ratio' variable
        Collections.sort(items, comparator);

        int usedCapacity = 0; // capacity of knapsack used
        double totalValue = 0;  // total value of the items picked

        //Algorithm
        for (FractionalKnapsackItem item : items) {

            if(usedCapacity+ item.getWeight()<=capacity) { //consume fully
                usedCapacity+=item.getWeight();
                totalValue+=item.getValue();
                System.out.println("Taken: "+item);
            }

            else { //else consume fractionally
                int remainingCapacity = capacity - usedCapacity;
                double value = item.getRatio()*remainingCapacity; // ratio is nothing but value per 1 single unit, so remaining capacity * single unit value
                usedCapacity+=remainingCapacity;
                totalValue+=value;
                System.out.println("Taken: "+"item index = " + item.getIndex() + ",consumed value = " + value + ",used weight = " + remainingCapacity + ", ratio = " + item.getRatio());

            }
            //if capacity is full then break
            if(usedCapacity==capacity)break;
        }
        //print finally obtained value
        System.out.println("\nTotal value obtained: "+ totalValue);
    }//end of method

}//end of class
