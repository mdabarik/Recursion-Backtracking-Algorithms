/* 15: Maximum Length of a Concatenated String with Unique Characters
You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

Example 1:
Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All the valid concatenations are:
- ""
- "un"
- "iq"
- "ue"
- "uniq" ("un" + "iq")
- "ique" ("iq" + "ue")
Maximum length is 4.

Example 2:
Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").

Example 3:
Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26
Explanation: The only string in arr has all 26 characters. */

class Solution {
    public boolean isUnique(String str) {
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 1) return false;
        }
        return true;
    }
    public int dfs(List<String> arr, String str, int curr) {
        if (curr == arr.size()) {
            return str.length();
        }
        int left = 0, right = 0;
        String tmp = str + arr.get(curr);
        if (isUnique(tmp)) {
            left = dfs(arr, tmp, curr + 1);
        }
        right = dfs(arr, str, curr + 1);
        return Math.max(left, right);
    }
    public int maxLength(List<String> arr) {
        return dfs(arr, "", 0);
    }
} // TC: O(n * 2^n), SC: O(n)
