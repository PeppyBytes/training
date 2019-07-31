# training

Programming Problems - https://peppybytes.blogspot.com/search/label/Programming%20Problems



1. Sorter - https://peppybytes.blogspot.com/2019/05/programming-problems-sorting-algorithms.html

Implement a class called Sorter which has the following four public methods
public void doBubbleSort(int a[]);
public void doSelectionSort(int a[])’
public void doInsertionSort(int a[]);
public void doQuickSort(int a[]);


2. Eight Queens - https://peppybytes.blogspot.com/2019/06/programming-problems-eight-queens.html

The eight queens problem is the problem of placing eight queens on a 8×8 chessboard
such that none of them attack one another (no two queens are in the same row, column, or diagonal).

When the solve() method is called it should print all possible unique solutions,
printing each solution in a line and finally should print the Total number of solutions.

As an example one possible solution could be
15863724

There are eight numbers printed, each digit giving the column number and the position of
the digit is the row number.

So in the above example, in 1st row, 1st column a queen is placed, then in 2nd row, 5th column,
then in 3rd row 8th column and so on.

An elegant solution makes use of a single dimensional array and solves using Recursion
and BackTracking.


Implement the class EightQueens
public void solve();


3. Factorial - https://peppybytes.blogspot.com/2019/06/programming-problems-factorial.html

Given a non-negative number n find its factorial without using Recursion.

n! = 1 * 2 * 3 * 4 * ...... n-2 * n-1 * n

Also, implement using a recursive method. Factorial can also be recursively expressed as

factorial(n) = n * factorial(n - 1)

This is definitely a very trivial exercise. But the exercise is deliberately kept trivial so that
one can concentrate on other important aspects of the art of coding which are listed below.

1. Check for illegal arguments and handle them
2. Inline comments
3. JavaDoc for the class
4. JavaDoc for all the public methods
5. Ability to convert a recursive method into a non-recursive method.

The first four points are extremely important and hope they are strictly followed from now on.
Please take a look at
http://hg.openjdk.java.net/jdk7/jdk7/jdk/file/00cd9dc3c2b5/src/share/classes/java/util/ArrayList.java
the source code of ArrayList of java.util package and use it as a model for following all the
four points.

The last point is a really interesting one. In real life projects sometimes it becomes necessary to
convert a recursive method into an iterative as the nesting of recursive calls could be too deep
and could result in a StackOverflow. Hence a recursive implementation has to be converted into an
iterative one.

This is the first exercise where we shall have both recursive and iterative implementation. Going
forward we shall see several more exercises where we shall have both the implementations. In this
case, converting a recursive implementation into an iterative one may be trivial. But in some cases,
it could be tricky and non-trivial.


Implement the class Factorial with following public methods

public int factorialUsingRecursion(int n);
public int factorial(int n);


4. Fibonacci Numbers - https://peppybytes.blogspot.com/2019/06/fibonacci-numbers.html

Given a non-negative number n find the nth Fibonacci Number.

The Fibonacci Sequence is the series of numbers:

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...

The 0th number is 0. 1st number is 1. Thereafter every number is derived by adding two numbers
before it.

Fib(0) = 0     Fib(1) = 1
Fib(n) = Fib(n-1) + Fib(n-2)

As part of this exercise first, find the Fibonacci number without using recursion and then using
recursion. Please note that the recursive implementation makes two recursive calls.

The above exercise is very trivial. So just to add some pep to the exercise let us provide a third
implementation where the Fibonacci number is calculated using a single recursive call instead of
two. If you implement this correctly then you would have taken a tiny step into the world
of Memoization.

The idea is while computing Fib(n), Fib(n-1) and Fib(n-2) are computed. Fib(n-1) is computed after
computing Fib(n-2) and Fib(n-3). Thus in this example, we can see that Fib(n-2) is computed twice.
So while computing Fib(n-1), Fib(n-2) has to be computed and hence if we can store this computation
and later reuse it then we could avoid the second recursive call. This storing of computed result
for later reuse is called Memoization and is part of Dynamic Programming.

While solving the Fibonacci problem using Memoization, a naive solution such as this uses O(n)
space. But each of the computed values is used only once and not more than once. Always it is the
just previously computed value that is required and all the values prior to that are not required.
Hence it is just enough to have storage space for the just one last previously computed value. Thus
the storage space required is O(1) instead of O(n). Please take a look at my solution for the
implementation details.

As usual, please pay attention to the documentation, inline comments, and checking of
illegal arguments.


Implement the class Fibonacci with the following public methods.

public int fib(int n);
public int fibUsingDoubleRecursion(int n);
public int fibUsingSingleRecursion(int n);



5. Maximum Subsequence Sum - https://peppybytes.blogspot.com/2019/07/programming-problems-max-subsequence-sum.html

Maximum Subsequence Sum is one of the classic problems found in the Data Structures & Algorithms
books.

Given a one dimensional array of integers, the task is to find a contiguous subarray with the
largest sum.

-1 -3 5 -2 -1 3 1 -2

For the above array, the MaxSubsequenceSum is 6 which is obtained by starting from the 3rd element
which is 5 and up to the last but one element which is 1.

5 + (-2) + (-1) + 3 + 1 = 6

This exercise also is not that difficult. Just to spice up the exercise please implement the naive
or brute force solution also. Divide and Conquer strategy also can be used and you can optionally
implement that solution also.

As usual, please pay attention to the documentation, inline comments, and checking of
illegal arguments.


Implement the class MaxSubsequenceSum with the following public methods.

public int findMaxSubsequenceSum(int[] anInput);
public int findMaxSubsequenceSumUsingBruteForce(int[] anInput);
public int findMaxSubsequenceSumUsingDivideAndConquer(int[] anInput);


