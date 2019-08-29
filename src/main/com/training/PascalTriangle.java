//=========================================================================
//
// File Name: @(#)PascalTriangle.java
//
// Create Date: Nov 13, 2003
// 
//=========================================================================

package com.training;

/**
 * <P>
 * <code>PascalTriangle</code> class.
 * </P>
 */

public class PascalTriangle
{
    /**
     * Finding the cell value in pascal triangle using two recursive calls.
     * @param nRowNum,nColNum - is the cell reference for which the value has to be found out.
     */
    public int getCellValUsingRecursion(int nRowNum, int nColNum)
    {
        // Throwing exception for invalid inputs.
        if (nRowNum <= 0 || nColNum <= 0 || nColNum > nRowNum)
            throw new IllegalArgumentException();

        // Terminating condition
        //   The cell value will be one for the first and last columns
        if (nColNum == 1 || nColNum == nRowNum)
            return 1;

        // The cell value in the second column and in the
        //   last but one column is always one less than the row number
        if (nColNum == 2 || nColNum == (nRowNum - 1))
            return (nRowNum - 1);

        // Pascal triangle exhibits symmetry in a given row across the midpoint.
        if (nColNum > (nRowNum / 2))
            nColNum = (nRowNum - nColNum) + 1;

        return (
            getCellValUsingRecursion(nRowNum - 1, nColNum - 1)
                + getCellValUsingRecursion(nRowNum - 1, nColNum));
    }

    /**
     * Finding the cell value in pascal triangle without using recursion.
     * @param nRowNum,nColNum - is the cell reference for which the value has to be found out.
     */
    public int getCellVal(int nRowNum, int nColNum)
    {
        int i;
        int nNumerator;
        int nDenominator;

        // Throwing exception for invalid inputs.
        if (nRowNum <= 0 || nColNum <= 0 || nColNum > nRowNum)
            throw new IllegalArgumentException();

        // The cell value will be one for the first and last columns
        if (nColNum == 1 || nColNum == nRowNum)
            return 1;

        // The cell value in the second column and in the last but one column is always one less
        // than the row number
        if (nColNum == 2 || nColNum == (nRowNum - 1))
            return (nRowNum - 1);

        // Pascal triangle exhibits symmetry in a given row row across the midpoint. Hence if a
        // column value is larger (past the mid point) then convert it into a corresponding smaller
        // value so that the number of iterations is reduced.
        if (nColNum > (nRowNum / 2))
            nColNum = (nRowNum - nColNum) + 1;


        // Formula for PascalTriangle cell value is
        //   RowNum-1 C ColNum-1
        //   = (RowNum-1)! / ((ColNum-1)! * (RowNum-ColNum)!
        //   which is equivalent to
        //   Numerator = R-1 * R-2 * R-3 * ... ColNum-1 times
        //   Denominator = (ColNum-1)!
        nNumerator = 1;
        nDenominator = 1;
        for (i = 1; i < nColNum; i++)
        {
            nNumerator *= nRowNum - i;
            nDenominator *= i;
        }

        return (nNumerator / nDenominator);
    }
}