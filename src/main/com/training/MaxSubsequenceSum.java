//=========================================================================
//
// File Name: @(#)MaxSubSequenceSum.java
//
// Create Date: Nov 17, 2003
//
// https://peppybytes.blogspot.com/2019/07/programming-problems-max-subsequence-sum.html
// 
//=========================================================================

package com.training;

/**
 * <P> <code>MaxSubsequenceSum</code> class. To find out the maximum sub sequence sum in a given
 * series of numbers </P>
 *
 * @see
 */

public class MaxSubsequenceSum
{
    // Using non recursive method.
    public int findMaxSubsequenceSum(int[] anInput)
    {
        int i;
        int nMaxSum;
        int nCurSum;
        int nLeftSubscript;
        int nRightSubscript;

        nLeftSubscript = 0;
        nRightSubscript = anInput.length - 1;

        nCurSum = 0;
        nMaxSum = Integer.MIN_VALUE;
        for (i = nLeftSubscript; i <= nRightSubscript; i++)
        {
            nCurSum += anInput[i];
            if (nMaxSum < nCurSum)
            {
                nMaxSum = nCurSum;
            }
            else if (nCurSum < 0)
            {
                nCurSum = 0;
            }
        }

        return nMaxSum;
    }

    public int findMaxSubsequenceSumUsingBruteForce(int[] anInput)
    {
        int nMaxSum = Integer.MIN_VALUE;
        int length = anInput.length;

        for (int i = 0; i < length; i++)
        {
            int nCurSum = 0;

            for (int j = i; j < length; j++)
            {
                nCurSum += anInput[j];
                if (nMaxSum < nCurSum)
                {
                    nMaxSum = nCurSum;
                }
            }
        }

        return nMaxSum;
    }

    // Using Divide & Conquer
    public int findMaxSubsequenceSumUsingDivideAndConquer(int[] anInput)
    {
        return findMaxSubSeqSumUsingRecursion(anInput, 0, anInput.length - 1);
    }

    protected int findMaxSubSeqSumUsingRecursion(
        int[] anInput,
        int nLeftSubscript,
        int nRightSubscript)
    {
        int i;
        int nMidSubscript;

        int nMaxSum;
        int nMaxLeftPartitionSum;
        int nMaxRightPartitionSum;
        int nMaxCenterSum;

        int nLeftBorderSum;
        int nRightBorderSum;
        int nMaxLeftBorderSum;
        int nMaxRightBorderSum;

        // Base case condition
        if (nLeftSubscript == nRightSubscript)
        {
            return anInput[nLeftSubscript];
        }

        nMidSubscript = (nLeftSubscript + nRightSubscript) / 2;

        // To find out the maximum subsequence sum on Left side of the array.
        nMaxLeftPartitionSum =
            findMaxSubSeqSumUsingRecursion(
                anInput,
                nLeftSubscript,
                nMidSubscript);

        // To find out the maximum subsequence sum on Right side of the array.
        nMaxRightPartitionSum =
            findMaxSubSeqSumUsingRecursion(
                anInput,
                nMidSubscript + 1,
                nRightSubscript);

        // Evaluate the maximum value between the above
        if (nMaxLeftPartitionSum > nMaxRightPartitionSum)
        {
            nMaxSum = nMaxLeftPartitionSum;
        }
        else
        {
            nMaxSum = nMaxRightPartitionSum;
        }

        // To find out a maximum subsequence sum on left side
        //   which includes the mid subscript
        nLeftBorderSum = 0;
        nMaxLeftBorderSum = Integer.MIN_VALUE;
        for (i = nMidSubscript; i >= nLeftSubscript; i--)
        {
            nLeftBorderSum += anInput[i];
            if (nLeftBorderSum > nMaxLeftBorderSum)
            {
                nMaxLeftBorderSum = nLeftBorderSum;
            }
        }

        // To find out a maximum subsequence sum on right side
        //   which includes the mid subscript
        nRightBorderSum = 0;
        nMaxRightBorderSum = Integer.MIN_VALUE;
        for (i = nMidSubscript + 1; i <= nRightSubscript; i++)
        {
            nRightBorderSum += anInput[i];
            if (nRightBorderSum > nMaxRightBorderSum)
            {
                nMaxRightBorderSum = nRightBorderSum;
            }
        }

        // Find maximum sub sequence sum that includes mid subscript.
        nMaxCenterSum = nMaxLeftBorderSum + nMaxRightBorderSum;

        // Caculate the final maximum sub seq sum
        if (nMaxSum < nMaxCenterSum)
        {
            nMaxSum = nMaxCenterSum;
        }

        return nMaxSum;
    }
}