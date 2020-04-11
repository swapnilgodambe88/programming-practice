package com.programming.practice.problems.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent run-length encoding of a string.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class RunLengthEncoding {

  public final List<Character> characters;
  public final List<Integer> counts;
  public final String inputString;

  /**
   * Public constructor for {@link RunLengthEncoding}.
   *
   * @param inputString The input string for which run length encoding needs to be performed.
   */
  public RunLengthEncoding(final String inputString) {
    this.characters = new ArrayList<>();
    this.counts = new ArrayList<>();
    this.inputString = inputString;

    int stringIndex = 0, count = 1;

    // Go till the second-last character
    while (stringIndex < inputString.length() - 1) {
      if (inputString.charAt(stringIndex) != inputString.charAt(stringIndex + 1)) {
        characters.add(inputString.charAt(stringIndex));
        counts.add(count);

        // Reset count = 1 for the next unique character
        count = 1;
      } else {
        ++count;
      }

      ++stringIndex;
    }

    // Add the last element
    if (inputString.length() > 0) {
      characters.add(inputString.charAt(stringIndex));
      counts.add(count);
    }
  }

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return "inputString: " + inputString + " | characters : " + characters + " | counts: " + counts;
  }
}
