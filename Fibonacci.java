/**
 * \file Fibonacci.java
 */

public class Fibonacci
{
    public static void Init(int N)
    {
        value = new long[N+1];
        for ( int i = 0; i < N+1; ++i ) { value[i] = -1; }
        value[0] = 0;
        value[1] = 1;
    }
    public static long F(int N)
    {
        if ( value[N] < 0 ) { value[N] = F(N-1)+F(N-2); }
        return value[N];
    }
    
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        Init(N);
        for ( int i = 0; i < N; i++ )
            StdOut.println(i + " " + F(i));
    }
    
    private static long[] value;
}