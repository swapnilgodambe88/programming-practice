package com.programming.practice.problems.string;

/**
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.
 *
 * <p>A defanged IP address replaces every period "." with "[.]".
 *
 * <p>Example 1:
 *
 * <p>Input: address = "1.1.1.1" Output: "1[.]1[.]1[.]1"
 *
 * <p>Example 2:
 *
 * <p>Input: address = "255.100.50.0" Output: "255[.]100[.]50[.]0"
 *
 * @see <a href = "https://leetcode.com/problems/defanging-an-ip-address/">Defanging an IP
 *     Address</a>
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class DefangIpAddress {

  public String defangIPaddr(String address) {

    final StringBuilder sb = new StringBuilder();

    for (final char character : address.toCharArray()) {
      if (character == '.') {
        sb.append("[.]");
      } else {
        sb.append(character);
      }
    }
    ;

    return sb.toString();
  }
}
