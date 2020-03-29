package com.programming.practice.problems.array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * <p>Example 1:
 *
 * <p>Input: [1,2,3,4,5,6,7] and k = 3<br>
 * Output: [5,6,7,1,2,3,4]
 *
 * <p>Explanation:<br>
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]<br>
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]<br>
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]<br>
 * Example 2:
 *
 * <p>Input: [-1,-100,3,99] and k = 2<br>
 * Output: [3,99,-1,-100]
 *
 * <p>Explanation: <br>
 * rotate 1 steps to the right: [99,-1,-100,3]<br>
 * rotate 2 steps to the right: [3,99,-1,-100]<br>
 *
 * @see <a href = "https://leetcode.com/problems/rotate-array/">Rotate Array</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class RotateArray {

  /**
   * Rotates the array in place by k steps (Using Reverse approach).<br>
   *
   * <p><b>Approach: Using Reverse</b><br>
   *
   * <p>Algorithm: This approach is based on the fact that when we rotate the array k times, k%nk
   * elements from the back end of the array come to the front and the rest of the elements from the
   * front shift backwards.
   *
   * <p>In this approach, we firstly reverse all the elements of the array. Then, reversing the
   * first k elements followed by reversing the rest n-kn−k elements gives us the required result.
   *
   * <p>Let n=7n=7 and k=3k=3.<br>
   *
   * <pre>{@code
   * Original List                   : 1 2 3 4 5 6 7
   * After reversing all numbers     : 7 6 5 4 3 2 1
   * After reversing first k numbers : 5 6 7 4 3 2 1
   * After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
   * }</pre>
   *
   * @param nums The array to rotate.
   * @param k The k number by which the array needs to be rotated.
   */
  public void rotate(final int[] nums, final int k) {

    // Mod operation is used to accommodate the value of k > nums.length
    final int numberOfRotations = (k % nums.length);

    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, numberOfRotations - 1);
    reverse(nums, numberOfRotations, nums.length - 1);
  }

  /**
   * Reverses the elements in the array between (and inclusive) start and end index.
   *
   * @param nums The array where reverse needs to be applied.
   * @param start The start index.
   * @param end The end index.
   */
  private static void reverse(final int[] nums, final int start, final int end) {

    int i = start, j = end;
    while (i < j) {
      final int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;

      ++i;
      --j;
    }
  }

  /**
   *
   *
   * <pre>
   * {
   *   &#64;code
   *   public class JavadocTest {
   *     // indentation and line breaks are kept
   *
   *     &#64;literal
   *     &#64;SuppressWarnings
   *     public List<String> generics() {
   *       // '<' and '>' are displayed correctly
   *       // '@' CANNOT be escaped with HTML code, though!
   *     }
   *   }
   * }
   * </pre>
   */
  public void testing() {}

  /**
   * Rotates the array in place by k steps (uing Queue).
   *
   * @param nums The array to rotate.
   * @param k The k number by which the array needs to be rotated.
   */
  public void rotateUsingQueue(final int[] nums, final int k) {

    final Queue<Integer> queue = new LinkedList<>();

    for (final int number : nums) {
      queue.add(number);
    }

    // Mod operation is used to accommodate the value of k > nums.length
    // NOTE: Since queue is FIFO, therefore we we need (n - k)
    int numberOfRotations = nums.length - (k % nums.length);
    while (numberOfRotations > 0) {
      queue.add(queue.remove());
      --numberOfRotations;
    }

    for (int i = 0; i < nums.length; ++i) {
      nums[i] = queue.remove();
    }
  }
}
