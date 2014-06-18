/**
 * \file Fibonacci.java
 */

public class Fibonacci
{
    public static long F(int N)
    {
        if ( N == 0 ) return 0;
        if ( N == 1 ) return 1;
        
        /**
         * \bug Recursive calls shouldn't address subproblems that overlap.
         */
        return F(N-1) + F(N-2);
    }
    
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        
        for ( int i = 0; i < N; i++ )
            StdOut.println(i + " " + F(i));
    }
}