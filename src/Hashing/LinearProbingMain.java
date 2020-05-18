package Hashing;



public class LinearProbingMain {
    public static void main(String[] args) {

        //Constructor
        LinearProbing linearProbing = new LinearProbing();


        linearProbing.insertKeyInHashTable("The");
        linearProbing.insertKeyInHashTable("quick");
        linearProbing.insertKeyInHashTable("brown");
        linearProbing.insertKeyInHashTable("fox");
        linearProbing.insertKeyInHashTable("over");
        linearProbing.insertKeyInHashTable("lazy");
        linearProbing.displayHashTable();

        linearProbing.insertKeyInHashTable("fox"); //use for showing collision
        linearProbing.displayHashTable();



    }//end of method

}//end of class

