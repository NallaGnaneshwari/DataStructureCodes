package DivideAndConquerAlgorithms;

public class NumberOfPathsToReachLastCell {

    //Algorithm
    public int numberOfPaths(int[][] array, int row, int col, int cost){

        if(cost<0) //Base case
            return 0;

        if(row==0 && col==0){//Base case
            return (array[0][0]-cost == 0)?1:0;
        }
        if(row==0) {//Base case: if we're at the first row, we can only reach there from left,but not from top
        return numberOfPaths(array,0,col-1,cost-array[row][col]);
        }

        if(col==0){//Base case: if we're at the first col, we can reach there only from top, not from left
            return numberOfPaths(array,row-1,0,cost-array[row][col]);
        }

        int noOfPathsFromPrevRow = numberOfPaths(array, row-1,col,cost-array[row][col]);
        int noOfPathsFromPrevCol = numberOfPaths(array, row,col-1,cost-array[row][col]);
        return noOfPathsFromPrevCol+noOfPathsFromPrevRow;
    }//end of Algorithm

    public static void main(String[] args) {
        int[][] array = {
                { 4, 7, 1, 6 },
                { 5, 7, 3, 9 },
                { 3, 2, 1, 2 },
                { 7, 1, 6, 3 } };
        int cost = 25;
        NumberOfPathsToReachLastCell nops = new NumberOfPathsToReachLastCell();
        System.out.println("Total paths with cost "+cost+" are: "+ nops.numberOfPaths(array,array.length-1, array[0].length-1, cost));
    }// end of main
}
