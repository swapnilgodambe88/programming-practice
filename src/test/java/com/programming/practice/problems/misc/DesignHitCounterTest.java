package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link DesignHitCounter}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class DesignHitCounterTest {

  private final DesignHitCounter counter = new DesignHitCounter();

  @Test
  public void testScenario1() {

    Assert.assertEquals(0, counter.getHits(5));
    counter.hit(1);
    counter.hit(2);
    counter.hit(3);
    Assert.assertEquals(3, counter.getHits(4));

    counter.hit(300);
    Assert.assertEquals(4, counter.getHits(300));
    Assert.assertEquals(3, counter.getHits(301));
  }
}
