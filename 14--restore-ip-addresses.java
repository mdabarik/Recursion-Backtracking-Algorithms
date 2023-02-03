/* 14: Restore IP Addresses
A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

Example 1:
Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]

Example 2:
Input: s = "0000"
Output: ["0.0.0.0"]

Example 3:
Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"] */

class Solution {
    public boolean isValid(String str) {
        if (
            str.isEmpty() ||
            str.length() > 3 ||
            (str.charAt(0) == '0' && str.length() > 1) ||
            Integer.parseInt(str) > 255
        ) {
            return false;
        }
        return true;
    }
    public void dfs(List<String> list, String str, String path, int seg, int start) {
        if (seg == 4) {
            if (start == str.length()) {
                list.add(path.substring(0, path.length() - 1));
            }
            return;
        }
        for (int i = start; i < str.length() && i < start + 3; i++) {
            String curr = str.substring(start, i + 1);
            if (isValid(curr)) {
                dfs(list, str, path + curr + ".", seg + 1, i + 1);
            }
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return list;
        dfs(list, s, "", 0, 0);
        return list;
    }
} // TC: O(3^4) == O(1),, SC: O(4) == O(1)
