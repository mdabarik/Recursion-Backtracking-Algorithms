/* 20: M coloring problem
Given an undirected graph and an integer M. The task is to determine if the graph can be colored with at most M colors such that no two adjacent 
vertices of the graph are colored with the same color. Here coloring of a graph means the assignment of colors to all vertices. 
Print 1 if it is possible to colour vertices and 0 otherwise.

Example 1:
Input:
N = 4
M = 3
E = 5
Edges[] = {(0,1),(1,2),(2,3),(3,0),(0,2)}
Output: 1
Explanation: It is possible to colour the
given graph using 3 colours.

Example 2:
Input:
N = 3
M = 2
E = 3
Edges[] = {(0,1),(1,2),(0,2)}
Output: 0 */

class solve {
    public boolean isSafe(boolean[][] graph, int[] color, int currColor, int r) {
        for (int c = 0; c < graph[0].length; c++) {
            if (graph[r][c] == true) {
                if (color[c] == currColor) return false;
            }
        }
        return true;
    }
    public boolean dfs(boolean[][] graph, int[] color, int m, int r) {
        if (r == graph.length) return true;
        for (int i = 1; i <= m; i++) {
            if (isSafe(graph, color, i, r)) {
                color[r] = i;
                if (dfs(graph, color, m, r + 1)) return true;
                color[r] = 0;
            }
        }
        return false;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] color = new int[n];
        return dfs(graph, color, m, 0);
    }
} // TC: O(n * m^n), SC: O(n)
