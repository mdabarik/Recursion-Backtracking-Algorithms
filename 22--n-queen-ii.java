/* 22: N-Queens II
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

Example 1:
Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.

Example 2:
Input: n = 1
Output: 1 */

class Solution {
    public int totalNQueens(int n) {
        char board[][] = new char[n][n];
        for(char i[] : board)
            Arrays.fill(i, '.');
        return dfs(0, board);
    }
    public int dfs(int row, char board[][]){
        if(row == board.length)
            return 1;
        int count = 0;
        for(int col = 0; col < board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                count += dfs(row + 1, board);
                board[row][col] = '.';
            }
        }
        return count;
    }
    public boolean isSafe(char board[][], int row, int col){
        int dupRow = row;
        int dupCol = col;
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }
        row = dupRow;
        col = dupCol;
        while(row >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
        }
        row = dupRow;
        col = dupCol;
        while(row >= 0 && col < board.length){
            if(board[row][col] == 'Q') return false;
            row--;
            col++;
        }
        return true;
    }
}
