package bruteforce;

import java.util.Arrays;

/**
 * 304. Range Sum Query 2D - Immutable
 */
public class RangeSumQuery2D {

    /**
     * Runtime: 10 ms, faster than 100.00% of Java online submissions for Range Sum Query 2D - Immutable.
     * Memory Usage: 44.9 MB, less than 7.32% of Java online submissions for Range Sum Query 2D - Immutable.
     */
    static class NumMatrix {
        private int[][] mRectSum;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0) {
                return;
            }
            final int m = matrix.length, n = matrix[0].length;
            mRectSum = new int[m][n];
            mRectSum[0][0] = matrix[0][0];
            for (int j = 1; j < n; ++j) {
                mRectSum[0][j] = mRectSum[0][j - 1] + matrix[0][j];
            }
            for (int i = 1; i < m; ++i) {
                mRectSum[i][0] = mRectSum[i - 1][0] + matrix[i][0];
            }
            for (int i = 1; i < m; ++i) {
                int rowSum = matrix[i][0];
                for (int j = 1; j < n; ++j) {
                    rowSum += matrix[i][j];
                    mRectSum[i][j] = mRectSum[i - 1][j] + rowSum;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {

            int sum = mRectSum[row2][col2];
            if (row1 > 0) {
                sum -= mRectSum[row1 - 1][col2];
            }
            if (col1 > 0) {
                sum -= mRectSum[row2][col1 - 1];
            }
            if (row1 > 0 && col1 > 0) {
                sum += mRectSum[row1 - 1][col1 - 1];
            }
            return sum;
        }
    }

    class NumMatrixBruteForce {
        private int[][] mMatrix;

        public NumMatrixBruteForce(int[][] matrix) {
            mMatrix = matrix;
        }

        /**
         * Runtime: 108 ms, faster than 9.93% of Java online submissions for Range Sum Query 2D - Immutable.
         * Memory Usage: 44.6 MB, less than 7.32% of Java online submissions for Range Sum Query 2D - Immutable.
         */
        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;
            for (int i = row1; i <= row2; ++i) {
                for (int j = col1; j <= col2; ++j) {
                    sum += mMatrix[i][j];
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[][] {
                new int[] {3,0,1,4,2},
                new int[] {5,6,3,2,1},
                new int[] {1,2,0,1,5},
                new int[] {4,1,0,1,7},
                new int[] {1,0,3,0,5}
        };
        var solver = new NumMatrix(matrix1);
        System.out.println("1/ Expected: 8 Actual: " + solver.sumRegion(2, 1, 4, 3));
    }
}
