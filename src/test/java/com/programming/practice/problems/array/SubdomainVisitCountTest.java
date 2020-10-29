package com.programming.practice.problems.array;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SubdomainVisitCount}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SubdomainVisitCountTest {

  private final SubdomainVisitCount obj = new SubdomainVisitCount();

  @Test
  public void testScenario1() {
    final String[] cpdomains = new String[] {"9001 discuss.leetcode.com"};

    final List<String> expectedSubdomainVisits =
        Arrays.asList("9001 com", "9001 leetcode.com", "9001 discuss.leetcode.com");

    Assert.assertEquals(expectedSubdomainVisits, obj.subdomainVisits(cpdomains));
  }

  @Test
  public void testScenario2() {
    final String[] cpdomains =
        new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

    final List<String> expectedSubdomainVisits =
        Arrays.asList(
            "951 com",
            "900 google.mail.com",
            "1 intel.mail.com",
            "5 org",
            "5 wiki.org",
            "901 mail.com",
            "50 yahoo.com");

    Assert.assertEquals(expectedSubdomainVisits, obj.subdomainVisits(cpdomains));
  }
}
