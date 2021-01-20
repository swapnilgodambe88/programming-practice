package com.programming.practice.problems.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two sparse vectors, compute their dot product.
 *
 * <p>Implement class SparseVector:
 *
 * <ul>
 *   <li>SparseVector(nums) Initializes the object with the vector nums
 *   <li>dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
 * </ul>
 *
 * A sparse vector is a vector that has mostly zero values, you should store the sparse vector
 * efficiently and compute the dot product between two SparseVector.
 *
 * <p>Follow up: What if only one of the vectors is sparse?
 *
 * <pre>
 * Example 1:
 *
 * Input: nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
 * Output: 8
 * Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
 * v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8
 * Example 2:
 *
 * Input: nums1 = [0,1,0,0,0], nums2 = [0,0,0,0,2]
 * Output: 0
 * Explanation: v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
 * v1.dotProduct(v2) = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0
 * Example 3:
 *
 * Input: nums1 = [0,1,0,0,2,0,0], nums2 = [1,0,0,0,3,0,4]
 * Output: 6
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/dot-product-of-two-sparse-vectors/">Dot Product of
 *     Two Sparse Vectors</a>
 */
public final class SparseVector {

  /**
   * A map used to store non-zero elements of the vector where key=index and value=value of the
   * element at that index
   */
  public final Map<Integer, Integer> nonZeroIndexValueMap;

  /**
   * Constructor for {@link SparseVector}.
   *
   * @param nums The nums array.
   */
  public SparseVector(final int[] nums) {
    this.nonZeroIndexValueMap = new HashMap<>();

    populateNonZeroIndexValueMap(nums);
  }

  /**
   * Populates the {@link SparseVector#nonZeroIndexValueMap}.
   *
   * @param nums The nums array.
   */
  private void populateNonZeroIndexValueMap(final int[] nums) {

    // Adds non-zero elements to the map.
    for (int index = 0; index < nums.length; ++index) {
      if (nums[index] != 0) {
        nonZeroIndexValueMap.put(index, nums[index]);
      }
    }
  }

  /**
   * Returns the dot product.
   *
   * @param vec The SparseVector.
   * @return The dot product
   */
  public int dotProduct(final SparseVector vec) {
    int dotProduct = 0;

    // We would need to consider the map with the smallest size and then evaluate it's element
    // against the other map.
    // If the condition is not true, then we call the dotProduct method of the other SparseVector to
    // flip the match.
    if (vec.nonZeroIndexValueMap.size() < this.nonZeroIndexValueMap.size()) {
      return vec.dotProduct(this);
    }

    for (final Map.Entry<Integer, Integer> entry : this.nonZeroIndexValueMap.entrySet()) {
      if (vec.nonZeroIndexValueMap.containsKey(entry.getKey())) {
        dotProduct += vec.nonZeroIndexValueMap.get(entry.getKey()) * entry.getValue();
      }
    }

    return dotProduct;
  }
}
