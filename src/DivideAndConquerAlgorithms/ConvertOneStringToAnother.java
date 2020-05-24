package DivideAndConquerAlgorithms;

public class ConvertOneStringToAnother {

    public int minOperationsRequired(String s1, String s2) {
        return minOperationsRequired(s1, s2, 0, 0);
    }

    public int minOperationsRequired(String s1, String s2, int i1, int i2) {
        if (i1 == s1.length()) {// we have reached the end of the string s1, so delete extras of s2
            return s2.length() - i2;  // these many delete operations
        }

        if (i2 == s2.length()) { // we have reached the end of the string s2, add all the remaining chars of s1
            return s1.length() - i1; //these many insertion operations
        }

        if (s1.charAt(i1) == s2.charAt(i2)) { //both the chars are same, we do nothing, just move to next character
            return minOperationsRequired(s1, s2, i1 + 1, i2 + 1);
        }

        int c1 = 1 + minOperationsRequired(s1, s2, i1 + 1, i2); // perform deletion operation
        int c2 = 1 + minOperationsRequired(s1, s2, i1, i2 + 1); // perform insertion operation
        int c3 = 1 + minOperationsRequired(s1, s2, i1 + 1, i2 + 1); //replacement opertaion
        return Math.min(c1, Math.min(c2, c3));
    } // end of method


    public static void main(String[] args) {
        ConvertOneStringToAnother c = new ConvertOneStringToAnother();
        System.out.println(c.minOperationsRequired("table", "tbres"));

    }//end main
}