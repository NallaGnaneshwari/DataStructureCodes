package DynamicProgrammingAlgorithms;

public class MinCostToReachLastCell_TopDown {

    public int findMinCost(int[][]cost, int row, int col){
        int[][]dp = new int[row+1][col+1];
        return findMinCost(dp,cost, row, col);
    }

    public int findMinCost(int[][]dp, int[][]cost, int row, int col) {

        //Base cases:
        if(row==-1 || col==-1)
            return Integer.MAX_VALUE;

        if(row==0 && col==0) // BASE CASE: If we're at first cell (0, 0),then no need to recurse
            return cost[row][col];  // or return cost[0][0]

        if (dp[row][col] == 0) { //If problem is not yet solved
            int minCost1 = findMinCost(dp, cost, row - 1, col);
            int minCost2 = findMinCost(dp, cost, row, col - 1);
            int minCost = Math.min(minCost1, minCost2);
            int currentCellCost = cost[row][col];

            dp[row][col] = minCost + currentCellCost;
        }
        return dp[row][col];
    }

    public static void main(String[] args) {
        int[][] array =
                {
                        { 4, 7, 8, 6, 4 },
                        { 6, 7, 3, 9, 2 },
                        { 3, 8, 1, 2, 4 },
                        { 7, 1, 7, 3, 7 },
                        { 2, 9, 8, 9, 3 }
                };
        MinCostToReachLastCell_TopDown mctrlc = new MinCostToReachLastCell_TopDown();
        System.out.print("The minimum cost is " + mctrlc.findMinCost(array, array.length - 1, array[0].length - 1));
    }// end of method
}
