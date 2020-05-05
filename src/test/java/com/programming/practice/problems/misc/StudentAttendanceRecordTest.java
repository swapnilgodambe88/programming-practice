package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link StudentAttendanceRecord}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class StudentAttendanceRecordTest {

  private final StudentAttendanceRecord obj = new StudentAttendanceRecord();

  @Test
  public void testRewardableRecord() {
    Assert.assertTrue(obj.checkRecord("PPALLP"));
  }

  @Test
  public void testRecordContaining3ConsecutiveLateRemarks() {
    Assert.assertFalse(obj.checkRecord("PPPPLLL"));
  }

  @Test
  public void testRecordContaining2AbsentRemarks() {
    Assert.assertFalse(obj.checkRecord("PALALP"));
  }
}
