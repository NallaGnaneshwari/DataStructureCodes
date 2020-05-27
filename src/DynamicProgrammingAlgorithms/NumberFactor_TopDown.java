package DynamicProgrammingAlgorithms;

public class NumberFactor_TopDown {

    public int waysToGetN(int n){
        int[] dp = new int[n+1];  //since from 0 to n (0 to 10 will need 11 cells)
        return waysToGetN( dp, n);
    }

    // Algorithm
    public int waysToGetN(int[] dp, int n){

        if(n==0|| n==1|| n==2){ //{},{1},{1,1}
            return 1;
        }

        if(n==3) //{1,1,1},{3}
            return 2;


        if(dp[n]==0){  // go to recursion only if the problem is not yet solved
            int subtract1 = waysToGetN(dp, n - 1); // if we subtract 1, we will be left with 'n-1'
            int subtract3 = waysToGetN(dp, n - 3); // if we subtract 3, we will be left with 'n-3'
            int subtract4 = waysToGetN(dp, n - 4);// if we subtract 4, we will be left with 'n-4'

            dp[n] = subtract1 + subtract3 + subtract4; //instead of returning we store it in array
        }
        return dp[n];  //returning value from array
    }//end of Algorithm


    public static void main(String[] args) {
        NumberFactor_TopDown nf = new NumberFactor_TopDown();
        System.out.println("Ways to get 4: "+nf.waysToGetN(4));
        System.out.println("Ways to get 5: "+nf.waysToGetN(5));
        System.out.println("Ways to get 6: "+nf.waysToGetN(6));

    }
}
