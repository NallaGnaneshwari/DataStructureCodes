package Hashing;

import java.util.ArrayList;

public class LinearProbing {

    String[] hashTable;
    int noOfCellsUsedInHashTable;

    public LinearProbing(){
        hashTable = new String[13];
        noOfCellsUsedInHashTable=0;
    }

    // Hash Function that's used in keys to produce a hash Value
    public int simpleASCIIHashFunction(String x, int modulo){
        char ch[];
        ch=x.toCharArray();
        int sum =0;
        for(int i=0;i<ch.length;i++){
            sum+= ch[i];
        }
        return sum % modulo;
    }


    // calculating load factor
    public double getLoadfactor(){
        double loadFactor = noOfCellsUsedInHashTable*1.0 / hashTable.length;
        return loadFactor;
    }


    //Insert a key in HashTable
    public void insertKeyInHashTable(String value){
        if(getLoadfactor()>=0.75){ // that means almost 3/4th of the hash table is full
        // so we need to rehash in new table doubling the size
            System.out.println("Load Factor of this Hash Table has exceeded 0.75, hence we need to Rehash! ");
            rehashKeys(value);
        }
        else{
            System.out.println("Inserting \"" + value + "\" in HashTable...");
            int index= simpleASCIIHashFunction(value, hashTable.length);

            for(int i=index;i<index+hashTable.length;i++){
                int newIndex = i%hashTable.length;

                if(hashTable[newIndex]==null){ //If index is blank, then insert there
                    System.out.println("Index: " + newIndex + " is blank. Inserting there...");
                    hashTable[newIndex]=value;
                    System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + newIndex);
                    System.out.println("-------------------------------------------\n");
                    break;
                }
                else{
                    System.out.println("Index: " + newIndex + " is already occupied. Trying next empty cell...");
                }
            }
        }
        noOfCellsUsedInHashTable++;
    }


    // Creare a new HashTable and does ReHashing
    public void rehashKeys(String newStringToBeInserted){
        noOfCellsUsedInHashTable=0;  // need to reset it as we are now dealing with a fresh Hashtable

        // copy the non-null hash table contents to a temporary array list for now
        ArrayList<String> data = new ArrayList<>();
        for(String s:hashTable){
            if(s!=null)
            data.add(s);
        }
        data.add(newStringToBeInserted);

        // create a new hash table of double the size and copy the contents from arraylist into this new hash table
        hashTable = new String[hashTable.length*2];
        for(String s: data){
            insertKeyInHashTable(s);
        }
    }




    // Search for a given key in hashTable

   /* public boolean searchKeyInHashTable(String stringToBeSearched){
        int index = simpleASCIIHashFunction(stringToBeSearched,hashTable.length);
        if(hashTable[index]!=null && hashTable[index].equals(stringToBeSearched)){
            System.out.println("\n" + "\"" + stringToBeSearched + "\"" + " found in HashTable at location: "+index);
            return true;
        }
        System.out.println("\n" + "\"" + stringToBeSearched + "\"" + " not found in HashTable.");
        return false;
    }
   */

    // OR
    public boolean searchKeyInHashTable(String stringToBeSearched) {
        int index = simpleASCIIHashFunction(stringToBeSearched, hashTable.length);
        for (int i = index; i < index + hashTable.length; i++) {
            int newIndex = i % hashTable.length;
            if (hashTable[newIndex]!=null && hashTable[newIndex].equals(stringToBeSearched)) {
                System.out.println("\n" + "\"" + stringToBeSearched + "\"" + " found in HashTable at location: "+newIndex);
                return true;
            }
        }
        System.out.println("\n" + "\"" + stringToBeSearched + "\"" + " not found in HashTable.");
        return false;
    }//end of method


    //Delete Key from Hash Table

   /* public void deletekeyFromHashTable(String stringToBeDeleted){
        int index=simpleASCIIHashFunction(stringToBeDeleted,hashTable.length);
        if(searchKeyInHashTable(stringToBeDeleted)==true){
            hashTable[index]=null;
            System.out.println("\n" + "\"" + stringToBeDeleted + "\"" + " has been found in HashTable." );
            System.out.println("\"" + stringToBeDeleted + "\"" + " has been deleted from HashTable !" );
            return;
        }
        System.out.println("\nCould not find " + "\"" + stringToBeDeleted + "\"" + " in HashTable");
    }
    */

   // OR
   public void deleteKeyFromHashTable(String stringToBeDeleted) {
       int index = simpleASCIIHashFunction(stringToBeDeleted, hashTable.length);
       for (int i = index; i < index + hashTable.length; i++) {
           int newIndex = i % hashTable.length;
           if (hashTable[newIndex]!=null && hashTable[newIndex].equals(stringToBeDeleted)) {
               hashTable[newIndex] = null;
               System.out.println("\n" + "\"" + stringToBeDeleted + "\"" + " has been found in HashTable." );
               System.out.println("\"" + stringToBeDeleted + "\"" + " has been deleted from HashTable !" );
               return;
           }
       }
       System.out.println("\nCould not find " + "\"" + stringToBeDeleted + "\"" + " in HashTable");
   }//end of method


    // Print/Display Hash Table
    public void displayHashTable()
    {
        if(hashTable==null){
            System.out.println("\n Hash Table does not exists !");
            return ;
        }
        else{
            System.out.println(" ----------------- Hash Table ----------------- ");
            for(int i=0;i< hashTable.length;i++){
                System.out.println("Index: "+i+" , key: "+hashTable[i]);
            }
        }
    }



    // Delete entire Hash Table
    public void deleteHashTable(){
        System.out.println("Deleting Hash Table....");
        hashTable=null;
        System.out.println("Successfully deleted HashTable !");
    }


}
