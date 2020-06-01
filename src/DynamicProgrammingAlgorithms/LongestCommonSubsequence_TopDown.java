package DynamicProgrammingAlgorithms;

public class LongestCommonSubsequence_TopDown {
    public int findLCSLength(String s1, String s2){
       int[][]dp = new int[s1.length()+1][s2.length()+1];
       return findLCSLength(dp,s1, s2, 0,0);
    }

    //Algorithm
    public int findLCSLength(int[][]dp, String s1,String s2, int i1, int i2){

        //Base case
        if(i1==s1.length() || i2==s2.length())
            return 0;

        if(dp[i1][i2]==0) { // problem not yet solved
            if (s1.charAt(i1) == s2.charAt(i2)) //both characters are equal
                dp[i1][i2] = 1 + findLCSLength(dp, s1, s2, i1 + 1, i2 + 1);//If current character in both the string matches,
                // then increase the index by 1 in both the strings.

            else {
                int c1 = findLCSLength(dp, s1, s2, i1 + 1, i2); //Increase index of 2nd String
              int c2 = findLCSLength(dp,s1,s2,i1,i2+1);//Increase index of 1st String
              dp[i1][i2]= Math.max(c1,c2);

            }

        }
        return dp[i1][i2];
    }
    public static void main(String[] args) {
        LongestCommonSubsequence_TopDown lcs = new LongestCommonSubsequence_TopDown();
        System.out.println(lcs.findLCSLength("houdini", "hdupti"));

    }//end of method
}
