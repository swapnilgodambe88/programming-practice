package com.programming.practice.problems.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest
 * element in the sorted order, not the kth distinct element.
 *
 * <p>Your KthLargest class will have a constructor which accepts an integer k and an integer array
 * nums, which contains initial elements from the stream. For each call to the method
 * KthLargest.add, return the element representing the kth largest element in the stream.
 *
 * <p>Example:
 *
 * <pre>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/kth-largest-element-in-a-stream/"> Kth Largest
 *     Element in a Stream</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class KthLargestElementInStream {

  /** Stores the kth largest elements at any given time. */
  private int kthLargestElement;

  /**
   * A Priority queue to maintain all elements greater than Kth largest element. A remove option
   * removes the <b>smallest</b> element in the queue.
   */
  private final PriorityQueue<Integer> elementsGreaterThanKthLargestElement;

  /**
   * Constructor for {@link KthLargestElementInStream}.
   *
   * @param k The k value.
   * @param nums The nums array.
   */
  public KthLargestElementInStream(final int k, final int[] nums) {
    final Comparator<Integer> ascendingComparator =
        (a, b) -> {
          return a - b;
        };

    elementsGreaterThanKthLargestElement = new PriorityQueue<>(ascendingComparator);

    // Modified bubble sort at sort in ascending order till k iterations
    for (int i = 0; i < k; ++i) {
      for (int j = 0; j < nums.length - 1 - i; ++j) {
        if (nums[j + 1] < nums[j]) {
          final int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
        }
      }
    }

    // After sorting K largest elements will be placed the end of the list. Add the last k - 1
    // elements into the priority queue.
    // NOTE: the index >= 0 condition is introduced to cover the scenario -
    // KthLargestElementInStream(1, []) i.e. zero elements on the array
    int index = nums.length - 1, count = 1;
    while (count < k && index >= 0) {
      elementsGreaterThanKthLargestElement.add(nums[index--]);
      ++count;
    }

    if (index >= 0) {
      kthLargestElement = nums[index];
    } else {
      // If there are no elements provided on the initialization, then initialized kthLargestElement
      // with the smallest value
      kthLargestElement = Integer.MIN_VALUE;
    }
  }

  /**
   * Add the val element to the list, and returns the kth largest element in the stream.
   *
   * @param val The val to be inserted in the list.
   * @return The kth largest element in the stream.
   */
  public int add(final int val) {

    // If the elements is greater than or equal to the kthLargestElement, then add the val to the
    // list and then remove the smallest which will be the kth largest element
    if (val >= kthLargestElement) {
      elementsGreaterThanKthLargestElement.add(val);
      kthLargestElement = elementsGreaterThanKthLargestElement.remove();
    }

    return kthLargestElement;
  }
}
