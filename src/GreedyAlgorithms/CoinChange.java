package GreedyAlgorithms;

import java.util.Arrays;

public class CoinChange {

public static void coinChangeProblem(int[] coins, int N){

    Arrays.sort(coins); // sorts the coins in ascending order
    int index = coins.length-1;
    while(true){
        int coinValue = coins[index];
        index--;
        int maxAmount = (N/coinValue)*coinValue;
        if(maxAmount>0){
            System.out.println("Coin value: "+coinValue+" taken count: "+(N/coinValue));
            N = N-maxAmount;
        }

        if(N==0){
            break;
        }
    }


}

}
