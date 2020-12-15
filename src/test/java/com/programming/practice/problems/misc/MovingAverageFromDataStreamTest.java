/** */
package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link MovingAverageFromDataStream}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class MovingAverageFromDataStreamTest {

  private static final double DELTA = 0.0001;

  @Test
  public void testScenario1() {
    final MovingAverageFromDataStream obj = new MovingAverageFromDataStream(3);

    Assert.assertEquals(1, obj.next(1), DELTA);
    Assert.assertEquals(5.5, obj.next(10), DELTA);
    Assert.assertEquals(4.6666, obj.next(3), DELTA);
    Assert.assertEquals(6, obj.next(5), DELTA);
  }
}
