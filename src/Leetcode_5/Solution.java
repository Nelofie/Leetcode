package Leetcode_5;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 *
 * @author Nelofie
 */


class Solution {
    /**
     * 我的思路
     * 1、遍历每一位，同时向两边搜索找最长的回文
     * 2、发现需要考虑第一次搜索时是一位还是两位字符的问题
     */
    public String longestPalindrome(String s) {
        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            longest = searchSides(i, i, s, longest);
            longest = searchSides(i, i + 1, s, longest);
        }
        return longest;
    }

    private String searchSides(int start, int end, String s, String longest) {
        int left = start;
        int right = end;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > longest.length()) {
                    longest = s.substring(left, right + 1);
                }
            } else {
                break;
            }
            left--;
            right++;
        }
        return longest;
    }

    /**
     * manacher算法
     * https://segmentfault.com/a/1190000003914228
     */
    public String manacher(String s) {
        String sNew = s.replace("", "#");
        int[] rl = new int[sNew.length()];
        int resL = 0;
        int resR = 0;

        int maxRight = 0;
        int pos = 0;
        for (int i = 0; i < sNew.length(); i++) {
            if (i < maxRight) {
                rl[i] = min(rl[2 * pos - i], maxRight - i);
            } else {
                rl[i] = 1;
            }
            while (i - rl[i] >= 0 && i + rl[i] < sNew.length() && sNew.charAt(i - rl[i]) == sNew.charAt(i + rl[i])) {
                rl[i]++;
            }
            if (i + rl[i] - 1 > maxRight) {
                maxRight = i + rl[i] - 1;
                pos = i;
            }
            if (resR - resL + 1 < (maxRight - pos) * 2 + 1) {
                resL = 2 * pos - maxRight;
                resR = maxRight;
            }
        }
        return sNew.substring(resL, resR).replace("#", "");
    }

    private int min(int a ,int b) {
        return a > b ? b : a;
    }


    /**
     * 动态规划
     */
    public int dynamicDivide(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        //pal[i][j] 表示s[i...j]是否是回文串
        int maxLen = 0;
        for (int i = 0; i < n; i++) {  // i作为终点
            int j = i;    //j作为起点
            while (j >= 0) {
                if (s.charAt(j) == s.charAt(i) && (i - j < 2 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    maxLen = Math.max(maxLen, i - j + 1);
                }
                j--;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.manacher("abbahopxpo"));
        System.out.println(s.manacher("cbbd"));
        System.out.println(s.manacher("abcda"));
        System.out.println(s.manacher("aaabaaaa"));
    }
}