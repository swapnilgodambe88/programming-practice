package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link BestTimeToBuySellStocks}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class BestTimeToBuySellStocksTest {

  private final BestTimeToBuySellStocks obj = new BestTimeToBuySellStocks();

  @Test
  public void testEmptyPricesList() {
    final int prices[] = new int[] {};

    Assert.assertEquals(0, obj.maxProfit(prices));
  }

  @Test
  public void testScenario1() {
    final int prices[] = new int[] {7, 1, 5, 3, 6, 4};

    Assert.assertEquals(5, obj.maxProfit(prices));
  }

  @Test
  public void testScenario2() {
    final int prices[] = new int[] {7, 6, 4, 3, 1};

    Assert.assertEquals(0, obj.maxProfit(prices));
  }
}
