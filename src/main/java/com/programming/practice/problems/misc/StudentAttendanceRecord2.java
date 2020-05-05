package com.programming.practice.problems.misc;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a positive integer n, return the number of all possible attendance records with length n,
 * which will be regarded as rewardable. The answer may be very large, return it after mod 10^9 + 7.
 *
 * <p>A student attendance record is a string that only contains the following three characters:
 *
 * <ol>
 *   <li>'A' : Absent.
 *   <li>'L' : Late.
 *   <li>'P' : Present.
 * </ol>
 *
 * A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than
 * two continuous 'L' (late).
 *
 * <pre>
 * Example 1:
 * Input: n = 2
 * Output: 8
 * Explanation:
 * There are 8 records with length 2 will be regarded as rewardable:
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * Only "AA" won't be regarded as rewardable owing to more than one absent times.
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/student-attendance-record-ii/">Student Attendance
 *     Record II</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @company Google
 */
public final class StudentAttendanceRecord2 {
  private static final char ABSENT = 'A';
  private static final char PRESENT = 'P';
  private static final char LATE = 'L';

  private final char[] remarks;

  private final Set<String> rewardableRecords;

  /** Constructor for {@link StudentAttendanceRecord2}. */
  public StudentAttendanceRecord2() {
    this.rewardableRecords = new HashSet<>();
    this.remarks = new char[] {ABSENT, PRESENT, LATE};
  }

  /**
   * Given a positive integer n, return the number of all possible attendance records with length n,
   * which will be regarded as rewardable.
   *
   * @param n The integer n.
   * @return Possible rewardable attendance records.
   */
  public int checkRecord(final int n) {
    createRecord("", 0, n);

    return rewardableRecords.size();
  }

  /**
   * Recursive function to create a rewardable record.
   *
   * @param recordFormedSoFar The record formed so far.
   * @param absentCount The absent count.
   * @param n The integer n
   */
  private void createRecord(final String recordFormedSoFar, final int absentCount, final int n) {
    if (recordFormedSoFar.length() == n) {
      rewardableRecords.add(recordFormedSoFar.toString());
      return;
    }

    for (final char remark : remarks) {
      switch (remark) {
        case ABSENT:
          if (absentCount == 0) {
            createRecord(recordFormedSoFar + ABSENT, absentCount + 1, n);
          }
          break;
        case PRESENT:
          createRecord(recordFormedSoFar + PRESENT, absentCount, n);
          break;
        case LATE:
        default:
          if (!areLastTwoLateRemarks(recordFormedSoFar)) {
            createRecord(recordFormedSoFar + LATE, absentCount, n);
          }
          break;
      }
    }
  }

  /**
   * @param record The record to evaluate.
   * @return True if last two remarks on the record are late. Otherwise false.
   */
  private static boolean areLastTwoLateRemarks(final String record) {
    final int length = record.length();
    if (length >= 2 && record.charAt(length - 1) == LATE && record.charAt(length - 2) == LATE) {
      return true;
    }

    return false;
  }
}
