package Leetcode_5;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
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
            longest = searchSides(i, i+1, s, longest);
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
        //todo
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("a"));
        System.out.println(s.longestPalindrome("cbbd"));
        System.out.println(s.longestPalindrome("abcda"));
        System.out.println(s.longestPalindrome("aaabaaaa"));
    }
}