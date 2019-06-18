//=========================================================================
//
// File Name: @(#)Sorter.java
//
// Create Date: Nov 10, 2003
//
// https://peppybytes.blogspot.com/2019/05/programming-problems-sorting-algorithms.html
// 
//=========================================================================

package com.training;

/**
 * <P>
 * <code>Sorttest</code> class.
 * </P>
 * 
 * @see 
 */

public class Sorter
{
    private String strSep = ",";

    /*
     * Display the contents of an integer array.
     * @param anDisp - Integer array to be displayed.
     */
    public void displayArray(int[] anDisp)
    {
        int nArLen = anDisp.length;

        for (int i = 0; i < nArLen; i++)
        {
            System.out.print(anDisp[i]);
            System.out.print(strSep);
        }

        System.out.println();
    }

    /*
     * Performs Bubble sort.
     * @param anInOut - Integer array to be sorted.
     */
    public void doBubbleSort(int[] anInOut)
    {
        int i;
        int nTemp;
        int nLimit;
        int nLastSwapPos;
        int nArrayLen = anInOut.length;

        // Iteration limit set for entire array 
        nLimit = nArrayLen - 1;
        while (true)
        {
            nLastSwapPos = 0;
            for (i = 0; i < nLimit; i++)
            {
                if (anInOut[i] > anInOut[i + 1])
                {
                    // Note down the last swap position
                    nLastSwapPos = i;
                    nTemp = anInOut[i];
                    anInOut[i] = anInOut[i + 1];
                    anInOut[i + 1] = nTemp;
                }
            }

            // Array has been sorted.
            //   No further iterations required
            if (nLastSwapPos == 0)
                break;

            // Restrict the iteration limit
            //   to the last swap position
            nLimit = nLastSwapPos;
        }
    }

    /*
     * Performs Insertion sort.
     * @param anInOut - Integer array to be sorted.
     */
    public void doInsertionSort(int[] anInOut)
    {
        int i, j, nMinVal;
        int nArrayLen = anInOut.length;

        for (i = 1; i < nArrayLen; i++)
        {
            // Note down the minimum value
            nMinVal = anInOut[i];

            for (j = i; j > 0; j--)
            {
                // Check the left side values with the minimum value
                if (anInOut[j - 1] <= nMinVal)
                    break;

                // If it is higher then shift the element 
                //   to the right side    
                anInOut[j] = anInOut[j - 1];
            }

            // Insert the minimum value at vacant place
            anInOut[j] = nMinVal;
        }
    }

    /*
     * Performs Selection sort.
     * @param anInOut - Integer array to be sorted.
     */
    public void doSelectionSort(int[] anInOut)
    {
        int i, j, nMinSubscript, nTemp;
        int nArLen = anInOut.length;

        for (i = 0; i < nArLen; i++)
        {
            nMinSubscript = i;
            
            // Iterate rest of array to find out
            //   smallest value.
            for (j = i + 1; j < nArLen; j++)
            {
                // Note down the element position containing
                //   the smallest value 
                if (anInOut[j] < anInOut[nMinSubscript])
                    nMinSubscript = j;
            }
            
            // Swap it with the current position
            if (i != nMinSubscript)
            {
                nTemp = anInOut[i];
                anInOut[i] = anInOut[nMinSubscript];
                anInOut[nMinSubscript] = nTemp;
            }
        }
    }

    /*
     * Sorts three integers using if statements.
     * @param x, y, z - Integers to be sorted.
     */
    public void doSortInteger(int x, int y, int z)
    {
        System.out.println("Given Order " + x + strSep + y + strSep + z);
        if (x <= y)
        {
            if (x <= z)
            {
                if (y <= z)
                {
                    System.out.println(
                        "Sorted Order " + x + strSep + y + strSep + z);
                }
                else
                {
                    System.out.println(
                        "Sorted Order " + x + strSep + z + strSep + y);
                }
            }
            else
            {
                System.out.println(
                    "Sorted Order " + z + strSep + x + strSep + y);
            }
        }
        else
        {
            if (y <= z)
            {
                if (x <= z)
                    System.out.println(
                        "Sorted Order " + y + strSep + x + strSep + z);
                else
                    System.out.println(
                        "Sorted Order " + y + strSep + z + strSep + x);
            }
            else
            {
                System.out.println(
                    "Sorted Order " + z + strSep + y + strSep + x);
            }
        }
    }
    
    /**
     * Performs Quick Sort using recursive method
     * @param - anInput array to be sorted
     * @param - nLeftSubscript - starting subscript of the array
     * @param - nRightSubscript - ending subscript of the array
     */
    
    public void doQuickSort(
        int[] anInput,
        int nLeftSubscript,
        int nRightSubscript)
    {
        int nPartitionSubscript;

        // If the array size becomes to 1 then termination occurs
        if (nRightSubscript - nLeftSubscript < 1)
            return;

        nPartitionSubscript =
            doPartition(anInput, nLeftSubscript, nRightSubscript);

        // Sort left partition
        doQuickSort(anInput, nLeftSubscript, nPartitionSubscript - 1);
        
        // Sort right partition
        doQuickSort(anInput, nPartitionSubscript + 1, nRightSubscript);
    }

    public int doPartition(
        int[] anInput,
        int nLeftSubscript,
        int nRightSubscript)
    {
        int nPivotVal;
        int nPivotSubscript;

        // Picking up the right most element as pivot value
        nPivotVal = anInput[nRightSubscript];
        nPivotSubscript = nRightSubscript;

        while (true)
        {
            // Moving the left pointer towards right side till it has higher value
            //   than pivot and left pointer not crossed the right pointer
            while (nLeftSubscript <= nRightSubscript
                && anInput[nLeftSubscript] <= nPivotVal)
            {
                ++nLeftSubscript;
            }

            // Moving the right pointer towards left side till it has lesser value
            //   than pivot and right pointer is higher than zero
            while (nRightSubscript >= nLeftSubscript
                && anInput[nRightSubscript] >= nPivotVal)
            {
                --nRightSubscript;
            }

            // If left pointer crosses then terminate the while loop.
            if (nLeftSubscript > nRightSubscript)
                break;

            // Swaping the position of left pointer contains higher value
            //   than pivot with the right pointer contains the lesser value
            //   than pivot.
            swap(anInput, nLeftSubscript, nRightSubscript);
        }

        // Put the pivot value in its final place, which is in between the
        //   left and right partitions.
        if (nLeftSubscript < nPivotSubscript)
        {
            swap(anInput, nLeftSubscript, nPivotSubscript);
            nPivotSubscript = nLeftSubscript;
        }

        return (nPivotSubscript);
    }

    public void swap(int[] anInput, int nLeftSubscript, int nRightSubscript)
    {
        int nTemp;

        nTemp = anInput[nLeftSubscript];
        anInput[nLeftSubscript] = anInput[nRightSubscript];
        anInput[nRightSubscript] = nTemp;
    }    
}