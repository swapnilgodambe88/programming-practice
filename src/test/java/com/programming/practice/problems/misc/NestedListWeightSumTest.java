package com.programming.practice.problems.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box test for {@link NestedListWeightSum}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public class NestedListWeightSumTest {
  private final NestedListWeightSum obj = new NestedListWeightSum();

  class NestedIntegerImpl implements NestedListWeightSum.NestedInteger {

    private Integer value;
    private List<NestedListWeightSum.NestedInteger> nestedIntegerList;

    public NestedIntegerImpl() {
      this.value = null;
      this.nestedIntegerList = null;
    }

    public NestedIntegerImpl(final int value) {
      this.value = value;
      this.nestedIntegerList = null;
    }

    public NestedIntegerImpl(final List<NestedListWeightSum.NestedInteger> nestedIntegerList) {
      this.value = null;
      this.nestedIntegerList = nestedIntegerList;
    }

    @Override
    public boolean isInteger() {
      return value != null;
    }

    @Override
    public Integer getInteger() {
      return value;
    }

    @Override
    public void setInteger(final int value) {
      this.value = value;
    }

    @Override
    public void add(final NestedListWeightSum.NestedInteger ni) {
      if (nestedIntegerList == null) {
        nestedIntegerList = new ArrayList<>();
      }

      nestedIntegerList.add(ni);
    }

    @Override
    public List<NestedListWeightSum.NestedInteger> getList() {
      return nestedIntegerList;
    }
  }

  @Test
  public void testScenario1() {
    final NestedListWeightSum.NestedInteger element1 = new NestedIntegerImpl(1);
    final NestedListWeightSum.NestedInteger element2 = new NestedIntegerImpl(1);
    final NestedListWeightSum.NestedInteger element12 =
        new NestedIntegerImpl(Arrays.asList(element1, element2));

    final NestedListWeightSum.NestedInteger elementInteger = new NestedIntegerImpl(2);

    final NestedListWeightSum.NestedInteger element3 = new NestedIntegerImpl(1);
    final NestedListWeightSum.NestedInteger element4 = new NestedIntegerImpl(1);
    final NestedListWeightSum.NestedInteger element34 =
        new NestedIntegerImpl(Arrays.asList(element3, element4));

    final List<NestedListWeightSum.NestedInteger> nestedList =
        Arrays.asList(element12, elementInteger, element34);

    Assert.assertEquals(10, obj.depthSum(nestedList));
  }

  @Test
  public void testScenario2() {
    final NestedListWeightSum.NestedInteger element1 = new NestedIntegerImpl(1);
    final NestedListWeightSum.NestedInteger element2 = new NestedIntegerImpl(4);
    final NestedListWeightSum.NestedInteger element3 = new NestedIntegerImpl(6);
    final NestedListWeightSum.NestedInteger element3Wrapped =
        new NestedIntegerImpl(Arrays.asList(element3));

    final NestedListWeightSum.NestedInteger element4 =
        new NestedIntegerImpl(Arrays.asList(element2, element3Wrapped));

    final List<NestedListWeightSum.NestedInteger> nestedList = Arrays.asList(element1, element4);

    Assert.assertEquals(27, obj.depthSum(nestedList));
  }
}
