package com.programming.practice.problems.linkedlist;

import com.programming.practice.problems.linkedlist.util.ListNode;
import org.junit.Assert;
import org.junit.Test;

/** Unit tests for {@link IntersectionOfTwoLinkedList}. */
public class IntersectionOfTwoLinkedListTest {

  private final IntersectionOfTwoLinkedList obj = new IntersectionOfTwoLinkedList();

  @Test
  public void testScenario1() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {4, 3});
    final ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {5, 6, 1});
    final ListNode commonTrailingNodes = ListNode.convertArrayToLinkedList(new int[] {8, 4, 5});

    concatenateTwoLinkedLists(l1, commonTrailingNodes);
    concatenateTwoLinkedLists(l2, commonTrailingNodes);

    Assert.assertEquals(commonTrailingNodes, obj.getIntersectionNode(l1, l2));
  }

  @Test
  public void testScenario2() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 9, 1});
    final ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {3});
    final ListNode commonTrailingNodes = ListNode.convertArrayToLinkedList(new int[] {2, 4});

    concatenateTwoLinkedLists(l1, commonTrailingNodes);
    concatenateTwoLinkedLists(l2, commonTrailingNodes);

    Assert.assertEquals(commonTrailingNodes, obj.getIntersectionNode(l1, l2));
  }

  @Test
  public void testNoIntersectionEqualLengthList() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4});
    final ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {5, 6, 7, 8});

    Assert.assertEquals(null, obj.getIntersectionNode(l1, l2));
  }

  @Test
  public void testNoIntersectionUnEqualLengthList() {
    final ListNode l1 = ListNode.convertArrayToLinkedList(new int[] {1, 2, 3, 4, 5, 6, 7});
    final ListNode l2 = ListNode.convertArrayToLinkedList(new int[] {5, 6, 7, 8});

    Assert.assertEquals(null, obj.getIntersectionNode(l1, l2));
  }

  /**
   * @param head The head of the Linked list (must be non-null).
   * @return The last node on the Linked list.
   */
  private ListNode getLastNodeOfListList(final ListNode head) {
    assert head != null;
    ListNode current = head;
    while (current.next != null) {
      current = current.next;
    }

    return current;
  }

  /**
   * Concatenates the two linked list by joining tail of l1 to head of l2.
   *
   * @param l1 The head node of linked list 1.
   * @param l2 The head node of linked list 2.
   */
  private void concatenateTwoLinkedLists(final ListNode l1, final ListNode l2) {
    getLastNodeOfListList(l1).next = l2;
  }
}
