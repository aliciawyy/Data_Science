package unionfind;


import java.util.Arrays;

class SimpleUF implements UF {
    private final int[] mParent;
    private final int[] mSize;

    SimpleUF(int numNodes) {
        mParent = new int[numNodes];
        mSize = new int[numNodes];
        Arrays.fill(mSize, 1);
        for (int i = 0; i < numNodes; ++i) {
            mParent[i] = i;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (mSize[pRoot] < mSize[qRoot]) {
            // Attach the smaller tree to bigger tree
            mParent[pRoot] = qRoot;
            mSize[qRoot] += mSize[pRoot];
        } else {
            mParent[qRoot] = pRoot;
            mSize[pRoot] += mSize[qRoot];
        }
    }

    @Override
    public String toString() {
        return "SimpleUF{" +
                "mParent=" + Arrays.toString(mParent) +
                ", mSize=" + Arrays.toString(mSize) +
                '}';
    }

    private int root(int p) {
        while (mParent[p] != p) {
            // Path compression
            mParent[p] = mParent[mParent[p]];
            p = mParent[p];
        }
        return p;
    }
}
