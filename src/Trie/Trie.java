package Trie;
//import Node.TrieNode;


import java.util.HashMap;
import java.util.Map;

public class Trie {

  private  class TrieNode {
        Map<Character, TrieNode> children ;
        boolean endOfWord ;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord=false;
        }
  }

  private TrieNode root;

  public Trie(){
        this.root= new TrieNode();

    }

  public void insert(String word){

        //eg:air
        TrieNode currentNode = root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i); // a
            TrieNode node = currentNode.children.get(ch);
            if(node==null){
                node=new TrieNode(); // if does not exists, create a new one
                currentNode.children.put(ch,node);
            }
            currentNode=node;
        }
        currentNode.endOfWord=true;
      System.out.println("Sucessfully inserted "+ word+" in the Trie!");
  }

  public boolean search(String word){
      TrieNode currentNode = root;
      for(int i=0;i<word.length();i++){
          char ch=word.charAt(i);
          TrieNode node=currentNode.children.get(ch);
          if(node==null){ //#Case1 --> if the word does not exists in the Trie!
              System.out.println("Word: "+word+" does not exists in the Trie!");
              return false;
          }
          currentNode=node;  // assigning new node that's been fetched from the map, to the currentNode variable
      }

      if(currentNode.endOfWord==true){ //Case#2 --> when the word exists as a complete String
          System.out.println("Word: "+word+" exists in the Trie!");
          //return true;
      }
      else{//Case#3 --> when the word does not exists as a complete String, ie it exists partially as a prefix
          System.out.println("Word: "+word+" does not exists in the Trie!");
          //return false;
      }
      return currentNode.endOfWord;
  }

  public void deleteTrie(){
      System.out.println("Deleting the Trie....!");
      root=null;
      System.out.println("Successfully deleted the Trie!");
  }

  public void delete(String word){
      if(search(word)==true){
          delete(root, word,0);   // delete(root, BCDE, 0);
      }
  }

  public boolean delete(TrieNode parentNode, String word, int index){

      // Case#1 --> common prefix, ie some other words prefix is same as prefix of this word (BCDE,BCKG)
      // Case#2 --> complete prefix, we are at the last character of this word and This word is a prefix of some other word (BCDE, BCDEF)
      // Case#3 --> complete prefix, some other word is a prefix of this word (BCDE, BC)
      // Case#4 --> No one is dependant on this word (BCDE,BCDE)
       // Note: Deletion from Trie always start at the leaf

      char ch= word.charAt(index);
      TrieNode currentNode = parentNode.children.get(ch);

      boolean canThisNodeBeDeleted;

      if(currentNode.children.size()>1){ // that means this node has more than 1 items in the Map
          System.out.println("Entering Case#1");
          delete(currentNode, word, index+1);  //Case#1, recursive call of deletion (Because, Deletion from Trie always start at the leaf)
            return false;
      }

      // In case#2, we delete from the last
      if(index==word.length()-1){  //#Case2 , BCDE - mein last position ie say we are at E now
          System.out.println("Entering Case#2");
          if(currentNode.children.size()>=1){
              currentNode.endOfWord=false;
              return false;
          }
          else{
              System.out.println("Character "+ch+ " has no dependency, hence deleting it from last");
              parentNode.children.remove(ch);
              return true; // if this word is not a prefix of some other word, and since this is the last character,
                            // we should return true, indicating we are ok to delete this node.
          }
      }

      if(currentNode.endOfWord==true){
          System.out.println("Entering case#3");
          delete(currentNode,word,index+1);
          return false;
      }


      System.out.println("Entering Case#4");
      canThisNodeBeDeleted=delete(currentNode,word,index+1);
      if(canThisNodeBeDeleted==true){
          System.out.println("Character "+ch+" has no dependency, hence deleting it");
          parentNode.children.remove(ch);
          return true; //current node can also be deleted
      }
      else{
          return false;// Someone is dependent on this node, hence dont delete it

      }

  }
}
