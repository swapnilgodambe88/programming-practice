package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/** Unit tests for {@link ExcelSheetColumnTitle}. */
public class ExcelSheetColumnTitleTest {

  private final ExcelSheetColumnTitle obj = new ExcelSheetColumnTitle();

  @Test
  public void testColumn2() {
    Assert.assertEquals("B", obj.convertToTitle(2));
  }

  @Test
  public void testColuumn701() {
    Assert.assertEquals("ZY", obj.convertToTitle(701));
  }

  @Test
  public void testColuumn28() {
    Assert.assertEquals("AB", obj.convertToTitle(28));
  }
}
