package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link UndergroundSystem}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2021.
 */
public class UndergroundSystemTest {

  private static final double DELTA = 0.00001;

  @Test
  public void testScenario() {
    final UndergroundSystem obj = new UndergroundSystem();

    obj.checkIn(45, "Leyton", 3);
    obj.checkIn(32, "Paradise", 8);
    obj.checkIn(27, "Leyton", 10);
    obj.checkOut(45, "Waterloo", 15);
    obj.checkOut(27, "Waterloo", 20);
    obj.checkOut(32, "Cambridge", 22);
    Assert.assertEquals(14.00000, obj.getAverageTime("Paradise", "Cambridge"), DELTA);
    Assert.assertEquals(11.00000, obj.getAverageTime("Leyton", "Waterloo"), DELTA);
    obj.checkIn(10, "Leyton", 24);
    Assert.assertEquals(11.00000, obj.getAverageTime("Leyton", "Waterloo"), DELTA);
    obj.checkOut(10, "Waterloo", 38);
    Assert.assertEquals(12.00000, obj.getAverageTime("Leyton", "Waterloo"), DELTA);
  }
}
