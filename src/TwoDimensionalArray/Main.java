package TwoDimensionalArray;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Creating a blank array of 5*5");
        TwoDimensionalArray tda = new TwoDimensionalArray(5,5);
        tda.traverseArray();


        tda.insertValueInTheArray(0,2,1000000001);
        tda.traverseArray();


        tda.insertValueInTheArray(0,2,50000005);
        tda.traverseArray();

        tda.accessSingleVlaue(0,2);
        tda.accessSingleVlaue(6,2);
        tda.accessSingleVlaue(2,2);

        tda.searchingSingleValue(10);
        tda.searchingSingleValue(-2147483648);
        tda.searchingSingleValue(1000000001);

        System.out.println("before deleting");
        tda.traverseArray();
        tda.deleteValue(0,2);
        tda.traverseArray();

        tda.deleteThisEntireArray();
        tda.traverseArray();
    }
}
