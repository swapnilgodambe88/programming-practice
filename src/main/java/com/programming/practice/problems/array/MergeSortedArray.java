package com.programming.practice.problems.array;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * <p>Note:
 *
 * <p>The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume
 * that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements
 * from nums2.
 *
 * <p>Example:
 *
 * <p>Input: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
 *
 * <p>Output: [1,2,2,3,5,6]
 *
 * @see <a href = "https://leetcode.com/problems/merge-sorted-array/">Merge Sorted Array</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company eBay
 */
public final class MergeSortedArray {

  /**
   * Merges the two sorted arrays into one.
   *
   * @param nums1 The sorted array 1 with extra spaces for the merge.
   * @param m The number of elements > 0 in nums1.
   * @param nums2 The sorted array 2.
   * @param n The number of elements > 0 in nums2.
   */
  public void merge(final int[] nums1, final int m, final int[] nums2, final int n) {
    moveZerosToFront(nums1, m);

    int insertPosition = 0, nums2Index = 0, nums1Index = nums1.length - m;

    // Merge logic using three pointers - insert index, nums1Index & nums2Index
    while (nums2Index < n && nums1Index < nums1.length) {
      if (nums2[nums2Index] < nums1[nums1Index]) {
        nums1[insertPosition++] = nums2[nums2Index++];
      } else {
        nums1[insertPosition++] = nums1[nums1Index++];
      }
    }

    // Insert remaining elements from nums1
    while (nums1Index < m) {
      nums1[insertPosition++] = nums1[nums1Index++];
    }

    // Insert remaining elements from nums2
    while (nums2Index < n) {
      nums1[insertPosition++] = nums2[nums2Index++];
    }
  }

  /**
   * Moves the trailing zero to the front.
   *
   * @param input The input array.
   * @param elementsInArray The number of zeros present on the array.
   */
  private static void moveZerosToFront(final int[] input, final int elementsInArray) {
    final int numberOfZeros = input.length - elementsInArray;

    int insertIndex = input.length - 1;
    int moveIndex = elementsInArray - 1;

    // Start moving valid elements from end to the end of the array
    while (insertIndex >= numberOfZeros) {
      input[insertIndex--] = input[moveIndex--];
    }

    // Append zeros at the beginning of the array
    while (insertIndex >= 0) {
      input[insertIndex--] = 0;
    }
  }
}
