package DivideAndConquerAlgorithms;

public class FibonacciSeries {

    public static int calculateFibonacci(int n){
        if(n<1){
            System.out.println("Please enter a positive number");
            return Integer.MIN_VALUE;
        }
        else if (n==1 || n==2){
            return n-1;
        }
        else
            return calculateFibonacci(n-1)+calculateFibonacci(n-2);
    }//end of recursive method


    public static void main(String[] args) {
        System.out.println("10th fibonacci element is:" + FibonacciSeries.calculateFibonacci(10));
        System.out.println("5th fibonacci element is:" + FibonacciSeries.calculateFibonacci(5));
    }
}
