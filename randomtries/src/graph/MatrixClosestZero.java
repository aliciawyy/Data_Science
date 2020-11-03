package graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

/**
 * 542. 01 Matrix
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 *
 */
public class MatrixClosestZero {

    /**
     * DP.
     * Runtime: 5 ms, faster than 99.14% of Java online submissions for 01 Matrix.
     * Memory Usage: 42.7 MB, less than 5.88% of Java online submissions for 01 Matrix.
     */
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return null;
        }
        final int m = matrix.length, n = matrix[0].length;
        final int[][] dist = new int[m][n];
        dist[0][0] = matrix[0][0] == 0 ? 0 : m + n;
        for (int j = 1; j < n; ++j) {
            if (matrix[0][j] != 0) {
                dist[0][j] = dist[0][j - 1] + 1;
            }
        }
        for (int i = 1; i < m; ++i) {
            if (matrix[i][0] != 0) {
                dist[i][0] = dist[i - 1][0] + 1;
            }
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] != 0) {
                    dist[i][j] = Math.min(dist[i - 1][j], dist[i][j - 1]) + 1;
                }
            }
        }
        final int mLast = m - 1, nLast = n - 1;
        for (int j = nLast - 1; j >= 0; --j) {
            if (matrix[mLast][j] != 0) {
                dist[mLast][j] = Math.min(dist[mLast][j], dist[mLast][j + 1] + 1);
            }
        }
        for (int i = mLast - 1; i >= 0; --i) {
            if (matrix[i][nLast] != 0) {
                dist[i][nLast] = Math.min(dist[i][nLast], dist[i + 1][nLast] + 1);
            }
        }
        for (int i = mLast - 1; i >= 0; --i) {
            for (int j = nLast - 1; j >= 0; --j) {
                if (matrix[i][j] != 0) {
                    dist[i][j] = Math.min(dist[i][j], Math.min(dist[i + 1][j], dist[i][j + 1]) + 1);
                }
            }
        }
        return dist;
    }

    /**
     * Runtime: 50 ms
     * Memory Usage: 47.9 MB
     */
    public int[][] updateMatrixBFS(int[][] matrix) {
        if (matrix.length == 0) {
            return null;
        }
        final int m = matrix.length, n = matrix[0].length;
        final int[][] dist = new int[m][n];
        ArrayDeque<List<Integer>> queue = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dist[i], -1);
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    queue.addLast(List.of(i, j, 0));
                }
            }
        }
        while (!queue.isEmpty()) {
            var item = queue.pollFirst();
            int x = item.get(0), y = item.get(1), count = item.get(2);
            if (x < 0 || x >= m || y < 0 || y >= n || dist[x][y] >= 0) {
                continue;
            }
            dist[x][y] = count;
            ++count;
            queue.addLast(List.of(x, y - 1, count));
            queue.addLast(List.of(x, y + 1, count));
            queue.addLast(List.of(x - 1, y, count));
            queue.addLast(List.of(x + 1, y, count));
        }
        return dist;
    }

    public static void main(String[] args) {
        var solver = new MatrixClosestZero();
        var answer1 = solver.updateMatrix(new int[][]{
                new int[]{1},
                new int[]{1},
                new int[]{1},
                new int[]{0},
                new int[]{0},
                new int[]{1},
        });
        var answer2 = solver.updateMatrix(new int[][]{
                new int[]{0, 0, 0},
                new int[]{0, 1, 0},
                new int[]{1, 1, 1},
        });
        for (var row: answer1) {
            System.out.println(Arrays.toString(row));
        }
    }
}
