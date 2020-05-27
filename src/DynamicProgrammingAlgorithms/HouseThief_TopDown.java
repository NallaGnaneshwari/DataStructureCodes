package DynamicProgrammingAlgorithms;

public class HouseThief_TopDown {
    public int findMaxMoney(int[] houseWorth){
        int[] dp = new int[houseWorth.length];
        return findMaxMoney(dp,houseWorth, 0);
    }

    public int findMaxMoney(int[] dp, int[] houseWorth,int currentIndex){
        if(currentIndex>= houseWorth.length) // Base condition - reached end of the houses
            return 0;

        if(dp[currentIndex]==0) { // if subproblem not yet solved, enter into recursion and store in the array
            int stealCurrent = houseWorth[currentIndex] + findMaxMoney(dp, houseWorth, currentIndex + 2);
            int skipCurrent = 0 + findMaxMoney(dp, houseWorth, currentIndex + 1);
            dp[currentIndex]= Math.max(stealCurrent, skipCurrent);
        }
        return dp[currentIndex];
    }

    public static void main(String[] args) {
        HouseThief_TopDown ht = new HouseThief_TopDown();
        int[] houseWorth = {6, 7, 1, 30, 8, 2, 4};
        System.out.println( ht.findMaxMoney(houseWorth));
        houseWorth= new int[]{20, 5, 1, 13, 6, 11, 40};
        System.out.println( ht.findMaxMoney(houseWorth));

    }
}
