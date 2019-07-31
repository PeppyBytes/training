//=========================================================================
//
// File Name: @(#)Fibonacci.java
//
// Create Date: Nov 12, 2003
//
// https://peppybytes.blogspot.com/2019/06/fibonacci-numbers.html
//
//=========================================================================

package com.training;

/**
 * <P> <code>Fibonacci</code> class.</P>
 *
 * @see
 */

public class Fibonacci
{
    /**
     * Finding Fibonacci series value of given value without using recursion.
     *
     * @param - n the integer value for which the result has to be found out.
     */
    public int fib(int n)
    {
        if (n < 0)
        {
            throw new IllegalArgumentException();
        }

        int i;
        int fibOut = n;
        int fibMinusOne = 1;
        int fibMinusTwo = 0;

        for (i = 2; i <= n; i++)
        {
            fibOut = fibMinusOne + fibMinusTwo;
            fibMinusTwo = fibMinusOne;
            fibMinusOne = fibOut;
        }

        return fibOut;
    }

    /**
     * Finding Fibonacci series value of a given integer using recursion twice.
     *
     * @param n - the integer value for which the result has to be found out.
     */
    public int fibUsingDoubleRecursion(int n)
    {
        // Throw exception for zero and negative numbers
        if (n < 0)
        {
            throw new IllegalArgumentException();
        }

        // Terminating condition
        if (n <= 1)
        {
            return n;
        }

        return (fibUsingDoubleRecursion(n - 1) + fibUsingDoubleRecursion(n - 2));
    }

    /**
     * Finding Fibonacci series value of given value elimating the second recursive call
     *
     * @param - n the integer value for which the result has to be found out.
     */
    public int fibUsingSingleRecursion(int n)
    {
        return fibUsingSingleRecursion(n, new int[1]);
    }

    private int fibUsingSingleRecursion(int n, int[] anPrevFibOut)
    {
        int fibMinusOne;
        int fibMinusTwo;

        if (n < 0)
        {
            throw new IllegalArgumentException();
        }

        // Terminating condition
        if (n <= 1)
        {
            anPrevFibOut[0] = 0;
            return n;
        }

        fibMinusOne = fibUsingSingleRecursion(n - 1, anPrevFibOut);
        fibMinusTwo = anPrevFibOut[0];

        anPrevFibOut[0] = fibMinusOne;
        return (fibMinusOne + fibMinusTwo);
    }
}