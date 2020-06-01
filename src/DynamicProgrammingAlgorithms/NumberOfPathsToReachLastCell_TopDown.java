package DynamicProgrammingAlgorithms;

public class NumberOfPathsToReachLastCell_TopDown {

    public int numberOfPaths(int array[][], int row, int col, int cost){
        int[][]dp = new int[row+1][col+1];
        return numberOfPaths(dp,array,row,col,cost );
    }


    public int numberOfPaths(int[][]dp, int[][] array, int row, int col, int cost){

        //Base cases:
        if(cost<0)  //negative cost case
            return 0;

        if(row==0 && col==0){ // if we are at the 1st cell
            return (array[0][0]-cost==0)?1:0;   //if both are equal
            //if(cost-array[0][0]==0){
            //   return 1;
            //}
        }

        if(dp[row][col]==0){ //if the problem is not yet solved
            if(row ==0 ){ // we are in the 1st row, then only option to reach those elements is from left
                dp[row][col]= numberOfPaths( array, 0, col-1,cost-array[row][col]);
            }

            else if(col==0){  //we are in the 1st column, the only option to reach those elements is from the top
                dp[row][col]= numberOfPaths( array, row-1,0,cost-array[row][col]);
            }
            else{
                int numOfPathsToReachTopElement = numberOfPaths( array,row-1, col, cost-array[row][col] );// Find Paths till last Row
                int numOfpathsToReachLeftElement = numberOfPaths( array, row, col-1, cost-array[row][col]);
                dp[row][col]= numOfpathsToReachLeftElement+ numOfPathsToReachTopElement;
            }
        }

        return dp[row][col];
    }

    public static void main(String[] args) {
        int[][] array = {
                { 4, 7, 1, 6 },
                { 5, 7, 3, 9 },
                { 3, 2, 1, 2 },
                { 7, 1, 6, 3 } };
        int cost = 25;
        NumberOfPathsToReachLastCell_TopDown nop = new NumberOfPathsToReachLastCell_TopDown();
        System.out.println("Total paths with cost " + cost + " are " + nop.numberOfPaths(array, array.length - 1, array[0].length - 1, cost));
    }// End of method
}
