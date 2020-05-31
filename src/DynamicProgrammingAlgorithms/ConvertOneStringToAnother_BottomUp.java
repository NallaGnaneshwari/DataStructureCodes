package DynamicProgrammingAlgorithms;



// s1 --> along y-axis (tbres) , s2--> along x-axis (table), assuming s2 as the main string
public class ConvertOneStringToAnother_BottomUp {

    public int findMinOperations(String s1, String s2){
        int[][]dp = new int[s1.length()+1][s2.length()+1];

        //Base cases:
            // When we have reached the end of s1, these many insert operations (all the remaining characters of s2)
            for(int i1=0;i1<=s1.length();i1++){
                dp[i1][0] = i1;  //dp[0][0], dp[1][0], dp[2][0], dp[3][0], dp[4][0], dp[5][0]
            }

            //when we have reached the end od s2, these many delete operations (all the remaining characters of s1)
            for(int i2=0;i2<=s2.length();i2++){
                dp[0][i2] = i2;
            }

        //Regular cases:
        for(int i1=1;i1<=s1.length();i1++){
            for(int i2=1;i2<=s2.length();i2++){
                if(s1.charAt(i1-1)==s2.charAt(i2-1)){ // if the strings are matching, recursively match for the remaining lenegths
                    dp[i1][i2]= dp[i1-1][i2-1];
                }
                else{
                    dp[i1][i2]= 1+ Math.min(dp[i1-1][i2], //delete
                            Math.min(dp[i1][i2-1],  //insert
                                    dp[i1-1][i2-1]));  //replace
                }
            }
        }
        return dp[s1.length()][s2.length()];  // Answer for the bigger solution
    }

    public static void main(String[] args) {
        ConvertOneStringToAnother_BottomUp cs = new ConvertOneStringToAnother_BottomUp();
        System.out.println(cs.findMinOperations("tbres","table"));
        System.out.println(cs.findMinOperations("table","tbres"));

    }



}
