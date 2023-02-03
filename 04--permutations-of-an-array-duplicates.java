/* 4: Permutations II
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]] */

class Solution {
    public static void dfs(List<List<Integer>> list, HashMap<Integer, Integer> map, List<Integer> perm, int n) {
        if (perm.size() == n) {
            list.add(new ArrayList<>(perm));
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > 0) {
                perm.add(key);
                map.put(key, map.get(key) - 1);
                dfs(list, map, perm, n);
                perm.remove(perm.size() - 1);
                map.put(key, map.get(key) + 1);
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        dfs(list, map, new ArrayList<>(), nums.length);
        return list;
    }
} // TC : O(n * n!), SC: O(n)
