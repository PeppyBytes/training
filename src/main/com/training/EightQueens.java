//=========================================================================
//
// File Name: @(#)EightQueens.java
//
// Create Date: Nov 13, 2003
//
// https://peppybytes.blogspot.com/2019/06/programming-problems-eight-queens.html
//
//=========================================================================

package com.training;

/**
 * <P>
 * <code>EightQueens</code> class.
 * </P>
 * To place the eight queens in a chess board
 *   in such a way that they don't attack each other.
 *
 * @see
 */

public class EightQueens
{
    static final int MAX_RowSubscript = 7;
    static final int MAX_ColSubscript = 7;

    int[]   m_anColPos;
    int     m_nSolutionCt;

    public EightQueens()
    {
        m_nSolutionCt = 0;
        m_anColPos = new int[8];
    }

    public static void main(String[] args)
    {
        EightQueens eq = new EightQueens();

        eq.solve();
    }

    public void solve()
    {
        placeQueen(0);

        System.out.println("Total number of solutions - " + m_nSolutionCt);
    }

    protected void displayQueenColPos()
    {
        int i;

        for (i = 0; i <= MAX_RowSubscript; i++)
        {
            // Print ColumnNumber and not ColumnSubscript
            System.out.print(m_anColPos[i] + 1);
        }

        System.out.println();
    }

    // Attempts to place a queen in the passed row and then
    //  recursively calls itself to place queen in the higher rows
    protected void placeQueen(int nRowSubscript)
    {
        int i;

        if (nRowSubscript > MAX_RowSubscript)
        {
            // Valid solution found.
            m_nSolutionCt++;
            displayQueenColPos();

            return;
        }

        for (i = 0; i <= MAX_ColSubscript; i++)
        {
            if (isQueenPositionValid(nRowSubscript, i))
            {
                // ColPos is ok for current row. Try to
                //   place a queen in the next row.
                m_anColPos[nRowSubscript] = i;
                placeQueen(nRowSubscript + 1);
            }
        }
    }

    // Checks if a Queen can be placed at the passed row and column
    protected boolean isQueenPositionValid(int nRowSubscript, int nColSubscript)
    {
        int i;

        if (nRowSubscript == 0)
            return (true);

        for (i = 0; i < nRowSubscript; i++)
        {
            // Check if any queen is present in the same column
            if (m_anColPos[i] == nColSubscript)
                return (false);

            // Diagnol check can be made with a single statement like
            // nRowSubscript -i == Math.abs(nColSubcript - m_anColPos[i])
            // For clarity doing it in two statements.

            // Check if any queen is present in left downward diagnol
            if (nRowSubscript - i == nColSubscript - m_anColPos[i])
                return (false);

            // Check if any queen is present in right downward diagnol
            if (nRowSubscript - i == m_anColPos[i] - nColSubscript)
                return (false);
        }

        return (true);
    }
}
