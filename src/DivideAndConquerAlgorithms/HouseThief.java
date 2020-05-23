package DivideAndConquerAlgorithms;

public class HouseThief {

    public int maxMoney(int[] HouseNetWorth){
        return maxMoney(HouseNetWorth, 0);
    }

    public int maxMoney(int[] HouseNetWorth, int currentIndex){

        if(currentIndex>=HouseNetWorth.length){
            return 0;
        }

        int stealCurrentHouse = HouseNetWorth[currentIndex]+maxMoney(HouseNetWorth,currentIndex+2);  //picking current house
        int skipCurrentHouse = 0 + maxMoney(HouseNetWorth,currentIndex+1); //skipping current house
        return Math.max(stealCurrentHouse,skipCurrentHouse);
    }//end of recursive method

    public static void main(String[] args) {
        HouseThief ht = new HouseThief();
        int[] houseNetWorth = {6,7,1,30,8,2,4};
        System.out.println(ht.maxMoney(houseNetWorth));
        houseNetWorth = new int[]{20, 5, 1, 13, 6, 11, 40};
        System.out.println(ht.maxMoney(houseNetWorth));
    }

}
