package graph.weighted;

import java.util.LinkedList;

public class WeightedGraph {

    static class EdgeNode {
        int endPoint;
        int weight;
    }

    int mNumVertices;
    int mNumEdges;
    boolean mIsDirected;
    LinkedList<EdgeNode>[] mEdges;
    int[] mDegrees;

    public WeightedGraph(int numVertices, int numEdges, boolean isDirected) {
        mNumVertices = numVertices;
        mNumEdges = numEdges;
        mIsDirected = isDirected;
        mEdges = new LinkedList[mNumVertices];
        for (int i = 0; i < mNumVertices; ++i) {
            mEdges[i] = new LinkedList<>();
        }
        mDegrees = new int[mNumVertices];
    }
}
