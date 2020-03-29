package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link BestTimeToBuySellStocks2}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BestTimeToBuySellStocks2Test {

  private final BestTimeToBuySellStocks2 obj = new BestTimeToBuySellStocks2();

  @Test
  public void testScenario1() {
    final int[] prices = new int[] {7, 1, 5, 3, 6, 4};

    Assert.assertEquals(7, obj.maxProfit(prices));
  }

  @Test
  public void testScenario2() {
    final int[] prices = new int[] {1, 2, 3, 4, 5};

    Assert.assertEquals(4, obj.maxProfit(prices));
  }

  @Test
  public void testNoProfit() {
    final int[] prices = new int[] {5, 4, 3, 2, 1};

    Assert.assertEquals(0, obj.maxProfit(prices));
  }
}
