package graph;

import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;

/**
 * 200. Number of Islands
 */
public class NumberOfIslands {
    private static final char LAND = '1';
    private static final char CHECKED = 'X';

    private char[][] mGrid;
    private int m;
    private int n;

    /**
     * DFS.
     * Runtime: 1 ms
     * Memory Usage: 41.4 MB
     */
    public int numIslandsDFS(char[][] grid) {
        mGrid = grid;
        m = grid.length;
        n = grid[0].length;

        int count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mGrid[i][j] == LAND) {
                    ++count;
                    check(i, j);
                }
            }
        }
        return count;
    }

    private void check(int x, int y) {
        if (0 <= x && x < m && 0 <= y && y < n && mGrid[x][y] == LAND) {
            mGrid[x][y] = CHECKED;
            check(x, y - 1);
            check(x, y + 1);
            check(x - 1, y);
            check(x + 1, y);
        }
    }

    /**
     * DFS.
     * Runtime: 1 ms, faster than 99.97% of Java online submissions for Number of Islands.
     * Memory Usage: 41.6 MB, less than 9.95% of Java online submissions for Number of Islands.
     */
    public int numIslands(char[][] grid) {
        final int m = grid.length, n = grid[0].length;
        BiConsumer<Integer, Integer> checkFunc = new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer x, Integer y) {
                if (0 <= x && x < m && 0 <= y && y < n && grid[x][y] == LAND) {
                    grid[x][y] = CHECKED;
                    accept(x, y - 1);
                    accept(x, y + 1);
                    accept(x - 1, y);
                    accept(x + 1, y);
                }
            }
        };
        int count = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == LAND) {
                    ++count;
                    checkFunc.accept(i, j);
                }
            }
        }
        return count;
    }
}
