package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link StudentAttendanceRecord2}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class StudentAttendanceRecord2Test {

  private final StudentAttendanceRecord2 obj = new StudentAttendanceRecord2();

  @Test
  public void testN1() {
    Assert.assertEquals(3, obj.checkRecord(1));
  }

  @Test
  public void testN2() {
    Assert.assertEquals(8, obj.checkRecord(2));
  }

  @Test
  public void testN3() {
    Assert.assertEquals(19, obj.checkRecord(3));
  }
}
