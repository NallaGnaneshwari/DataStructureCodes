package DynamicProgrammingAlgorithms;

public class LongestPalindromicSubsequence_TopDown {

    public int findLPS(String s1){
        int[][]dp = new int[s1.length()][s1.length()];
        return findLPS(dp, s1, 0,s1.length()-1 );
    }

    //Algorithm
    public int findLPS(int[][]dp, String s1, int startIndex, int endIndex){
        //Base conditions:
        if(startIndex>endIndex){ //BASE CASE - If we have traversed more than 1/2 of string then return 0 as we dont need to process any further
            return 0;
        }

        if(startIndex==endIndex) //BASE CASE - If both the index are at same position then its a palindrome as its 1 character.
            return 1;


        if(dp[startIndex][endIndex]==0){//problem hasn't been solved yet
            int c1=0;
            if(s1.charAt(startIndex)==s1.charAt(endIndex)){ // both the characters are equal
                 c1= 2+ findLPS(dp,s1,startIndex+1, endIndex-1);

            }
            int c2= findLPS(dp,s1,startIndex+1, endIndex);//CASE#2 - Skip one element from beginning
            int c3= findLPS(dp,s1, startIndex, endIndex-1); //CASE#3 - Skip one element from end

            dp[startIndex][endIndex]= Math.max(c1, Math.max(c2,c3));//Take the max sized palindrome
        }
        return dp[startIndex][endIndex];
    }//end of Algorithm

    public static void main(String[] args) {
        LongestPalindromicSubsequence_TopDown lps = new LongestPalindromicSubsequence_TopDown();
        System.out.println("Longest Palindromic Sequence: " + lps.findLPS("elrmenmet")); //ememe
    }// end of method
}
