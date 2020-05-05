package com.programming.practice.problems.misc;

/**
 * You are given a string representing an attendance record for a student. The record only contains
 * the following three characters:
 *
 * <ol>
 *   <li>'A' : Absent.
 *   <li>'L' : Late.
 *   <li>'P' : Present.
 * </ol>
 *
 * A student could be * rewarded if his attendance record doesn't contain more than one 'A' (absent)
 * or more than two continuous 'L' (late).
 *
 * <p>You need to return whether the student could be rewarded according to his attendance record.
 *
 * <pre>
 *
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 * Example 2:
 * Input: "PPALLL"
 * Output: False
 * </pre>
 *
 * @see <a href = "https://leetcode.com/problems/student-attendance-record-i/">Student Attendance
 *     Record I</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class StudentAttendanceRecord {
  private static final char ABSENT = 'A';

  /**
   * Evaluates whether the student could be rewarding according to this attendance record.
   *
   * @param record The record string
   * @return True If the record is rewarding. Otherwise, false.
   */
  public boolean checkRecord(final String record) {
    if (record.contains("LLL")) {
      return false;
    }

    int absentCount = 0;
    for (final char character : record.toCharArray()) {
      if (character == ABSENT) {
        ++absentCount;
      }

      if (absentCount > 1) {
        return false;
      }
    }

    return true;
  }
}
