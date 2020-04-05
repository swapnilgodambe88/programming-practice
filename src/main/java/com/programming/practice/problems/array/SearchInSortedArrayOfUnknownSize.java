package com.programming.practice.problems.array;

/**
 * Given an integer array sorted in ascending order, write a function to search target in nums. If
 * target exists, then return its index, otherwise return -1. However, the array size is unknown to
 * you. You may only access the array using an ArrayReader interface, where ArrayReader.get(k)
 * returns the element of the array at index k (0-indexed).
 *
 * You may assume all integers in the array are less than 10000, and if you access the array out of
 * bounds, ArrayReader.get will return 2147483647.
 *
 *
 * <pre>
Example 1:

Input: array = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: array = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/">Search
 *      in a Sorted Array of Unknown Size</a>
 * @author Swapnil Godambe.<br>
 *         Copyright 2020.
 */
public final class SearchInSortedArrayOfUnknownSize {

  public final static int ARRAY_READER_OUT_OF_BOUND = 2147483647;

  /**
   * The Array reader's API interface.
   *
   */
  interface ArrayReader {

    /**
     * @param index The index of the element to be returned.
     * @return The element present on the index. If the index is out of bound then returns
     *         {@link SearchInSortedArrayOfUnknownSize#ARRAY_READER_OUT_OF_BOUND}.
     */
    public int get(int index);
  }

  /**
   * Searches the target element on the array reader.
   *
   * @param reader The {@link ArrayReader}.
   * @param target The target element to search.
   * @return The index of the element if found. Otherwise returns -1.
   */
  public int search(final ArrayReader reader, final int target) {

    int start = 0, end = 0;

    while (reader.get(start) != ARRAY_READER_OUT_OF_BOUND && target >= reader.get(start)) {

      start = end;
      int length = end - start + 1;

      while (reader.get(end) != ARRAY_READER_OUT_OF_BOUND && target > reader.get(end)) {
        length = length * 2;
        end = length + start - 1;
      }

      if (reader.get(end) == ARRAY_READER_OUT_OF_BOUND) {
        length = length / 2;
        end = length + start - 1;
      }

      if (target >= reader.get(start) && target <= reader.get(end)) {
        return BinarySearch(reader, target, start, end);
      }

      // This condition is used to break the while loop when target > end of array
      if (start == end) {
        break;
      }
    }

    return -1;
  }

  /**
   * Performs a binary search for the element on the {@link ArrayReader}.
   *
   * @param reader The {@link ArrayReader}.
   * @param target The target element to search.
   * @param start The start index of the array.
   * @param end The end index of the array.
   * @return The index of the element if found. Otherwise returns -1.
   */
  private static int BinarySearch(final ArrayReader reader, final int target, final int start,
      final int end) {

    int tempStart = start, tempEnd = end;

    while (tempStart <= tempEnd) {
      final int mid = Math.floorDiv((tempStart + tempEnd), 2);

      if (target == reader.get(mid)) {
        return mid;
      }

      if (target < reader.get(mid)) {
        tempEnd = mid - 1;
      } else {
        tempStart = mid + 1;
      }
    }

    return -1;

  }
}
