package com.programming.practice.problems.array;

import java.util.Map;
import java.util.TreeMap;

/**
 * Implement a SnapshotArray that supports the following interface:
 *
 * <ul>
 * <li>SnapshotArray(int length) initializes an array-like data structure with the given length.
 * Initially, each element equals 0.
 * <li>void set(index, val) sets the element at the given index to be equal to val.
 * <li>int snap() takes a snapshot of the array and returns the snap_id: the total number of times
 * we called snap() minus 1.
 * <li>int get(index, snap_id) returns the value at the given index, at the time we took the
 * snapshot with the given snap_id
 * </ul>
 *
 * <pre>
 * Example 1:
 *
 * Input: ["SnapshotArray","set","snap","set","get"]
 * [[3],[0,5],[],[0,6],[0,0]]
 * Output: [null,null,0,null,5]
 * Explanation:
 * SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
 * snapshotArr.set(0,5);  // Set array[0] = 5
 * snapshotArr.snap();  // Take a snapshot, return snap_id = 0
 * snapshotArr.set(0,6);
 * snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/snapshot-array/">Snapshot Array</a>
 * @author Swapnil Godambe.<br>
 *         Copyright 2020.
 * @company Google
 */
public final class SnapshotArray {

  /** Represents a value at a given snapshot. */
  private class ValueSnapshot {

    // A tree map to store the value keyed by the snapId. TreeMap implementation is used to store
    // the keys in increasing order of snapId.
    private final TreeMap<Integer, Integer> valueKeyedBySnapId;

    /** Constructor for {@link ValueSnapshot}. */
    public ValueSnapshot() {
      this.valueKeyedBySnapId = new TreeMap<>();
    }

    /**
     * Sets the value for a given snapId.
     *
     * @param value The value to set.
     * @param snapId The snapId associated with the value.
     */
    public void set(final int value, final int snapId) {
      valueKeyedBySnapId.put(snapId, value);
    }

    /**
     * Returns the value for a given snapId.
     *
     * @param snapId The snapId.
     * @return The value for the provided snapId.
     */
    public int get(final int snapId) {
      if (valueKeyedBySnapId.containsKey(snapId)) {
        return valueKeyedBySnapId.get(snapId);
      }

      // If snapId is not present that means we need to grab the snapId lower than the provided
      // snapId.
      // This essentially means that the value remained same from the floor snapId.
      final Map.Entry<Integer, Integer> entry = valueKeyedBySnapId.floorEntry(snapId);
      if (entry != null) {
        return entry.getValue();
      }

      // This means the value was never initialized.
      return 0;
    }
  }

  /** Keeps track of the current snap_id. */
  private int currentSnapId;

  private final ValueSnapshot[] valueSnapshotArray;

  /**
   * Constructor for {@link SnapArray}.
   *
   * @param length The length of the array.
   */
  public SnapshotArray(final int length) {
    this.currentSnapId = 0;
    this.valueSnapshotArray = new ValueSnapshot[length];

    for (int i = 0; i < valueSnapshotArray.length; ++i) {
      valueSnapshotArray[i] = new ValueSnapshot();
    }
  }

  /**
   * Set the value for the index at the current snapId.
   *
   * @param index The index.
   * @param val The value to set for the index.
   */
  public void set(final int index, final int val) {
    valueSnapshotArray[index].set(val, currentSnapId);
  }

  /**
   * Creates a snapshot of the current array.
   *
   * @return Returns the current snapId.
   */
  public int snap() {
    return currentSnapId++;
  }

  /**
   * Gets the value of the index at the provided snapId.
   *
   * @param index The index of the array.
   * @param snapId The snapId of the array.
   * @return The value of the index at the provided snapId.
   */
  public int get(final int index, final int snapId) {
    return valueSnapshotArray[index].get(snapId);
  }
}
