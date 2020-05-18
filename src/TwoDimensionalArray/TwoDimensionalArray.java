package TwoDimensionalArray;

public class TwoDimensionalArray {
    int[][] arr;
    public TwoDimensionalArray(int rows, int columns){
        this.arr=new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                arr[i][j]=Integer.MIN_VALUE;
            }
        }
    }

    public void traverseArray(){
        try{
            System.out.println("Printing the array now");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j< arr[0].length;j++){
                System.out.print(arr[i][j]+", ");
            }
            System.out.println();
        }
            System.out.println();
    }
        catch(Exception e){
            System.out.println("Array no longer exists");
            System.out.println();}
    }

    public void insertValueInTheArray(int row,int col,int value){
        try{
            if(arr[row][col]==Integer.MIN_VALUE){
                arr[row][col]= value;
                System.out.println("successfully inserted the value "+value+" in the array");
            }
            else{
                System.out.println("This cell is already occupied with some other value");
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("You are trying to reach an invalid index");
        }

    }

    public void accessSingleVlaue(int row, int col){
        try{
            System.out.println("accessing cell in row: "+row+ ", col: "+col+" = "+arr[row][col]);
            System.out.println();
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Trying to access from an invalid index");
            System.out.println();
        }
    }

    public void searchingSingleValue(int val){
        System.out.println("searching for value:"+val);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]==val){
                    System.out.println("The value "+val +" has been found at "+i +"th row and "+j+"th coloumn");
                    System.out.println();
                    return; // we return this method because we did not search any more after that
                }
            }
        }
        System.out.println("The value: "+val+" is not found");
        System.out.println();
    }

    public void deleteValue(int row, int col){
        System.out.println("deleting the value from row@: "+row+" col: "+col+"...");
        try{
           arr[row][col]=Integer.MIN_VALUE;
            System.out.println("Successfully deleted the value \n");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Trying to delete from an invalid index position \n");
        }
    }

    public void deleteThisEntireArray(){
        this.arr = null;
        System.out.println("Successfully deleted the array ");
    }

}
