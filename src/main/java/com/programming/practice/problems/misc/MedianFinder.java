package com.programming.practice.problems.misc;

import java.util.*;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is
 * no middle value. So the median is the mean of the two middle value. For example,
 *
 * <p>[2,3,4], the median is 3
 *
 * <p>[2,3], the median is (2 + 3) / 2 = 2.5
 *
 * <p>Design a data structure that supports the following two operations:
 *
 * <p>void addNum(int num) - Add a integer number from the data stream to the data structure. double
 * findMedian() - Return the median of all elements so far.
 *
 * <pre>
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/find-median-from-data-stream/">Find Median from
 *     Data Stream</a>
 */
public class MedianFinder {

  // Using TreeSet because it has a runtime complexity of O (n * logn). Furthermore we are using
  // indices as values for the set instead of actual values on nums since set only will contain
  // unique elements.
  // Therefore any duplicate elements on nums won't be evaluated.

  // Left will have left side of the sorted median window.
  private final TreeSet<Integer> left;
  private final TreeSet<Integer> right;
  private final List<Integer> dataStream;

  /** Constructor for {@link MedianFinder}. */
  public MedianFinder() {

    this.dataStream = new ArrayList<>();

    // Comparator to sort the value on tree-set in ascending order of the num values.
    final Comparator<Integer> treeSetComparator =
        (index1, index2) -> {
          if (this.dataStream.get(index1) != this.dataStream.get(index2)) {
            return this.dataStream.get(index1) - this.dataStream.get(index2);
          }

          // If two integers are equal then sort them according to their respective indices.
          return index1 - index2;
        };

    this.left = new TreeSet<>(treeSetComparator);
    this.right = new TreeSet<>(treeSetComparator);
  }

  /**
   * Adds a number to the data stream.
   *
   * @param num The number to add to the data stream.
   */
  public void addNum(int num) {
    // Add the new element to the right, and then remove the smallest element and add it to the
    // left.
    // The end effect is adding an extra element to the left and then balancing the TreeSets
    dataStream.add(num);
    right.add(dataStream.size() - 1);
    left.add(right.pollFirst());

    balanceTreeSet();
  }

  /**
   * Finds the median of the data stream.
   *
   * @return The median of the data stream.
   */
  public double findMedian() {
    // If the window is even length, then the median is the average of the max of left & min of
    // right.
    if (left.size() == right.size()) {
      // The double cast is required for addition of very large integers where their addition
      // exceeds the max int value
      return ((double) dataStream.get(left.last().intValue())
              + (double) dataStream.get(right.first().intValue()))
          / 2.0;
    }

    // If the window is Odd length, then the median is the min of the right
    return (double) dataStream.get(right.first().intValue());
  }

  /**
   * Balances the two TreeSets such that elements are equally distributed between the two TreeSets.
   */
  private void balanceTreeSet() {
    // The equal size condition is for even length window. The + 1 condition is for the odd length
    // window.
    while (left.size() != right.size() && right.size() != left.size() + 1) {
      right.add(left.pollLast());
    }
  }
}
