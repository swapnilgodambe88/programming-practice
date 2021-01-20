package com.programming.practice.problems.misc;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link LeftMostColumn}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class LeftMostColumnTest {

  private final LeftMostColumn obj = new LeftMostColumn();

  /** Implementation of {@link LeftMostColumn.BinaryMatrix}. */
  private final class BinaryMatrixImpl implements LeftMostColumn.BinaryMatrix {

    private final int[][] matrix;
    private final int rowCount;
    private final int colCount;

    /**
     * Constructor for {@link BinaryMatrixImpl}.
     *
     * @param matrix The 2D matrix.
     */
    BinaryMatrixImpl(final int[][] matrix) {
      this.matrix = matrix;
      this.rowCount = matrix.length;
      this.colCount = this.rowCount > 0 ? this.matrix[0].length : 0;
    }

    /** {@inheritDoc} */
    @Override
    public int get(final int row, final int col) {
      return this.matrix[row][col];
    }

    /** {@inheritDoc} */
    @Override
    public List<Integer> dimensions() {
      return Arrays.asList(rowCount, colCount);
    }
  }

  @Test
  public void testScenario1() {
    final int[][] matrix = new int[][] {{0, 0}, {1, 1}};
    final LeftMostColumn.BinaryMatrix binaryMatrix = new BinaryMatrixImpl(matrix);

    Assert.assertEquals(0, obj.leftMostColumnWithOne(binaryMatrix));
  }

  @Test
  public void testScenario2() {
    final int[][] matrix = new int[][] {{0, 0}, {0, 1}};
    final LeftMostColumn.BinaryMatrix binaryMatrix = new BinaryMatrixImpl(matrix);

    Assert.assertEquals(1, obj.leftMostColumnWithOne(binaryMatrix));
  }

  @Test
  public void testScenario3() {
    final int[][] matrix = new int[][] {{0, 0}, {0, 0}};
    final LeftMostColumn.BinaryMatrix binaryMatrix = new BinaryMatrixImpl(matrix);

    Assert.assertEquals(-1, obj.leftMostColumnWithOne(binaryMatrix));
  }

  @Test
  public void testScenario4() {
    final int[][] matrix = new int[][] {{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 1}};
    final LeftMostColumn.BinaryMatrix binaryMatrix = new BinaryMatrixImpl(matrix);

    Assert.assertEquals(1, obj.leftMostColumnWithOne(binaryMatrix));
  }
}
