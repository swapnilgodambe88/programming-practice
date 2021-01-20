package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MedianFinder}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class MedianFinderTest {

  private final MedianFinder obj = new MedianFinder();
  private static final double DELTA = 0.0001;

  @Test
  public void testScenario1() {
    obj.addNum(1);
    obj.addNum(2);
    Assert.assertEquals(1.5, obj.findMedian(), DELTA);

    obj.addNum(3);
    Assert.assertEquals(2, obj.findMedian(), DELTA);
  }

  @Test
  public void testScenario2() {
    obj.addNum(6);
    Assert.assertEquals(6.0, obj.findMedian(), DELTA);
    obj.addNum(10);
    Assert.assertEquals(8.0, obj.findMedian(), DELTA);
    obj.addNum(2);
    Assert.assertEquals(6.0, obj.findMedian(), DELTA);
    obj.addNum(6);
    Assert.assertEquals(6.0, obj.findMedian(), DELTA);
    obj.addNum(5);
    Assert.assertEquals(6.0, obj.findMedian(), DELTA);
    obj.addNum(0);
    Assert.assertEquals(5.5, obj.findMedian(), DELTA);
    obj.addNum(6);
    Assert.assertEquals(6.0, obj.findMedian(), DELTA);
    obj.addNum(3);
    Assert.assertEquals(5.5, obj.findMedian(), DELTA);
    obj.addNum(1);
    Assert.assertEquals(5.0, obj.findMedian(), DELTA);
    obj.addNum(0);
    Assert.assertEquals(4, obj.findMedian(), DELTA);
    obj.addNum(0);
    Assert.assertEquals(3.0, obj.findMedian(), DELTA);
  }
}
