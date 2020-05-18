package Hashing;


import java.util.ArrayList;

public class QuadraticProbing {

    String[] hashTable;
    int noOfCellsUsedInHashTable;

    public QuadraticProbing(){
        hashTable = new String[13];
        noOfCellsUsedInHashTable=0;
    }

    //Hash Function
    public int simpleASCIIHashFunction(String key, int modulo){
        char[] ch;
        ch=key.toCharArray();
        int sum=0;
        for(int i=0;i<ch.length;i++){
            sum+=ch[i];
        }
        return sum % modulo;
    }


    // LoadFactor
    public double getLoadFactor(){
        double loadFactor = noOfCellsUsedInHashTable*1.0 / hashTable.length ;
        return loadFactor;
    }


    // printing hash table
    public void displayHashTable(){
        if(hashTable==null){
            System.out.println("\nHash Table does not exists");
            return;
        }
        else{
            System.out.println("\n---------- Hash Table ----------");
            for(int i=0; i<hashTable.length;i++){
                System.out.println("index: "+ i+" key: "+hashTable[i]);
            }
            System.out.println("--------------------");
        }
    }

    // delete HashTable
    public void deleteHashTable(){
        System.out.println("Deeleting Hash Table....");
        hashTable=null;
        System.out.println("Successfully deleted the Hash table");
    }



    // insert into hash table
    // step 1: check load factor, if load factor exceeds 0.75 just rehash, otherwise just insert
    public void insertKeyInHashTable(String value){
        double loadFactor = getLoadFactor();
        if(loadFactor>=0.75){
            System.out.println("Load factor of this HashTable exceeded 0.75, hence we need to Rehash!");
            rehashKeys(value);
        }
        else{
            System.out.println("Inserting value: \"" +value+ "\" in Hash Table");
            int index = simpleASCIIHashFunction(value, hashTable.length);
            int counter=0;

            for(int i=index;i<index+hashTable.length;i++){
                int newIndex= (index+ (counter*counter))%hashTable.length;

                if(hashTable[newIndex]==null){
                    System.out.println("Index: "+newIndex+" is blank, so inserting there.. ");
                    hashTable[newIndex]=value;
                    System.out.println("Successfully inserted + \" "+value+"\" at location "+newIndex);
                    System.out.println("\n");
                    break;
                }
                else{
                    System.out.println("Index: "+newIndex+" already occupied. Trying next empty cell....");
                }
                counter++;
            }
        }
        noOfCellsUsedInHashTable++;
    }


    public void rehashKeys(String value){
        noOfCellsUsedInHashTable=0; //reset it as we are now dealing with a new hash table
        //copy the non-null hash table contents into a temporary array list
        ArrayList<String> data = new ArrayList<>();
        for(String s: hashTable){
            if(s!=null)
            data.add(s);
        }
        data.add(value);

        //create a new HashTable of double the size and copy the contents of array list into this hash table
        hashTable = new String[hashTable.length*2];
        for(String s:data){
            insertKeyInHashTable(s);
        }
    }


    // search for a key in hash table
    public boolean searchKeyInHashTable(String stringToBeSearched){
        int index = simpleASCIIHashFunction(stringToBeSearched, hashTable.length);

        for(int i=index; i<index+hashTable.length;i++){
            int newIndex = i%hashTable.length;

            if(hashTable[newIndex]!=null && hashTable[newIndex].equals(stringToBeSearched)){
                System.out.println("\n"+"\""+stringToBeSearched+"\" found in the Hash Table");
                return true;
            }
        }

        System.out.println("\n"+"\""+stringToBeSearched+"\" not found in HashTable");
        return false;
    }

    // Delete key from HashTable
    public void deleteKeyFromHashTable(String stringToBeDeleted) {
        int index = simpleASCIIHashFunction(stringToBeDeleted, hashTable.length);
        for (int i = index; i < index + hashTable.length; i++) {
            int newIndex = i % hashTable.length;
            if (hashTable[newIndex] != null && hashTable[newIndex].equals(stringToBeDeleted)) {
                hashTable[newIndex] = null;
                System.out.println("\n" + "\"" + stringToBeDeleted + "\"" + " has been found in HashTable.");
                System.out.println("\"" + stringToBeDeleted + "\"" + " has been deleted from HashTable !");
                return;
            }
        }
        System.out.println("\nCould not find " + "\"" + stringToBeDeleted + "\"" + " in HashTable");
    }// end of method


}
