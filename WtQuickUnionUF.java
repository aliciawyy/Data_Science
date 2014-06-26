/**
 * Another implementation to facilitate the Union.
 * id[i] is the parent of i.
 * The smaller trees always goes below.
 */ 
public class WtQuickUnionUF
{
    private int[] id;
    private int[] sz; // Use the sz array to store the size of the tree
    
    public WtQuickUnionUF(int N)
    {
        id = new int[N];
        for ( int i = 0; i < N; i++ ) { id[i] = i; sz[i] = 1; }
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
     * The smaller tree always goes down.
     */
    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        if ( i == j ) return;
        
        if ( sz[i] < sz[j] ) { // i is no longer a root
            id[i] = j; sz[j] += sz[i];
        }
        else {
            id[j] = i; sz[i] += sz[j]; 
        }
        
    }
}