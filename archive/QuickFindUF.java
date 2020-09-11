/**
 * \file QuickFindUF.java 
 * This is an implementation of eager approach.
 * For this algorithm, the find is fast while the
 * union is order N.
 */

public class QuickFindUF
{
    private int[] id;
    
    public QuickFindUF(int N)
    {
        id = new int[N];
        for ( int i = 0; i < N; i++ ) id[i] = i;
    }
    
    public boolean connected(int p, int q)
    {
        return id[p] == id[q]; 
    }
    
    /**
     * change all the p connected to qid
     * Too expensive : O(N)
     */
    public void union(int p, int q)
    {
        int pid = id[p];
        int qid = id[q];
        for ( int i = 0; i < id.length; ++i )
            if (id[i] == pid) id[i] = qid;
    }
}

