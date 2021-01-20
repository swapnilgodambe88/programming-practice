package com.programming.practice.problems.misc;

/**
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the i-th job,
 * you have to finish all the jobs j where 0 <= j < i).
 *
 * <p>You have to finish at least one task every day. The difficulty of a job schedule is the sum of
 * difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a
 * job done in that day.
 *
 * <p>Given an array of integers jobDifficulty and an integer d. The difficulty of the i-th job is
 * jobDifficulty[i].
 *
 * <p>Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs
 * return -1.
 *
 * <pre>
 * Example 1:
 *
 * Input: jobDifficulty = [6,5,4,3,2,1], d = 2
 * Output: 7
 * Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
 * Second day you can finish the last job, total difficulty = 1.
 * The difficulty of the schedule = 6 + 1 = 7
 *
 * Example 2:
 *
 * Input: jobDifficulty = [9,9,9], d = 4
 * Output: -1
 * Explanation: If you finish a job per day you will still have a free day. you cannot find a schedule for the given jobs.
 *
 * Example 3:
 *
 * Input: jobDifficulty = [1,1,1], d = 3
 * Output: 3
 * Explanation: The schedule is one job per day. total difficulty will be 3.
 *
 * Example 4:
 *
 * Input: jobDifficulty = [7,1,7,1,7,1], d = 3
 * Output: 15
 *
 * Example 5:
 *
 * Input: jobDifficulty = [11,111,22,222,33,333,44,444], d = 6
 * Output: 843
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/">Minimum
 *     Difficulty of a job schedule</a>
 */
public class MinimumDifficultyOfAJobSchedule {

  /**
   * Finds the minimum difficulty of a schedule job.
   *
   * @param jobDifficulty The array representing the job difficulty.
   * @param d The number of days.
   * @return The minimum difficulty of a schedule job.
   */
  public int minDifficulty(final int[] jobDifficulty, final int d) {
    final int jobCount = jobDifficulty.length;

    if (jobCount < d) {
      return -1;
    }

    // Maintain a DP to keep track of the minimum difficulty.
    // dp[i][j] is the minimum difficulty to finish (j + 1) jobs in (i + 1) days since it is zero
    // index based.
    final int[][] dp = new int[d][jobCount];

    // minimum difficulty to finish 1 job in 1 day is the job1 complexity
    dp[0][0] = jobDifficulty[0];

    for (int i = 1; i < jobCount; ++i) {
      dp[0][i] = Math.max(jobDifficulty[i], dp[0][i - 1]);
    }

    for (int day = 1; day < d; ++day) {
      for (int job = day; job < jobCount; ++job) {
        int localMax = jobDifficulty[job];
        dp[day][job] = Integer.MAX_VALUE;

        for (int i = job; i >= day; --i) {
          localMax = Math.max(localMax, jobDifficulty[i]);
          dp[day][job] = Math.min(dp[day][job], dp[day - 1][i - 1] + localMax);
        }
      }
    }

    return dp[d - 1][jobCount - 1];
  }
}
