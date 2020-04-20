package com.programming.practice.problems.misc;

import java.util.Objects;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SurroundedRegions}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class SurroundedRegionsTest {

  private final SurroundedRegions obj = new SurroundedRegions();

  @Test
  public void testScenario1() {
    final char[][] board =
        new char[][] {
          {'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}
        };
    final char[][] expectedCapturedBoard =
        new char[][] {
          {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}
        };

    obj.solve(board);

    Assert.assertArrayEquals(expectedCapturedBoard, board);
  }

  @Test
  public void testPositionToString() {
    final SurroundedRegions.Position position = (new SurroundedRegions()).new Position(1, -2);
    final String expectedToString = "(1, -2)";

    Assert.assertEquals(expectedToString, position.toString());
  }

  @Test
  public void testPositionHashCode() {
    final SurroundedRegions.Position position = (new SurroundedRegions()).new Position(1, -2);
    final int expectedHashCode = Objects.hash(position.x, position.y);

    Assert.assertEquals(expectedHashCode, position.hashCode());
  }

  @Test
  public void testPositionEqualsSameObject() {
    final SurroundedRegions.Position position = (new SurroundedRegions()).new Position(1, -2);
    Assert.assertTrue(position.equals(position));
  }

  @Test
  public void testPositionEqualsSimilarObject() {
    final SurroundedRegions.Position position1 = (new SurroundedRegions()).new Position(1, -2);
    final SurroundedRegions.Position position2 = (new SurroundedRegions()).new Position(1, -2);

    Assert.assertTrue(position1.equals(position2));
  }

  @SuppressWarnings("unlikely-arg-type")
  @Test
  public void testPositionEqualsNotSimilarObject() {
    final SurroundedRegions.Position position1 = (new SurroundedRegions()).new Position(1, -2);
    final String position2 = "position2";

    Assert.assertFalse(position1.equals(position2));
  }

  @Test
  public void testPositionEqualsDifferentXValue() {
    final SurroundedRegions.Position position1 = (new SurroundedRegions()).new Position(1, -2);
    final SurroundedRegions.Position position2 = (new SurroundedRegions()).new Position(12, -2);

    Assert.assertFalse(position1.equals(position2));
  }

  @Test
  public void testPositionEqualsDifferentYValue() {
    final SurroundedRegions.Position position1 = (new SurroundedRegions()).new Position(1, -2);
    final SurroundedRegions.Position position2 = (new SurroundedRegions()).new Position(1, 2);

    Assert.assertFalse(position1.equals(position2));
  }
}
