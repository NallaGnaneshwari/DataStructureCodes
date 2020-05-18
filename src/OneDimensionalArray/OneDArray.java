package OneDimensionalArray;

public class OneDArray {
    int[] arr =null;

    public OneDArray(int sizeOfArray){
        this.arr = new int[sizeOfArray];
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.MIN_VALUE;
        }
    }

    public void traverseArray(){
        try{
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
         }
        catch(Exception e){
            System.out.println("Array no longer exists");
        }
    }

    public void insert(int location, int valueToBeInserted){
        try{
        if(arr[location]==Integer.MIN_VALUE){
            arr[location]=valueToBeInserted;
            System.out.println("Successfully inserted "+valueToBeInserted+" at location: "+location);
        }
        else{
            System.out.println("this cell is already occu[ied by another value");
        }}
        catch(Exception e){
            System.out.println("Invalid index to access array");
            //e.printStackTrace();
        }
    }

    public void access(int cellNumber){
        try{
            System.out.println(arr[cellNumber]);
        }
        catch(Exception e){
            System.out.println("Invalid index to access array");
        }
    }

    public void search(int valueToBeSearched){
        for(int i=0;i<arr.length;i++) {
            if (arr[i] == valueToBeSearched) {
                System.out.println("Value found");
                System.out.println("Index of " + valueToBeSearched + " is: " + i);
               return;
            }
        }
        System.out.println(valueToBeSearched+" not found");

    }

    public void deleteValueFromValue(int deleteValueFromThisCell){
        try{
            arr[deleteValueFromThisCell] = Integer.MIN_VALUE;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Can't delete the value as the cell# provided is not in the range of the array");

        }
    }
}
