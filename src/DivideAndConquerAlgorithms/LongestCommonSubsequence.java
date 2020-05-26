package DivideAndConquerAlgorithms;

public class LongestCommonSubsequence {

    public int findLCSLength(String s1,String s2 ){
        return findLCSLength(s1,s2,0,0);
    }

    public int findLCSLength(String s1, String s2, int i1, int i2){

        if (i1 == s1.length() || i2 == s2.length()){//Base Case
            return 0;
        }

        int c1=0;
        if(s1.charAt(i1)==s2.charAt(i2)){ //If current character in both the string matches, then increase the index by 1 in both the strings.
             c1=1+ findLCSLength(s1,s2,i1+1, i2+1);
        }

        int c2 = 0+findLCSLength(s1,s2,i1+1,i2); //Increase index of 1st String
        int c3=0+findLCSLength(s1,s2,i1,i2+1);//Increase index of 2nd String

        return Math.max(c1, Math.max(c2,c3));
    } // end of the string

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(" Length of common subsequence: "+lcs.findLCSLength("houdini", "hdupti"));
    } //end of main
}
