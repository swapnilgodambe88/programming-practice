package com.programming.practice.problems.misc;

import java.util.List;
import java.util.Stack;

/**
 * On a single-threaded CPU, we execute a program containing n functions. Each function has a unique
 * ID between 0 and n-1.
 *
 * <p>Function calls are stored in a call stack: when a function call starts, its ID is pushed onto
 * the stack, and when a function call ends, its ID is popped off the stack. The function whose ID
 * is at the top of the stack is the current function being executed. Each time a function starts or
 * ends, we write a log with the ID, whether it started or ended, and the timestamp.
 *
 * <p>You are given a list logs, where logs[i] represents the ith log message formatted as a string
 * "{function_id}:{"start" | "end"}:{timestamp}". For example, "0:start:3" means a function call
 * with function ID 0 started at the beginning of timestamp 3, and "1:end:2" means a function call
 * with function ID 1 ended at the end of timestamp 2. Note that a function can be called multiple
 * times, possibly recursively.
 *
 * <p>A function's exclusive time is the sum of execution times for all function calls in the
 * program. For example, if a function is called twice, one call executing for 2 time units and
 * another call executing for 1 time unit, the exclusive time is 2 + 1 = 3.
 *
 * <p>Return the exclusive time of each function in an array, where the value at the ith index
 * represents the exclusive time for the function with ID i.
 *
 * <pre>
 * Example 1:
 *
 * Input: n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
 * Output: [3,4]
 * Explanation:
 * Function 0 starts at the beginning of time 0, then it executes 2 for units of time and reaches the end of time 1.
 * Function 1 starts at the beginning of time 2, executes for 4 units of time, and ends at the end of time 5.
 * Function 0 resumes execution at the beginning of time 6 and executes for 1 unit of time.
 * So function 0 spends 2 + 1 = 3 units of total time executing, and function 1 spends 4 units of total time executing.
 *
 * Example 2:
 *
 * Input: n = 1, logs = ["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
 * Output: [8]
 * Explanation:
 * Function 0 starts at the beginning of time 0, executes for 2 units of time, and recursively calls itself.
 * Function 0 (recursive call) starts at the beginning of time 2 and executes for 4 units of time.
 * Function 0 (initial call) resumes execution then immediately calls itself again.
 * Function 0 (2nd recursive call) starts at the beginning of time 6 and executes for 1 unit of time.
 * Function 0 (initial call) resumes execution at the beginning of time 7 and executes for 1 unit of time.
 * So function 0 spends 2 + 4 + 1 + 1 = 8 units of total time executing.
 *
 * Example 3:
 *
 * Input: n = 2, logs = ["0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"]
 * Output: [7,1]
 * Explanation:
 * Function 0 starts at the beginning of time 0, executes for 2 units of time, and recursively calls itself.
 * Function 0 (recursive call) starts at the beginning of time 2 and executes for 4 units of time.
 * Function 0 (initial call) resumes execution then immediately calls function 1.
 * Function 1 starts at the beginning of time 6, executes 1 units of time, and ends at the end of time 6.
 * Function 0 resumes execution at the beginning of time 6 and executes for 2 units of time.
 * So function 0 spends 2 + 4 + 1 = 7 units of total time executing, and function 1 spends 1 unit of total time executing.
 *
 * Example 4:
 *
 * Input: n = 2, logs = ["0:start:0","0:start:2","0:end:5","1:start:7","1:end:7","0:end:8"]
 * Output: [8,1]
 *
 * Example 5:
 *
 * Input: n = 1, logs = ["0:start:0","0:end:0"]
 * Output: [1]
 * </pre>
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 * @see <a href = "https://leetcode.com/problems/exclusive-time-of-functions/">Exclusive Time of
 *     Functions</a>
 */
public class ExclusiveTimeOfFunctions {

  /**
   * Returns the exclusive time of each function in an array.
   *
   * @param n The number of processes
   * @param logs The logs
   * @return The exclusive time of each function in an array.
   */
  public int[] exclusiveTime(final int n, final List<String> logs) {

    final int[] result = new int[n];

    // A stack to store the processId of processes that have started (but not ended)
    final Stack<Integer> processIdStack = new Stack<>();

    // A stack to store the start time stamp of the processes that have started (but not ended)
    final Stack<Integer> timestampStack = new Stack<>();

    for (final String log : logs) {
      final String[] splitString = log.split(":");

      final int processId = Integer.parseInt(splitString[0]);
      final int timestamp = Integer.parseInt(splitString[2]);
      final String startOrEnd = splitString[1];

      if (startOrEnd.equals("start")) {
        // Is this is start of new process then add the exclusive time to the previous process on
        // stack.
        // timeToAddOnPreviousProcess = startOfNewProcess - startOfPreviousProcess
        if (!processIdStack.isEmpty()) {
          result[processIdStack.peek()] += timestamp - timestampStack.peek();
        }

        processIdStack.push(processId);
        timestampStack.push(timestamp);
      } else {
        // timeToAddToCurrentProcess = endOfCurrentProcess - startOfCurrentProcess + 1
        result[processIdStack.peek()] += timestamp - timestampStack.peek() + 1;
        processIdStack.pop();
        timestampStack.pop();

        // If process is present on stack then change the start of that process to current + 1
        if (!timestampStack.isEmpty()) {
          timestampStack.pop();
          timestampStack.push(timestamp + 1);
        }
      }
    }
    return result;
  }
}
