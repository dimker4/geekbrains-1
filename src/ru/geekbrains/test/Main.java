/*
Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.

        Notes:

        Only lower case letters will be used (a-z). No punctuation or digits will be included.
        Performance needs to be considered
        Input strings s1 and s2 are null terminated.
        Examples
        scramble('rkqodlw', 'world') ==> True
        scramble('cedewaraaossoqqyt', 'codewars') ==> True
        scramble('katas', 'steak') ==> False

        https://www.codewars.com/kata/55c04b4cc56a697bb0000048/train/java
*/

package ru.geekbrains.test;
import java.util.ArrayList;

public class Main {
    public static void main(String args1[]) {

        String s1 = "scriptjavx";
        String s2 = "javascript";

        System.out.println(scramble(s1,s2));

    }

    public static boolean scramble(String str1, String str2) {
        int count = 0;
        ArrayList<Integer> list = new ArrayList<Integer>(str1.length());

        for (int i = 0; i < str2.length(); i ++) {
            for (int j = 0; j < str1.length(); j ++) {
                if (str2.charAt(i) == str1.charAt(j) && !list.contains(j)) {
                    count ++;
                    list.add(j);
                    break;
                }
            }
        }

        if (count == str2.length()) return true;

        return false;
    }

}
