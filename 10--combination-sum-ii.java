/* 10: Combination Sum II
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
] */

class Solution {
    public static void dfs(int[] nums, List<List<Integer>> list, List<Integer> comb, int targetSum, int currSum, int start) {
        if (currSum == targetSum) {
            list.add(new ArrayList<>(comb));
            return;
        } else if (currSum > targetSum) return;
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            comb.add(nums[i]);
            dfs(nums, list, comb, targetSum, currSum + nums[i], i + 1);
            comb.remove(comb.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, list, new ArrayList<>(), target, 0, 0);
        return list;
    }
}
