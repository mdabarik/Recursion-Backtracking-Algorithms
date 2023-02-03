/* 21. N-Queens
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:
Input: n = 1
Output: [["Q"]] */

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(char i[] : board)
            Arrays.fill(i, '.');
        List<List<String>> res = new ArrayList<>();
        dfs(0, board, res);
        return res;
    }
    
    public void dfs(int row, char board[][], List<List<String>> res){
        if(row == board.length){
            res.add(counter(board));
            return;
        }
        
        for(int col = 0; col < board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                dfs(row + 1, board, res);
                board[row][col] = '.';
            }
        }
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
    public List<String> counter(char board[][]){
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
