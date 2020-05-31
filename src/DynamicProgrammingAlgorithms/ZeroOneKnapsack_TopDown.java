package DynamicProgrammingAlgorithms;

public class ZeroOneKnapsack_TopDown {

    public int solveKnapsack(int[] profits, int[] weights, int capacity){

        int numberOfRows = profits.length; //adding dummy row to avoid array index issues
        Integer[][]dp = new Integer[numberOfRows][capacity+1];//create a 2D array to store all the results. Capacity can range from 0 to given value
        return solveKnapsack(dp, profits, weights, capacity, 0);

    }

    public int solveKnapsack(Integer[][]dp, int[] profits, int[] weights, int capacity, int currentIndex){

        //Base case
        if(capacity<=0 || currentIndex<0||currentIndex>=profits.length)
            return 0;


        if(dp[currentIndex][capacity]!=null) // if we already solved the problem
            return dp[currentIndex][capacity];
        //else solve it now
        int profit1=0;
        if(weights[currentIndex]<=capacity)  //pick the element
            profit1= profits[currentIndex]+solveKnapsack(dp,profits, weights, capacity-weights[currentIndex], currentIndex+1);

        int profit2= 0 + solveKnapsack(dp,profits,weights,capacity,currentIndex+1);
        dp[currentIndex][capacity]=Math.max(profit1, profit2); //skip the element
        return dp[currentIndex][capacity];
    }

    public static void main(String[] args) {
        ZeroOneKnapsack_TopDown ks = new ZeroOneKnapsack_TopDown();
        int[] profits = { 31, 26, 72, 17 };
        int[] weights = { 3, 1, 5, 2 };
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println(maxProfit);
    }//end of method
}
