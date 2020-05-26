package com.shijing.nopainnogain.algorithm.dy;

/**
 * @description:
 * @author: shijing
 * @create: 2020-05-25 21:37
 **/
public class IsSubsequence {

    public static void main(String[] args) {
        IsSubsequence i = new IsSubsequence();
        String s = "abc", t = "ahbgdc";
        System.out.println(i.isSubsequence(s, t));

        s = "axc";
        t = "ahbgdc";
        System.out.println(i.isSubsequence(s, t));

    }

    boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int m = s.length() - 1;
        int n = t.length() - 1;

        while (i <= m && j <= n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
            if (s.charAt(m) == t.charAt(n)) {
                m--;
                n--;
            } else {
                n--;
            }
        }

        return i == m + 1;
    }
}
