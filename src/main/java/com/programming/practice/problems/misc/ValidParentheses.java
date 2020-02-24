package com.programming.practice.problems.misc;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 *
 * <p>An input string is valid if:
 *
 * <p>Open brackets must be closed by the same type of brackets. Open brackets must be closed in the
 * correct order. Note that an empty string is also considered valid.
 *
 * <p>Example 1:
 *
 * <p>Input: "()" Output: true
 *
 * <p>Example 2:
 *
 * <p>Input: "()[]{}" Output: true
 *
 * <p>Example 3:
 *
 * <p>Input: "(]" Output: false
 *
 * <p>Example 4:
 *
 * <p>Input: "([)]" Output: false
 *
 * <p>Example 5:
 *
 * <p>Input: "{[]}" Output: true
 *
 * @see <a href = "https://leetcode.com/problems/valid-parentheses/">Valid Parentheses</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class ValidParentheses {

  /**
   * @param character The character to evaluate.
   * @return True If the character is opening character. otherwise false.
   */
  private boolean isOpeningParenthesis(final char character) {
    if (character == '(' || character == '[' || character == '{') {
      return true;
    }
    return false;
  }

  /**
   * @param character The character to evaluate.
   * @return True If the character is opening character. otherwise false.
   */
  private boolean isClosingParenthesis(final char character) {
    if (character == ')' || character == ']' || character == '}') {
      return true;
    }
    return false;
  }

  /**
   * Given a closing character returns the corresponding opening character.
   *
   * @param closingCharacter The closing character.
   * @return The equivalent closing character. If none found returns space character.
   */
  private char getEquivalentOpeningCharacter(final char closingCharacter) {
    if (closingCharacter == ')') {
      return '(';
    } else if (closingCharacter == ']') {
      return '[';
    } else if (closingCharacter == '}') {
      return '{';
    }

    return ' ';
  }

  /**
   * @param inputString The input string to validate
   * @return True if the input string is valid. Otherwise false.
   */
  public boolean isValid(final String inputString) {

    final Stack<Character> characterStack = new Stack<>();

    for (final char character : inputString.toCharArray()) {
      if (isOpeningParenthesis(character)) {
        characterStack.push(character);
      } else if (isClosingParenthesis(character)
          && !characterStack.isEmpty()
          && characterStack.peek() == getEquivalentOpeningCharacter(character)) {
        characterStack.pop();
      } else {
        // This represents invalid sequence of characters hence will return false.
        return false;
      }
    }

    // The stack needs to be empty for the inputString to be valid
    return characterStack.isEmpty();
  }
}
