package DynamicProgrammingAlgorithms;

public class HouseThief_BottomUp {


    public int maxSteal(int[] housesWorth){

        //create an array to store the subproblem results
        int[] dp = new int[housesWorth.length+2];  // 2 extra indexes for the last subproblem

        //Base condition:
        dp[housesWorth.length]=0;

        for(int i=housesWorth.length-1;i>=0;i--){
            dp[i]= Math.max(housesWorth[i]+dp[i+2], 0+dp[i+1]);
        }
        return dp[0]; // we will finally return the result of bigger problem after the continuous for loop on smaller problems
    }


    public static void main(String[] args) {
        HouseThief_BottomUp ht = new HouseThief_BottomUp();
        int[] housesWorth = { 6, 7, 1, 30, 8, 2, 4 };
        System.out.println(ht.maxSteal(housesWorth));
        housesWorth= new int[]{20, 5, 1, 13, 6, 11, 40};
        System.out.println(ht.maxSteal(housesWorth));
    }


    //Let's assume we have 10 houses H1 to H10  stored in housesWorth[0] to houseWorth[9].
    // When we create a dynamic programming dp[] array, we create it with new int[housesWorth.length+2] = new int[12], so that we have 2 extra cells for the last house.
    // dp[] will be indexed from dp[0] to dp[11] with H1 in dp[0] and H10 in dp[9]. And 2 extra cells dp[10], dp[11]
    // Base case: we initialise the last 2nd cell of the array as '0', i.e., dp[10]=0.
    // dp[housesWorth.length]= dp[10] = 0

}
