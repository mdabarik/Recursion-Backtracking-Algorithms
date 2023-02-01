/* 01: Permutations of a given string
Given a string S. The task is to print all unique permutations of the given string in lexicographically sorted order.

Example 1:
Input: ABC
Output: ABC ACB BAC BCA CAB CBA

Example 2:
Input: ABSG
Output:
ABGS ABSG AGBS AGSB ASBG ASGB BAGS 
BASG BGAS BGSA BSAG BSGA GABS GASB 
GBAS GBSA GSAB GSBA SABG SAGB SBAG 
SBGA SGAB SGBA
*/


class Solution {
    public static void dfs(String str, String perm, List<String> list) {
        if (str.length() == 0) {
            list.add(perm);
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!set.contains(ch)) {
                String tmp = str.substring(0, i) + str.substring(i + 1);
                dfs(tmp, perm + ch, list);
            }
            set.add(ch);
        }
    }
    public List<String> find_permutation(String S) {
        char[] arr = S.toCharArray();
        Arrays.sort(arr);
        String str = new String(arr);
        
        List<String> list = new ArrayList<>();
        dfs(str, "", list);
        return list;
    }
}
