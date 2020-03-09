package com.programming.practice.interview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link TopNCompetitors}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class TopNCompetitorsTest {

  private final TopNCompetitors obj = new TopNCompetitors();

  @Test
  public void testScenario1() {
    final List<String> competitors = Arrays.asList("aaaa", "yyyy", "cccc", "bbbb", "dddd", "zzzz");

    final List<String> reviews = new ArrayList<>();

    reviews.add("The company cccc is good");
    reviews.add("The yyyy company yyyy is better");
    reviews.add("zzzz zzzz is nice");
    reviews.add("zzzz zzzz is better");
    reviews.add("zzzz zzzz is great");
    reviews.add("The company cccc is bad");
    reviews.add("The company bbbb is good");

    final List<String> expectedTopNCompetitors = Arrays.asList("zzzz", "cccc", "bbbb");

    Assert.assertEquals(expectedTopNCompetitors, obj.getTopNCompetitors(3, competitors, reviews));
  }

  @Test
  public void testScenarioNGreaterThanCompetitors() {
    final List<String> competitors = Arrays.asList("aaaa", "yyyy", "cccc", "bbbb", "dddd", "zzzz");

    final List<String> reviews = new ArrayList<>();

    reviews.add("The company cccc is good");
    reviews.add("The yyyy company yyyy is better");
    reviews.add("zzzz zzzz is nice");
    reviews.add("zzzz zzzz is better");
    reviews.add("zzzz zzzz is great");
    reviews.add("The company cccc is bad");
    reviews.add("The company bbbb is good");

    final List<String> expectedTopNCompetitors =
        Arrays.asList("zzzz", "cccc", "bbbb", "yyyy", "aaaa", "dddd");

    Assert.assertEquals(expectedTopNCompetitors, obj.getTopNCompetitors(10, competitors, reviews));
  }
}
