package DynamicProgrammingAlgorithms;

// capacity --> along x-axis, profits --> along y-axis

public class ZeroOneKnapsack_BottomUp {

    public int solveKnapsack(int[] profits, int[] weights, int capacity){

        int numberOfRows = profits.length+1; // adding a dummy row to avoid array index issues
        int[][] dp = new int[profits.length+1][capacity+1]; // Create a 2D Array to store all the results

        //Base case
        //inserting 0 in 1st column as it is dummy column to avoid array index issues
        for(int i=0;i<numberOfRows;i++){
            dp[i][0]=0;
        }

        //inserting 0 in last row as it is a dummy column
        for(int j=0;j<=capacity;j++){
            dp[numberOfRows-1][j]=0;
        }

        //filling last row to 1st row (1st column to last column)
        for(int row=profits.length-1;row>=0;row--){//or i=numberOfRows-2
            for(int column=1;column<=capacity;column++){ //column represents current capacity
                int profit1=0, profit2=0;
                if(weights[row]<=column){
                    profit1 = profits[row]+dp[row+1][column-weights[row]]; //taking that element
                }

                profit2 = 0+ dp[row+1][column]; //not taking that element
                dp[row][column] = Math.max(profit1,profit2);

            }

        }
        return dp[0][capacity];
    }
    public static void main(String[] args) {
        ZeroOneKnapsack_BottomUp ks = new ZeroOneKnapsack_BottomUp();
        int[] profits = { 31, 26, 72, 17 };
        int[] weights = { 3, 1, 5, 2 };
        System.out.println(ks.solveKnapsack(profits, weights, 7));
    }// end of method

}
