package com.programming.practice.problems.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link com.programming.practice.problems.string.DefangIpAddress}.
 *
 * @author Swapnil Godambe. Copyright 2020.
 */
public final class DefangIpAddressTest {

  @Test
  public void testSingleDigitIPAddress() {
    final String address = "1.1.1.1";

    final DefangIpAddress obj = new DefangIpAddress();

    Assert.assertEquals("1[.]1[.]1[.]1", obj.defangIPaddr(address));
  }

  @Test
  public void testMixedDigitIPAddress() {
    final String address = "255.100.50.0";

    final DefangIpAddress obj = new DefangIpAddress();

    Assert.assertEquals("255[.]100[.]50[.]0", obj.defangIPaddr(address));
  }
}
