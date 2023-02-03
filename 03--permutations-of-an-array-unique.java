/* 3: Permutations of an array
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]] */

class Solution {
    public static void dfs(int[] nums, List<List<Integer>> list, List<Integer> perm) {
        if (perm.size() == nums.length) {
            list.add(new ArrayList<>(perm));
        }
        for (int i = 0; i < nums.length; i++) {
            if (perm.contains(nums[i])) continue;
            perm.add(nums[i]);
            dfs(nums, list, perm);
            perm.remove(perm.size() - 1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        dfs(nums, list, new ArrayList<>());
        return list;
    }
} // TC: O(n * log n) + O(n * n!), SC: O(n)
