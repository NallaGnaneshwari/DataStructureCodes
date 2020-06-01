package DynamicProgrammingAlgorithms;

public class LongestPalindromicSubstring_TopDown {

    public int findLPS(String s1){
        Integer[][]dp = new Integer[s1.length()][s1.length()];
        return findLPS(dp,s1,0,s1.length()-1);
    }

    //Algorithm
    public int findLPS(Integer[][]dp, String s1, int startIndex, int endIndex){

    if(startIndex>endIndex){ //Base case - if we have traverses half of the string, we don't need to traverse any further
        return 0;
    }

    if(startIndex==endIndex){ //Base case - If both the index are at same position then its a palindrome as its 1 character.
        return 1;
    }

        if(dp[startIndex][endIndex]==null){//problem not yet solved

            int c1=0;
            if(s1.charAt(startIndex)==s1.charAt(endIndex)) {  // Case#1: when both chars match
                int remainingLength = endIndex - startIndex - 1;
                if (remainingLength == findLPS(dp, s1, startIndex + 1, endIndex - 1)) {
                    c1 = 2 + remainingLength;  //add 2 to the existing known palindrome length only if the remaining string is a palindrome too.

                }
            }
            int c2= findLPS(dp,s1,startIndex+1, endIndex); //Case#2: ignoring character from start
            int c3= findLPS(dp,s1,startIndex, endIndex-1); //Case#3: ignoring character from end
            dp[startIndex][endIndex]=Math.max(c1, Math.max(c2,c3)); // Take the max sized palindromic substring
        }

        return dp[startIndex][endIndex];



    }//end of algorithm

    public static void main(String[] args) {
        LongestPalindromicSubstring_TopDown lps = new LongestPalindromicSubstring_TopDown();
        System.out.println("Longest Palindromic Substring: " + lps.findLPS("elrmenmet"));
    }// end of method
}
