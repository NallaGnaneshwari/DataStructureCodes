package Hashing;

import java.util.LinkedList;

public class DirectChaining {
   //it uses an array of linked list --> commonly known as HashTable
    LinkedList<String>[] hashTable;
    int maxChainSize=5; //nodes in a linkedlist chain

    public DirectChaining(){
        hashTable = new LinkedList[13]; //initializing the array with 13 cells.
    }

    // Hash Function thats used in keys to produce a hash Value
    public int simpleASCIIHashFunction(String x, int modulo){
        char ch[];
        ch=x.toCharArray();
        int sum =0;
        for(int i=0;i<ch.length;i++){
            sum+= ch[i];
        }
        return sum % modulo;
    }


    // Insert key in HashTable
    public void insertKeyInHashTable(String value){
        int newIndex = simpleASCIIHashFunction(value, hashTable.length);
        if(hashTable[newIndex]==null){ // cell is empty
            System.out.println("Index: "+newIndex+" is empty, Creating a new LinkedList there....");
            hashTable[newIndex] = new LinkedList<String>();
            hashTable[newIndex].add(value);
            System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + newIndex);
            System.out.println("-------------------------------------------\n");
        }
        else{ // cell is already occupied with linked list, so directly insert node
            System.out.println("Index: "+newIndex+" is not empty, It is having sufficient space, so inserting there....");
            hashTable[newIndex].add(value);
            System.out.println("Successfully inserted " + "\"" + value + "\"" + " in location: " + newIndex);
            System.out.println("-------------------------------------------\n");
        }
    }


    //Search for a given key in Hash Table
    public boolean searchKeyInHashTable(String stringToBeSearched){
        int newIndex = simpleASCIIHashFunction(stringToBeSearched, hashTable.length);
        if(hashTable[newIndex]!=null && hashTable[newIndex].contains(stringToBeSearched)){
            System.out.println("\n"+"\""+stringToBeSearched+"\""+" found in the HashTable at location: "+newIndex);
            return true;
        }
        else{
            System.out.println("\n" + "\"" + stringToBeSearched + "\"" + " not found in HashTable.");
            return false;
        }
    }


    //Delete key from HashTable
    public void deleteKeyFromHashTable(String stringToBeDeleted){
        int newIndex = simpleASCIIHashFunction(stringToBeDeleted,hashTable.length);
        if(searchKeyInHashTable(stringToBeDeleted)==true){
            System.out.println("\n" + "\"" + stringToBeDeleted + "\"" + " has been found in HashTable." );
            hashTable[newIndex].remove(stringToBeDeleted);
            System.out.println("\"" + stringToBeDeleted + "\"" + " has been deleted from HashTable !" );
        }
        else{
            System.out.println("Could not find "+"\""+stringToBeDeleted+"\""+ " in the Hash Table");
        }
    }


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
