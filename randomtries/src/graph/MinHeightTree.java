package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinHeightTree {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return List.of(0);
        }
        LinkedList<Integer>[] graph = new LinkedList[n];
        for (int i = 0; i < n; ++i) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge: edges) {
            final int x = edge[0], y = edge[1];
            graph[x].add(y);
            graph[y].add(x);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (graph[i].size() > 1) {
                result.add(i);
            }
        }
        return result;
    }
}
