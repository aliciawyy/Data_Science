/**
 * \file BinarySearch.java
 * Tiny test:
 *   java BinarySearch data/tinyW.txt < data/tinyT.txt
 * Large test:
 *   java BinarySearch data/largeW.txt < data/largeT.txt
 */

import java.util.Arrays;
    
public class BinarySearch
{
    /**
     * \param key is the value to search
     * \param a is a sorted array
     */
    public static int rank(int key, int[] a)
    {
        return rank(key, a, 0, a.length - 1);
    }
    
    public static int rank(int key, int[] a, int lo, int hi)
    {
        if ( lo > hi ) return -1;
        int mid = lo + (hi - lo)/2;
        
        if      ( key < a[mid]) return rank(key, a, lo, mid - 1);
        else if ( key > a[mid]) return rank(key, a, mid + 1, hi);
        else                    return mid;
    }
    
    public static void main(String[] args)
    {
        int[] whitelist = In.readInts(args[0]);
        Arrays.sort(whitelist);
        
        while (!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            // Print if the key is not in the given list
            if (rank(key, whitelist) < 0)
                StdOut.println(key);
        }
    }
}