package com.programming.practice.problems.array;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link SearchInSortedArrayOfUnknownSize}.
 *
 * @author Swapnil Godambe.<br>
 *         Copyright 2020.
 */
public final class SearchInSortedArrayOfUnknownSizeTest {

  /**
   * Implementation for {@link SearchInSortedArrayOfUnknownSize.ArrayReader}.
   */
  public class ArrayReaderImplementation implements SearchInSortedArrayOfUnknownSize.ArrayReader {

    private final int[] array;

    /**
     * Public constructor for {@link ArrayReaderImplementation}.
     *
     * @param array The array used for instantiation.
     */
    public ArrayReaderImplementation(final int[] array) {
      this.array = array;
    }

    @Override
    public int get(final int index) {
      if (index < array.length && index >= 0) {
        return array[index];
      }

      return SearchInSortedArrayOfUnknownSize.ARRAY_READER_OUT_OF_BOUND;
    }

    @Override
    public String toString() {
      return Arrays.toString(array);
    }

  }

  private final SearchInSortedArrayOfUnknownSize obj = new SearchInSortedArrayOfUnknownSize();

  @Test
  public void testScenario1() {
    final SearchInSortedArrayOfUnknownSize.ArrayReader reader =
        new ArrayReaderImplementation(new int[] {-1, 0, 3, 5, 9, 12});

    Assert.assertEquals(4, obj.search(reader, 9));
  }

  @Test
  public void testScenario2() {
    final SearchInSortedArrayOfUnknownSize.ArrayReader reader =
        new ArrayReaderImplementation(new int[] {-1, 0, 3, 5, 9, 12});

    Assert.assertEquals(5, obj.search(reader, 12));
  }

  @Test
  public void testScenario3() {
    final SearchInSortedArrayOfUnknownSize.ArrayReader reader =
        new ArrayReaderImplementation(new int[] {-1, 0, 3, 5, 9, 12});

    Assert.assertEquals(0, obj.search(reader, -1));
  }

  @Test
  public void testTargetDoesntExist_targetGreaterThanUpperBound() {
    final SearchInSortedArrayOfUnknownSize.ArrayReader reader =
        new ArrayReaderImplementation(new int[] {-1, 0, 3, 5, 9, 12});

    Assert.assertEquals(-1, obj.search(reader, 15));
  }

  @Test
  public void testTargetDoesntExist_targetLessThanLowerBound() {
    final SearchInSortedArrayOfUnknownSize.ArrayReader reader =
        new ArrayReaderImplementation(new int[] {-1, 0, 3, 5, 9, 12});

    Assert.assertEquals(-1, obj.search(reader, -20));
  }

  @Test
  public void testTargetDoesntExist_targetInbetweenLowerBoundAndUpperBound() {
    final SearchInSortedArrayOfUnknownSize.ArrayReader reader =
        new ArrayReaderImplementation(new int[] {-1, 0, 3, 5, 9, 12});

    Assert.assertEquals(-1, obj.search(reader, 6));
  }

}
