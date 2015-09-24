Sorting Lab
===========

Logans Pizza Run
----------------

* * * * *

Problem
-------

You have been hired to help determine the placement for a new Logan's
Pizza store. There are several store fronts available along Jefferson
Rd. Developers are trying to determine the best placement of a store
based on the distance to several large office buildings. They want to
locate the store so that it minimizes the distance anyone in the office
buildings would have to travel to reach the store, and they would like
to use your application to determine the location of any new store.
(Ignore the fact that each building could have a different number of
people.) The diagram below shows locations chosen by several strategies.
Numbers indicate distances to the intersection of Jefferson Rd. and
Henrietta Rd.

![Location Map](locationMap.png)

Problem-Solving Session Part One: Analyze Strategies
----------------------------------------------------

You were asked to consider the following strategies to determine the
best location of the new store (sometimes there might be more than one
best location). The problem is that only one of these strategies
\\emph{always} provides the \\emph{best} possible sum of distances.

1.  *Midpoint Distance Strategy*\
     Let `x` be the distance of the business closest to Henrietta Rd.
    Let `y` be the distance of the business farthest from Henrietta Rd.
    Locate the new store at the mid-point between `x` and `y`; that is,
    at location `(x+y)/2`. For the above example, this strategy produces
    the location 270 and the sum of the distances to this location is
    130+30+70+130 = 360.
2.  *Median Distance Strategy*\
     Sort the distances and choose the location of the middle element
    (if the number of elements is even, choose the midpoint between the
    two middle elements). For the above example, this strategy produces
    290, and the sum of the distances to this location is 150+50+50+110
    = 360.
3.  *Average Distance Strategy*\
     Locate the store at the average of the distances. For this example,
    this strategy produces 280, and the sum of the distances to this
    location is 140+40+60+120 = 360.

### Problem-Solving Tasks

In your assigned team, do the following:

1.  Create a test case that changes the locations of the stores. This
    test case should demonstrate how two of the strategies do not work
    correctly. Indicate the calculated store location and the sum of the
    distances to each business, versus the optimal choice. You may need
    more than one test case to show that two of the three strategies are
    sub-optimal. The remaining strategy is, of course, the correct,
    optimal one.
2.  Develop code that implements the optimal strategy. Given a list of
    the unsorted locations, write a function that returns the best
    location.
3.  Write another function that, given a list of unsorted locations and
    the best location, calculates and returns the sum of the distances
    between the best location and each other location.

At the end of problem-solving or when you have finished your coding
task, hand in your team's pseudo-code with all team members' names
clearly legible.

[You will receive a handout on the lab tasks after problem-solving
before you go to the labs.]

### Problem-Solving Session Part Two: FastSelect

There is an algorithm, which we will call fastselect, that runs faster
than a *simplistic implementation* of the optimal, sorted median
strategy.

The fastselect approach is more efficient than many sorting techniques
we have seen so far. Fastselect finds the `k^th` smallest number in an
*unsorted* list of numbers. Study the algorithm below and consider how
you could use fastselect to compute the median and solve the store
location problem.

    Function fastSelect( aList, k ):
        While aList is not empty:
            pivot <- Choose the element at position ( len( aList ) // 2 )
            smallerList <- All elements of aList smaller than pivot
            largerList <- All elements of aList larger than pivot
            count <- the number of occurrences of pivot value in aList
            m <- the size of smallerList
            If k >= m and k < m + count then:
                return pivot
            If m > k:
                aList = smallerList   
            Otherwise:
                k = k - m - count
                aList = largerList

It is assumed that `k` is in the range `0` to `len(aLst)-1`.

### Lab Questions

Answer the following questions on fastselect and program performance as
you design, implement and test your programs. This will show that you
understand how fastselect works and how to measure execution time in a
program. (hint: to analyze the algorithm, apply it by hand to a small,
unsorted data sequence.)

These questions should be answered in the file `report.txt` which can be
obtained [here.](./report.txt)

1.  What is the purpose of the `pivot`? Do we really need to choose the
    middle item as the pivot? Would the algorithm have behaved
    differently if we had selected the first item as the pivot each
    time?
2.  Fastselect is versatile because it can find the `k^th` smallest
    number. What test cases are needed to fully exercise fastselect?
    List several cases that exercise all aspects of the fastselect
    function. Remember: *a test case identifies specific input values
    and expected outputs*.
3.  What is the elapsed time performance of your fastselect program when
    it processes a large data set? (See link below). What is the elapsed
    time performance of your median program when it processes the same
    large data set? Enter the elapsed times of *several runs* of each
    program in your report.

Lab Implementation
------------------

You must write *two programs* that implement the same strategy and
*instrument* each program to measure and report its time performance.
Your *individual implementation* must complete and deliver the
following:

1.  `FindSlow.java`: a program implementing the *simplistic* median
    approach;
2.  `FindFast.java`: a program implementing the *fastselect* algorithm;
    and
3.  `report.txt`: a file containing answers to the questions posed
    earlier.

Each program has similar structure, processes the same input files, and
produces the same results. Both implementations will use a file
specified on the command line to obtain the input data. The input file
content will be formatted as shown in this short example:

        Offices 140
        MedicalOffice  240
        PostOffice 340
        Mall 400

Each program must calculate and print the optimal location of the store
and the sum of the distances that people would have to travel to reach
the store from each given location.

Each implementation must have instrumentation that reports the elapsed
time used to sort and select the location. Java has a
`System.currentTimeMillis()` method that returns the current number of
milliseconds since midnight of January 1, 1970. Use this method to
capture a start time and a finish time; the difference is the elapsed
time.

*You may not use any built-in Collections Class sort functions. You
should implement an Insertion Sort algorithm for the first (slow)
version and the FastSelect algorithm for the second (fast) version.*

A sample run of the program follows:

      Optimal store location: 145
      Sum of distances: 180
      Elapsed time: 0

Note that there are no blank spaces before each line of output. There is
exactly one space after the ':' on each line. There are no blank lines
before or after the output.

To test performance, download and analyze
[`this`](http://www.cs.rit.edu/~csci242/pub/testDataSet10k.txt) large
test case.

Run each implementation several times with this data file. Measure how
much time it takes to find the median after reading the file and before
printing results. List your time comparisons for each implementation. Be
patient; the runs will take time.
