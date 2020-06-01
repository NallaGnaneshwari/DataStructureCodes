package DynamicProgrammingAlgorithms;

public class LongestCommonSubsequence_BottomUp {

  public int findLCSLength(String s1, String s2){
      int[][] dp = new int[s1.length()+1][s2.length()+1];

      for(int i1=s1.length()-1;i1>=0;i1--){
          for(int i2=s2.length()-1;i2>=0;i2--){
              if(s1.charAt(i1)==s2.charAt(i2)){
                  //dp[i1][i2]= 1+ dp[i1+1][i2+1];
                  dp[i1][i2] =  Math.max((1 + dp[i1+1][i2+1]), Math.max(dp[i1][i2+1], dp[i1+1][i2]));

              }
              else{
                  dp[i1][i2]= Math.max(dp[i1][i2+1], dp[i1+1][i2]);
              }
          }
      }

      return dp[0][0];
  }

    public static void main(String[] args) {
        LongestCommonSubsequence_BottomUp lcs = new LongestCommonSubsequence_BottomUp();
        System.out.println(lcs.findLCSLength("hdupti", "houdini"));
    }//end of method

}
