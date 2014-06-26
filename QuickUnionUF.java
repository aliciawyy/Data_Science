/**
 * Another implementation to facilitate the Union.
 * id[i] is the parent of i.
 */ 
public class QuickUnionUF
{
    private int[] id;
    
    public QuickUnionUF(int N)
    {
        id = new int[N];
        for ( int i = 0; i < N; i++ ) id[i] = i;
    }
    
    public boolean connected(int p, int q)
    {
        return root(p) == root(q); 
    }
    
    public int root(int p)
    {
        while (id[p] != p) { p = id[p]; }
        return p;
    }
    /**
     * p will be the child of q and this is
     * relected on their roots relationship
     */
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }
}