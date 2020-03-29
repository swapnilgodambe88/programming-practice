package com.programming.practice.problems.array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * <p>If you were only permitted to complete at most one transaction (i.e., buy one and sell one
 * share of the stock), design an algorithm to find the maximum profit.
 *
 * <p>Note that you cannot sell a stock before you buy one.
 *
 * <p>Example 1:
 *
 * <p>Input: [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price
 * = 6), profit = 6-1 = 5. Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * <p>Example 2:
 *
 * <p>Input: [7,6,4,3,1] Output: 0 Explanation: In this case, no transaction is done, i.e. max
 * profit = 0.
 *
 * @see <a href = "https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Best Time to Buy
 *     and Sell Stock</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BestTimeToBuySellStocks {

  /**
   * Finds the maximum profit by buying and selling the stock once.
   *
   * @param prices The price of stock on each day.
   * @return The maximum profit that can be earned by buying and selling stock.
   */
  public int maxProfit(final int[] prices) {

    final int count = prices.length;
    if (count == 0) {
      return 0;
    }

    // An array to keep track of the maximum value to the right of the index
    final int[] rightMax = new int[prices.length];

    rightMax[count - 1] = prices[count - 1];
    for (int i = prices.length - 2; i >= 0; --i) {
      if (prices[i] > rightMax[i + 1]) {
        rightMax[i] = prices[i];
      } else {
        rightMax[i] = rightMax[i + 1];
      }
    }

    int maxProfit = 0;
    for (int i = 0; i < count; ++i) {

      // This is the profit by buying the stock at ith day and selling it in the future with maximum
      // gain.
      final int profitAtIndexI = rightMax[i] - prices[i];
      if (profitAtIndexI > maxProfit) {
        maxProfit = profitAtIndexI;
      }
    }

    return maxProfit;
  }
}
