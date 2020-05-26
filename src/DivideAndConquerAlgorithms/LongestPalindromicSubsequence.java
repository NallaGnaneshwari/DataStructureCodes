package DivideAndConquerAlgorithms;

public class LongestPalindromicSubsequence {

    public int findLPSLength(String s1){
        return findLPSLength(s1, 0, s1.length()-1);
    }

    //Algorithm
    public int findLPSLength(String s1, int startIndex, int endIndex){

       if(startIndex>endIndex) //when comparison till the 1st half elements of the string is done.
           return 0;

       if(startIndex==endIndex) // only 1 element in the string
           return 1;


        int c1=0;
        if(s1.charAt(startIndex) == s1.charAt(endIndex)){//when both chars are equal
            c1= 2+findLPSLength(s1,startIndex+1, endIndex-1);
        }

        int c2= 0 + findLPSLength(s1,startIndex+1, endIndex); // skipping 1st char
        int c3= 0 + findLPSLength(s1,startIndex, endIndex-1); // skipping last char

        return Math.max(c1,Math.max(c2,c3));
    } // end of algorithm

    public static void main(String[] args) {
        LongestPalindromicSubsequence lps= new LongestPalindromicSubsequence();
        System.out.println("Longest Palindromic sequence: "+lps.findLPSLength("elrmenmet"));
    }


}

