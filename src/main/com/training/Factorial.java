//=========================================================================
//
// File Name: @(#)Factorial.java
//
// Create Date: Nov 12, 2003
//
// https://peppybytes.blogspot.com/2019/06/programming-problems-factorial.html
//
//=========================================================================

package com.training;

/**
 * <P>
 * <code>Factorial</code> class.
 * </P>
 *
 * @see
 */
public class Factorial
{
    /**
     *  Finding factorial for a given number using recursion
     *  @param  n - the number for which factorial has to be calculated.
     */
    public int factorialUsingRecursion(int n)
    {
        // Throw exception for negative numbers
        if (n < 0)
            throw new IllegalArgumentException();

        // Terminating condition
        if (n <= 1)
            return 1;

        return (n * factorialUsingRecursion(n - 1));
    }

    /**
     * Finding factorial for a given number without using Recursion
     * @param n - the number for which factorial has to be calculated
     */
    public int factorial(int n)
    {
        int nFactOut = 1;

        // Throw exception for negative numbers
        if (n < 0)
            throw new IllegalArgumentException();

        for (; n > 1; n--)
        {
            nFactOut *= n;
        }

        return nFactOut;
    }
}