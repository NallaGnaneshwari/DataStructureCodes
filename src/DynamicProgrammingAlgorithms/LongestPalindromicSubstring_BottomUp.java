package DynamicProgrammingAlgorithms;

public class LongestPalindromicSubstring_BottomUp {

    public int findLPSLength(String s1){
        Integer[][]dp = new Integer[s1.length()][s1.length()];

        //let's do the filling columnwise (start from last row to 1st)
        for(int col=0;col<s1.length();col++){
            for(int row=s1.length()-1;row>=0;row--){

                if(row>col){ //Base case: if we have traversed more than half of the string we don't need to traverse any further, since there is a pointer from end as well, Lower triangular matrix
                    dp[row][col]=0;
                }

               else if(row==col){ // BASE CASE - If both the index are at same position then its a palindrome as its 1 character.
                    dp[row][col]=1;
                }

               else{
                    if(s1.charAt(row)==s1.charAt(col)){//when both chars match
                        int remainingLength = col-row-1;
                        int stringLengthToBeUsed = (dp[row+1][col-1]==remainingLength? dp[row+1][col-1]+2:0);

                            dp[row][col]= Math.max(stringLengthToBeUsed, Math.max(dp[row][col-1], dp[row+1][col]));
                        }
                        else //when chars don't match
                            {
                            dp[row][col]= Math.max(0,Math.max(dp[row+1][col], dp[row][col-1]));
                            }
               }
            }
        }
        return dp[0][s1.length()-1]; //returning the bigger solution which is at 1st row last column
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring_BottomUp lps = new LongestPalindromicSubstring_BottomUp();
        System.out.println("Longest Palindromic Substring: " + lps.findLPSLength("elrmenmet"));
    }// end of method
}
