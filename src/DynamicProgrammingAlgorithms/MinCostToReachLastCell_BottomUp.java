package DynamicProgrammingAlgorithms;

public class MinCostToReachLastCell_BottomUp {


    //Algorithm
    public int findMinCost(int[][] array, int row, int col) {


        //step1: create a dp array
        int[][] dp = new int[row + 1][col + 1];//extra row and column to store A0K0,A0K1,A1K0 etc...


        //step2: filling base cases or extra row and column
        for(int i=0; i<=col; i++) {  //Initialize default value in row
            dp[0][i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<=row; i++) {  //Initialize default value in col
            dp[i][0] = Integer.MAX_VALUE;
        }
        dp[0][1] = 0;//This is done to make sure that first comparison goes through successfully since A1K1 = min(A0K1, A1K0) = min(maxvalue, maxValue) would result in a maxvalue


        //step 3: filling remaining rows and columns
        for(int i=1; i<=row; i++) {
            for(int j=1; j<=col; j++) {
                dp[i][j] = Integer.min(dp[i-1][j],dp[i][j-1]) + array[i-1][j-1];
            }
        }
        return dp[row][col]; //returning big answer which is present in last row last column
    } // end of Algorithm


    public static void main(String[] args) {
        int[][] array =
                {
                        { 4, 7, 8, 6, 4 },
                        { 6, 7, 3, 9, 2 },
                        { 3, 8, 1, 2, 4 },
                        { 7, 1, 7, 3, 7 },
                        { 2, 9, 8, 9, 3 }
                };
       MinCostToReachLastCell_BottomUp mctrlc = new MinCostToReachLastCell_BottomUp();
        System.out.print("The minimum cost is " + mctrlc.findMinCost(array, array.length, array[0].length));
    }// end of method
}//end of class