package DivideAndConquerAlgorithms;

public class NumberFactor {

    public static int waysToGetN(int n){
        if(n==0 || n==1 || n==2){ //{},{1},{1,1}
            return 1;
        }
        else if(n==3) // {1,1,1}, {3}
            return 2;
        else {
            int subtract1 = waysToGetN(n - 1);
            int subtract3 = waysToGetN(n - 3);
            int subtract4 = waysToGetN(n - 4);
            return subtract1 + subtract3 + subtract4;
        }
    }

    public static void main(String[] args) {
        System.out.println("Ways to find 4: "+ NumberFactor.waysToGetN(4));
        System.out.println("Ways to find 5: "+ NumberFactor.waysToGetN(5));
        System.out.println("Ways to find 6: "+ NumberFactor.waysToGetN(6));
        System.out.println("Ways to find 7: "+ NumberFactor.waysToGetN(7));
        System.out.println("Ways to find 8: "+ NumberFactor.waysToGetN(8));
        System.out.println("Ways to find 9: "+ NumberFactor.waysToGetN(9));
    }
}
