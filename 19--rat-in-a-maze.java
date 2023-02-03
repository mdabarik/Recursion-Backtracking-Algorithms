/* 19: Rate in a maze
Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell.

Example 1:
Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at 
(3, 3) from (0, 0) by two paths - DRDDRR 
and DDRDRR, when printed in sorted order 
we get DDRDRR DRDDRR.

Example 2:
Input:
N = 2
m[][] = {{1, 0},
         {1, 0}}
Output:
-1
Explanation:
No path exists and destination cell is 
blocked. */



class Solution {
    public static void dfs(int[][] matrix, boolean[][] visited, ArrayList<String> res, int n, int r, int c, String currPath) {
        if (r < 0 || r >= n || c < 0 || c >= n || matrix[r][c] == 0 || visited[r][c]) return;
        if (r == n - 1 && c == n - 1) {
            res.add(currPath);
            return;
        }
        visited[r][c] = true;
        // down, up, right, left
        dfs(matrix, visited, res, n, r + 1, c, currPath + "D");
        dfs(matrix, visited, res, n, r - 1, c, currPath + "U");
        dfs(matrix, visited, res, n, r, c + 1, currPath + "R");
        dfs(matrix, visited, res, n, r, c - 1, currPath + "L");
        visited[r][c] = false;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        boolean[][] visited = new boolean[n][n];
        ArrayList<String> res = new ArrayList<>();
        dfs(m, visited, res, n, 0, 0, "");
        return res;
    } 
} // TC: O(4 ^ (n*n)), SC: O(n * n)
