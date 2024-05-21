package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * White box tests for {@link BaseballGame}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class BaseballGameTest {
  private final BaseballGame obj = new BaseballGame();

  @Test
  public void testScenario1() {
    final String[] ops = new String[] {"5", "2", "C", "D", "+"};
    Assert.assertEquals(30, obj.calPoints(ops));
  }

  @Test
  public void testScenario2() {
    final String[] ops = new String[] {"5", "-2", "4", "C", "D", "9", "+", "+"};
    Assert.assertEquals(27, obj.calPoints(ops));
  }

  @Test
  public void testScenario3() {
    final String[] ops = new String[] {"1"};
    Assert.assertEquals(1, obj.calPoints(ops));
  }

  @Test
  public void testing() {
    final Map<String, Integer> map = new HashMap<>();
    map.put("A", 123);
    map.put("Z", 567);
    map.put("B", 234234);
    map.put("PP", 234234);
    map.put("ABC", 234234);

    final List<Map.Entry<String, Integer>> mapList = new ArrayList<>(map.entrySet());

    System.out.println(mapList);
    mapList.sort((o1, o2) -> o1.getKey().compareTo(o2.getKey()));

    System.out.println(mapList);


  }
}
