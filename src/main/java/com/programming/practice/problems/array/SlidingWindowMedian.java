package com.programming.practice.problems.array;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is
 * no middle value. So the median is the mean of the two middle value. Examples:
 *
 * <p>[2,3,4] , the median is 3
 *
 * <p>[2,3], the median is (2 + 3) / 2 = 2.5
 *
 * <p>Given an array nums, there is a sliding window of size k which is moving from the very left of
 * the array to the very right. You can only see the k numbers in the window. Each time the sliding
 * window moves right by one position. Your job is to output the median array for each window in the
 * original array.
 *
 * <pre>
 * For example,
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 *
 * Window position                Median
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7       -1
 *  1  3 [-1  -3  5] 3  6  7       -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 *
 * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/sliding-window-median/">Sliding window Median</a>
 */
public class SlidingWindowMedian {

  /**
   * Given an array nums, there is a sliding window of size k which is moving from the very left of
   * the array to the very right. You can only see the k numbers in the window. Each time the
   * sliding window moves right by one position. Your job is to output the median array for each
   * window in the original array.
   *
   * @param nums The nums array.
   * @param k The window size.
   * @return The median array.
   */
  public double[] medianSlidingWindow(final int[] nums, final int k) {

    // Comparator to sort the value on tree-set in ascending order of the num values.
    final Comparator<Integer> treeSetComparator =
        (index1, index2) -> {
          if (nums[index1] != nums[index2]) {
            // NOTE: Using Integer.compare instead of 'nums[index1] - nums[index2] because
            // subtraction gives invalid results if the subtraction exceed max integer limit'
            return Integer.compare(nums[index1], nums[index2]);
          }

          // If two integers are equal then sort them according to their respective indices.
          return index1 - index2;
        };

    // Using TreeSet because it has a runtime complexity of O (n * logn). Furthermore we are using
    // indices as values for the set instead of actual values on nums since set only will contain
    // unique elements.
    // Therefore any duplicate elements on nums won't be evaluated.

    // Left will have left side of the sorted median window.
    final TreeSet<Integer> left = new TreeSet<>(treeSetComparator);

    // Right will have right side of the sorted median window. If window is of Odd length, then
    // right will contain the extra element.
    final TreeSet<Integer> right = new TreeSet<>(treeSetComparator);

    // Add all the elements to left
    for (int i = 0; i < k; ++i) {
      left.add(i);
    }

    // Balance the Tree sets so that elements are evenly distributed between the two TreeSets.
    balanceTreeSet(left, right);

    final int iterationCount = nums.length - k + 1;
    final double[] medianArray = new double[iterationCount];

    for (int i = 0; i < iterationCount - 1; ++i) {
      medianArray[i] = getMedian(left, right, nums);

      // As we move the sliding window, we remove the left element and add right element.
      // Check with TreeSet contains the index to be remove and then remove it.
      if (left.contains(i)) {
        left.remove(i);
      } else {
        right.remove(i);
      }

      // Add the new element to the right, and then remove the smallest element and add it to the
      // left.
      // The end effect is adding an extra element to the left and then balancing the TreeSets
      right.add(i + k);
      left.add(right.pollFirst());
      balanceTreeSet(left, right);
    }

    // This one adds the last window to the medianArray
    medianArray[iterationCount - 1] = getMedian(left, right, nums);

    return medianArray;
  }

  /**
   * Balances the two TreeSets such that elements are equally distributed between the two TreeSets.
   *
   * @param left The left tree set.
   * @param right The right tree set.
   */
  private void balanceTreeSet(final TreeSet<Integer> left, final TreeSet<Integer> right) {
    // The equal size condition is for even length window. The + 1 condition is for the odd length
    // window.
    while (left.size() != right.size() && right.size() != left.size() + 1) {
      right.add(left.pollLast());
    }
  }

  /**
   * Returns the median of the the tree sets.
   *
   * @param left The left tree set.
   * @param right The right tree set.
   * @param nums The nums array.
   * @return The median of the treesets.
   */
  private double getMedian(
      final TreeSet<Integer> left, final TreeSet<Integer> right, final int[] nums) {
    // If the window is even length, then the median is the average of the max of left & min of
    // right.
    if (left.size() == right.size()) {
      // The double cast is required for addition of very large integers where their addition
      // exceeds the max int value
      return ((double) nums[left.last().intValue()] + (double) nums[right.first().intValue()])
          / 2.0;
    }

    // If the window is Odd length, then the median is the min of the right
    return nums[right.first().intValue()];
  }
}
