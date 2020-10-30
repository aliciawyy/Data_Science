package unionfind;

import java.util.Arrays;

/**
 * 130. Surrounded Regions
 */
public class SurroundedRegions {
    private static final char X = 'X';
    private static final char O = 'O';
    private static final char R = 'R';

    private int mSideP;
    private int mSideQ;

    /**
     * Runtime: 1 ms, faster than 99.83% of Java online submissions for Surrounded Regions.
     * Memory Usage: 41 MB, less than 13.62% of Java online submissions for Surrounded Regions.
     */
    public void solve(char[][] board) {
        mSideP = board.length;
        if (mSideP < 2) {
            return;
        }
        mSideQ = board[0].length;
        for (int i = 0; i < mSideQ; ++i) {
            color(board, 0, i);
            color(board, mSideP - 1, i);
        }
        for (int i = 0; i < mSideP; ++i) {
            color(board, i, 0);
            color(board, i, mSideQ - 1);
        }

        for (int i = 0; i < mSideP; ++i) {
            for (int j = 0; j < mSideQ; ++j) {
                if (board[i][j] == O) {
                    board[i][j] = X;
                } else if (board[i][j] == R) {
                    board[i][j] = O;
                }
            }
        }
    }

    public void color(char[][] board, int p, int q) {
        if (p < 0 || p >= mSideP || q < 0 || q >= mSideQ || board[p][q] != O) {
            return;
        }
        board[p][q] = R;
        color(board, p, q + 1);
        color(board, p, q - 1);
        color(board, p + 1, q);
        color(board, p - 1, q);
    }

    public static void main(String[] args) {
        var SR = new SurroundedRegions();
        char[][] board = new char[][] {
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'},
                {'X','O','X','O','X','O'},
                {'O','X','O','X','O','X'}
        };
        for (var row: board) {
            System.out.println(Arrays.toString(row));
        }
        SR.solve(board);
        System.out.println("Answer:");
        for (var row: board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
