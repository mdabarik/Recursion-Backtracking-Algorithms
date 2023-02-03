/* 5: Subsets unique

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]] */

class Solution {
    public static void dfs(int[] nums, List<List<Integer>> list, List<Integer> sub, int start) {
        list.add(new ArrayList<>(sub));
        for (int i = start; i < nums.length; i++) {
            sub.add(nums[i]);
            dfs(nums, list, sub, i + 1);
            sub.remove(sub.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(nums, list, new ArrayList<>(), 0);
        return list;
    }
} // O(n * 2^n), O(n)
