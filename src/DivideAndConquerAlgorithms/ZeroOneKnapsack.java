package DivideAndConquerAlgorithms;

public class ZeroOneKnapsack {

    public int knapsack(int[]profits, int[] weights, int capacity){
        return knapsack(profits, weights, capacity, 0);
    }

    public int knapsack(int[] profits, int [] weights, int capacity, int currentIndex){

        if(capacity<=0 || currentIndex>=profits.length|| currentIndex<0){
            return 0;
        }

        int profit1 =0;
        if(weights[currentIndex]<= capacity){ // Taking current item
            profit1 = profits[currentIndex]+knapsack(profits, weights, capacity-weights[currentIndex], currentIndex+1);
        }

        int profit2 = 0 + knapsack(profits, weights, capacity, currentIndex+1);

        return Math.max(profit1,profit2);
    }

    public static void main(String[] args) {
        ZeroOneKnapsack ks = new ZeroOneKnapsack();
        int[] profits = { 31, 26, 72, 17 };
        int[] weights = { 3, 1, 5, 2 };
        int maxProfit= ks.knapsack(profits, weights,7);
        System.out.println("max Profit obtained is:" + maxProfit);
    }//end of main
}//end of class


