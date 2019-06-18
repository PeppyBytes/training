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

An elegant solution makes use of a single dimensional array and solves using Recursion and BackTracking.


Implement the class EightQueens
public void solve();


3. Factorial - https://peppybytes.blogspot.com/2019/06/programming-problems-factorial.html

Given a non-negative number n find its factorial without using Recursion.

n! = 1 * 2 * 3 * 4 * ...... n-2 * n-1 * n

Also, implement using a recursive method. Factorial can also be recursively expressed as

factorial(n) = n * factorial(n - 1)

This is definitely a very trivial exercise. But the exercise is deliberately kept trivial so that one can concentrate
on other important aspects of the art of coding which are listed below.

1. Check for illegal arguments and handle them
2. Inline comments
3. JavaDoc for the class
4. JavaDoc for all the public methods
5. Ability to convert a recursive method into a non-recursive method.

The first four points are extremely important and hope they are strictly followed from now on. Please take a look at
http://hg.openjdk.java.net/jdk7/jdk7/jdk/file/00cd9dc3c2b5/src/share/classes/java/util/ArrayList.java the source code
of ArrayList of java.util package and use it as a model for following all the four points.

The last point is a really interesting one. In real life projects sometimes it becomes necessary to convert a recursive
method into an iterative as the nesting of recursive calls could be too deep and could result in a StackOverflow. Hence
a recursive implementation has to be converted into an iterative one.

This is the first exercise where we shall have both recursive and iterative implementation. Going forward we shall see
several more exercises where we shall have both the implementations. In this case, converting a recursive implementation
into an iterative one may be trivial. But in some cases, it could be tricky and non-trivial.

Implement the class Factorial with following public methods

public int factorialUsingRecursion(int n);
public int factorial(int n);

