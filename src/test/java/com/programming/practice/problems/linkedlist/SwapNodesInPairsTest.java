package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;
import org.junit.Test;

/**
 * White box tests for {@link SwapNodesInPairs}.
 *
 * @author Swapnil Godambe. Copyright 2020.
 */
public final class SwapNodesInPairsTest {

  private final SwapNodesInPairs obj = new SwapNodesInPairs();

  @Test
  public void testValidScenario1() {
    ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5, 6});

    ListNode expected = ListNode.convertArrayToLinkedList(new int[] {2, 1, 4, 3, 6, 5});
    // Assert.assertEquals("Assertion failed", expected, obj.swapPairs(l1));
  }
}
