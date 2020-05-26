package DivideAndConquerAlgorithms;

public class LongestPalindromicSubstring {

    public int findLPSLength(String s1){
        return findLPSLength(s1,0, s1.length()-1);
    }

    public int findLPSLength(String s1, int startIndex, int endIndex){
   if(startIndex>endIndex) //BASE CASE - If we have traversed more than 1/2 of string then return 0 as we dont need to process it
       return 0;

   if(startIndex==endIndex) // BASE CASE - there is only 1 character in the string
       return 1;

   int c1=0;
   if(s1.charAt(startIndex)==s1.charAt(endIndex)){ // when 2 chars matched
       int remainingLength = endIndex-startIndex-1;
       if(findLPSLength(s1,startIndex+1, endIndex-1)==remainingLength)  //add 2 to the existing known palindrome length only if remaining string is a palindrome too
          c1= remainingLength + 2;
   }

   int c2= 0 + findLPSLength(s1, startIndex+1, endIndex); // case 2: skip 1st char
   int c3 = 0 + findLPSLength(s1, startIndex, endIndex-1); //case 3: skip last char


   return Math.max(c1, Math.max(c2,c3));
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        System.out.println("Longest Palindromic Substring: " + lps.findLPSLength("ABCCBUA"));
    }// end of method
}
