package graph;

import java.util.function.BiConsumer;

/**
 * LeetCode. 733. Flood Fill
 */
public class FloodFill {

    /**
     * Runtime: 1 ms, faster than 48.93% of Java online submissions for Flood Fill.
     * Memory Usage: 39.9 MB, less than 8.12% of Java online submissions for Flood Fill.
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        final int m = image.length, n = image[0].length, target = image[sr][sc];
        BiConsumer<Integer, Integer> fillFunc = new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer x, Integer y) {
                if (0 <= x && x < m && 0 <= y && y < n && image[x][y] == target) {
                    image[x][y] = newColor;
                    accept(x, y - 1);
                    accept(x, y + 1);
                    accept(x - 1, y);
                    accept(x + 1, y);
                }
            }
        };
        if (target != newColor) {
            fillFunc.accept(sr, sc);
        }
        return image;
    }

}
