package com.programming.practice.problems.string;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link TextJustification}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class TextJustificationTest {

  private final TextJustification obj = new TextJustification();

  @Test
  public void testScenario1() {
    final String[] words =
        new String[] {"This", "is", "an", "example", "of", "text", "justification."};

    final int maxWidth = 16;

    final List<String> expectedJustifiedSentence =
        Arrays.asList("This    is    an", "example  of text", "justification.  ");
    Assert.assertEquals(expectedJustifiedSentence, obj.fullJustify(words, maxWidth));
  }

  @Test
  public void testScenario2() {
    final String[] words =
        new String[] {
          "Science",
          "is",
          "what",
          "we",
          "understand",
          "well",
          "enough",
          "to",
          "explain",
          "to",
          "a",
          "computer.",
          "Art",
          "is",
          "everything",
          "else",
          "we",
          "do"
        };

    final int maxWidth = 20;

    final List<String> expectedJustifiedSentence =
        Arrays.asList(
            "Science  is  what we",
            "understand      well",
            "enough to explain to",
            "a  computer.  Art is",
            "everything  else  we",
            "do                  ");

    Assert.assertEquals(expectedJustifiedSentence, obj.fullJustify(words, maxWidth));
  }
}
