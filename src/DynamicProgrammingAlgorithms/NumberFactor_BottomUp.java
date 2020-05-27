package DynamicProgrammingAlgorithms;

public class NumberFactor_BottomUp {

    public int waysToGetN(int n){
        int[] dp = new int[n+1]; //since from 0 to n (0 to 10 will need 11 cells)
        dp[0]=dp[1]=dp[2]=1; //Basecase since we keep moving from left to right
        dp[3]= 2; // Basecase

        for(int i=4;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-3]+dp[i-4];  //storing value into array after solving the subproblem
        }

        return dp[n]; // returning value from the array
    }

    public static void main(String[] args) {
        NumberFactor_BottomUp nf = new NumberFactor_BottomUp();
        System.out.println( "Ways to get 4: "+ nf.waysToGetN(4));
        System.out.println( "Ways to get 5: "+ nf.waysToGetN(5));
        System.out.println( "Ways to get 6: "+ nf.waysToGetN(6));
    }
}
