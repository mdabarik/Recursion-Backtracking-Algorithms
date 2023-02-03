/* 18: Matchsticks to Square
You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.

Example 1:
Input: matchsticks = [1,1,2,2,2]
Output: true
Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.

Example 2:
Input: matchsticks = [3,3,3,3,4]
Output: false
Explanation: You cannot find a way to form a square with all the matchsticks. */

class Solution {
    public boolean dfs(int[] nums, boolean[] visited, int k, int targetSum, int currSum, int index) {
        if (k == 0) return true;
        if (targetSum == currSum) 
            return dfs(nums, visited, k - 1, targetSum, 0, nums.length - 1);
        for (int i = index; i >= 0; i--) {
            if (visited[i]) continue;
            if (i + 1 < nums.length && nums[i] == nums[i + 1] && !visited[i + 1]) continue;
            if (currSum + nums[i] > targetSum) continue;
            visited[i] = true;
            if (dfs(nums, visited, k, targetSum, currSum + nums[i], i - 1)) return true;
            visited[i] = false;
        }
        return false;
    }
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) return false;
        int sum = 0;
        for (int num : matchsticks) {
            sum += num;
        }
        if (sum % 4 != 0) return false;
        int targetSum = sum / 4;
        return dfs(matchsticks, new boolean[matchsticks.length], 4, targetSum, 0, matchsticks.length - 1);
    }
}
