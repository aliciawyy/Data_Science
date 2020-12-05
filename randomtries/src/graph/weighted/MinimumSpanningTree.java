package graph.weighted;

import java.util.Arrays;

public class MinimumSpanningTree {

    void prim(WeightedGraph graph, int startPoint) {
        boolean[] inTree = new boolean[graph.mNumVertices];
        int[] distance = new int[graph.mNumVertices];
        int[] parent = new int[graph.mNumVertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        int p = startPoint;
        while (!inTree[p]) {
            inTree[p] = true;
            for (WeightedGraph.EdgeNode node : graph.mEdges[p]) {
                if (!inTree[node.endPoint] && node.weight < distance[node.endPoint]) {
                    distance[node.endPoint] = node.weight;
                    parent[node.endPoint] = p;
                }
            }
            int dist = Integer.MAX_VALUE;
            for (int i = 0; i < graph.mNumVertices; ++i) {
                if (!inTree[i] && distance[i] < dist) {
                    p = i;
                    dist = distance[i];
                }
            }
        }
    }
}
