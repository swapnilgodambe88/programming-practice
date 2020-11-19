package com.programming.practice.problems.misc;

/**
 * We have an array A of integers, and an array queries of queries.
 *
 * <p>For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index]. Then,
 * the answer to the i-th query is the sum of the even values of A.
 *
 * <p>(Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies
 * the array A.)
 *
 * <p>Return the answer to all queries. Your answer array should have answer[i] as the answer to the
 * i-th query.
 *
 * <pre>
 * Example 1:
 *
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * Output: [8,6,2,4]
 * Explanation:
 * At the beginning, the array is [1,2,3,4].
 * After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
 * After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
 * After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
 * After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/sum-of-even-numbers-after-queries/">Sum of Even
 *     Numbers After Queries</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class SumOfEvenNumbersAfterQueries {

  /**
   * Returns the answers to all the queries.
   *
   * @param A The array of integers.
   * @param queries The queries.
   * @return The answers to all the queries.
   */
  public int[] sumEvenAfterQueries(final int[] A, final int[][] queries) {

    int evenSum = 0;
    for (final int number : A) {
      evenSum += (number % 2 == 0) ? number : 0;
    }

    final int[] answer = new int[queries.length];
    for (int i = 0; i < queries.length; ++i) {
      final int value = queries[i][0];
      final int index = queries[i][1];

      // A[index] would change because of the query. So if it was even we need to subtract it since
      // it would no longer be valid after the query addition.
      if (A[index] % 2 == 0) {
        evenSum -= A[index];
      }

      A[index] += value;
      // If the new A[index] value after query addition is even, then add it to the evenSum list.
      if (A[index] % 2 == 0) {
        evenSum += A[index];
      }

      answer[i] = evenSum;
    }

    return answer;
  }
}
