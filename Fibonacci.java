/**
 * \file Fibonacci.java
 */

public class Fibonacci
{
    public static long F(int N)
    {
        if ( N == 0 ) return 0;
        if ( N == 1 ) return 1;
        return F(N-1) + F(N-2);
    }
    
    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        for ( int i = 0; i < N; i++ )
            StdOut.println(i + " " + F(i));
    }
}