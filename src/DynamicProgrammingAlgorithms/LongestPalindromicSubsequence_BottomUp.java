package DynamicProgrammingAlgorithms;

public class LongestPalindromicSubsequence_BottomUp {

public int findLPS(String s1){
    int[][] dp = new int[s1.length()][s1.length()];
    for(int col=0;col<s1.length();col++){
        for(int row=s1.length()-1; row>=0;row--){
            if(row==col)
                dp[row][col]=1;
            else if(row>col)
                dp[row][col]=0;
            else{ // case where row<col, i.e., the upper triangular matrix
                if(s1.charAt(row)==s1.charAt(col)){
                    dp[row][col]= Math.max(2+dp[row+1][col-1], Math.max(dp[row+1][col], dp[row][col+1]));
                }
                else{ //when 2 chars don't match
                    dp[row][col]=Math.max(0, Math.max(dp[row][col-1], dp[row+1][col]));
                }

            }
        }
    }
    return dp[0][s1.length()-1]; //the final solution is at 1st row last column

}
    public static void main(String[] args) {
        LongestPalindromicSubsequence_BottomUp lps = new LongestPalindromicSubsequence_BottomUp();
        System.out.println("Longest Palindromic Substring: " + lps.findLPS("elrmenmet")); //ememe
    }// end of method
}
