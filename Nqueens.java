import java.util.*;
public class Nqueens { // Time Complexity is O(n^n);
    public static boolean isSafe(int row, int col,char[][] board) {
        // horizontal
        for(int j=0; j<board.length; j++) {
            if(board[row][j] == 'Q') {
                return false;
            }
        }

        // vertical
        for(int i=0; i<board.length; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        //upper left
        int r = row;
        for(int c = col; c>=0 && r>=0; c--,r--) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }

        //upper right
        for(int c=col; c<board.length && r>=0; r--,c++) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }

        //lower left
        for(int c=col; c>=0 && r<board.length; c--,r++) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }

        //lower right
        for(int c=col; c<board.length && r<board.length; r++,c++) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void saveBoard(char[][] board, List<List<String>> allBoards) {
        String row = "";
        List<String> newBoard = new ArrayList<>();

        for(int i=0; i<board.length; i++) {
            row = "";
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j] == 'Q') {
                    row += 'Q';
                }
                else
                    row += '.';
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }

    public static void helper(char[][]board, List<List<String>> allboards, int col) {
        if(col == board.length) {
            saveBoard(board,allboards);
            return;
        }
        for( int row=0; row<board.length; row++) {
            if(isSafe(row,col,board)) {
                board[row][col] = 'Q';
                helper(board,allboards,col+1);
                board[row][col] = '.';
            }
        }
    }
    public List<List<String>> solvedNqueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        helper(board,allBoards,0);
        return allBoards;
    }
}