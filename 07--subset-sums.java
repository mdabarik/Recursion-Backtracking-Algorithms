/* 7: Subset sums
Given a list arr of N integers, print sums of all subsets in it.

Example 1:
Input:
N = 2
arr[] = {2, 3}
Output:
0 2 3 5
Explanation:
When no elements is taken then Sum = 0.
When only 2 is taken then Sum = 2.
When only 3 is taken then Sum = 3.
When element 2 and 3 are taken then 
Sum = 2+3 = 5.

Example 2:
Input:
N = 3
arr = {5, 2, 1}
Output:
0 1 2 3 5 6 7 8 
*/

class Solution {
    public static void dfs(ArrayList<Integer> arr, ArrayList<Integer> list, int sum, int index) {
        if (index == arr.size()) {
            list.add(sum);
            return;
        }
        dfs(arr, list, sum + arr.get(index), index + 1);
        dfs(arr, list, sum, index + 1);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> list = new ArrayList<>();
        dfs(arr, list, 0, 0);
        return list;
    }
} // TC: O(2^n), SC: O(n) + O(2^n)
