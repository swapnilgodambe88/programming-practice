package com.programming.practice.problems.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SnapshotArray}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SnapshotArrayTest {

  @Test
  public void testScenario1() {
    final SnapshotArray obj = new SnapshotArray(4);

    Assert.assertEquals(0, obj.snap());
    Assert.assertEquals(1, obj.snap());

    Assert.assertEquals(0, obj.get(3, 1));

    obj.set(2, 4);
    Assert.assertEquals(2, obj.snap());

    obj.set(1, 4);
  }

  @Test
  public void testScenario2() {
    final SnapshotArray obj = new SnapshotArray(1);

    obj.set(0, 15);
    Assert.assertEquals(0, obj.snap());
    Assert.assertEquals(1, obj.snap());
    Assert.assertEquals(2, obj.snap());

    Assert.assertEquals(15, obj.get(0, 2));

    Assert.assertEquals(3, obj.snap());
    Assert.assertEquals(4, obj.snap());

    Assert.assertEquals(15, obj.get(0, 0));
  }

  @Test
  public void testScenario3() {
    final SnapshotArray obj = new SnapshotArray(3);

    obj.set(0, 5);
    Assert.assertEquals(0, obj.snap());
    Assert.assertEquals(1, obj.snap());
    Assert.assertEquals(2, obj.snap());

    Assert.assertEquals(5, obj.get(0, 2));

    Assert.assertEquals(3, obj.snap());
    Assert.assertEquals(4, obj.snap());

    Assert.assertEquals(5, obj.get(0, 0));
  }

  @Test
  public void testScenario4() {
    final SnapshotArray obj = new SnapshotArray(2);

    Assert.assertEquals(0, obj.snap());
    Assert.assertEquals(0, obj.get(1, 0));
    Assert.assertEquals(0, obj.get(0, 0));

    obj.set(1, 8);

    Assert.assertEquals(0, obj.get(1, 0));

    obj.set(0, 20);

    Assert.assertEquals(0, obj.get(0, 0));
    obj.set(0, 7);
  }

  @Test
  public void testScenario5() {
    final SnapshotArray obj = new SnapshotArray(3);

    obj.set(1, 18);
    obj.set(1, 4);

    Assert.assertEquals(0, obj.snap());
    Assert.assertEquals(0, obj.get(0, 0));
    obj.set(0, 20);

    Assert.assertEquals(0, obj.get(0, 0));
    Assert.assertEquals(1, obj.snap());

    obj.set(0, 2);
    obj.set(1, 1);
    Assert.assertEquals(4, obj.get(1, 1));
    Assert.assertEquals(4, obj.get(1, 0));
  }

  @Test
  public void testScenario6() {
    final SnapshotArray obj = new SnapshotArray(1);

    obj.set(0, 10);
    Assert.assertEquals(0, obj.snap());
    obj.set(0, 2);
    obj.set(0, 5);
    Assert.assertEquals(10, obj.get(0, 0));
    Assert.assertEquals(1, obj.snap());
    obj.set(0, 18);
    obj.set(0, 6);
    Assert.assertEquals(2, obj.snap());
    Assert.assertEquals(3, obj.snap());
    Assert.assertEquals(4, obj.snap());
    Assert.assertEquals(5, obj.snap());
    Assert.assertEquals(6, obj.snap());
    Assert.assertEquals(6, obj.get(0, 2));

    obj.set(0, 11);
    obj.set(0, 7);
    Assert.assertEquals(6, obj.get(0, 3));
    Assert.assertEquals(7, obj.snap());
  }

  @Test
  public void testScenario7() {
    final SnapshotArray obj = new SnapshotArray(2);

    obj.set(1, 16);
    Assert.assertEquals(0, obj.snap());
    Assert.assertEquals(1, obj.snap());
    obj.set(0, 13);
    Assert.assertEquals(2, obj.snap());
    Assert.assertEquals(13, obj.get(0, 2));
    obj.set(1, 10);
    Assert.assertEquals(0, obj.get(0, 1));
    Assert.assertEquals(3, obj.snap());
    Assert.assertEquals(0, obj.get(0, 0));
    obj.set(1, 20);
    Assert.assertEquals(4, obj.snap());

    obj.set(1, 15);
    Assert.assertEquals(16, obj.get(1, 1));
    Assert.assertEquals(16, obj.get(1, 1));

    obj.set(0, 3);
    obj.set(1, 4);
    Assert.assertEquals(5, obj.snap());
    Assert.assertEquals(6, obj.snap());
  }
}
