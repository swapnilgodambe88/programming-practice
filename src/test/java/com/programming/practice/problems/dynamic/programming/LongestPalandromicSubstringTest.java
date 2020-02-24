package com.programming.practice.problems.dynamic.programming;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link LongestPalandromicSubstring}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class LongestPalandromicSubstringTest {

  private final LongestPalandromicSubstring obj = new LongestPalandromicSubstring();

  @Test
  public void testEmptyString() {
    final String inputString = "";
    final String expectedString = "";

    Assert.assertEquals(expectedString, obj.longestPalindrome(inputString));
    Assert.assertEquals(expectedString, obj.longestPalindromeUsingDynamicProgramming(inputString));
  }

  @Test
  public void testSingleCharacterSolution() {
    final String inputString = "abcdefg";
    final String expectedString = "a";

    Assert.assertEquals(expectedString, obj.longestPalindrome(inputString));
    Assert.assertEquals(expectedString, obj.longestPalindromeUsingDynamicProgramming(inputString));
  }

  @Test
  public void testInputStringIsPalindrome() {
    final String inputString = "abcdefggfedcba";
    final String expectedString = inputString;

    Assert.assertEquals(expectedString, obj.longestPalindrome(inputString));
    Assert.assertEquals(expectedString, obj.longestPalindromeUsingDynamicProgramming(inputString));
  }

  @Test
  public void testRandomString1() {
    final String inputString = "babad";
    final String expectedString = "bab";

    Assert.assertEquals(expectedString, obj.longestPalindrome(inputString));
    Assert.assertEquals(expectedString, obj.longestPalindromeUsingDynamicProgramming(inputString));
  }

  @Test
  public void testRandomString2() {
    final String inputString = "cbbd";
    final String expectedString = "bb";

    Assert.assertEquals(expectedString, obj.longestPalindrome(inputString));
    Assert.assertEquals(expectedString, obj.longestPalindromeUsingDynamicProgramming(inputString));
  }

  @Test
  public void testLongString() {
    final String inputString =
        "cyyoacmjwjubfkzrrbvquqkwhsxvmytmjvbborrtoiyotobzjmohpadfrvmxuagbdczsjuekjrmcwyaovpiogspbslcppxojgbfxhtsxmecgqjfuvahzpgprscjwwutwoiksegfreortttdotgxbfkisyakejihfjnrdngkwjxeituomuhmeiesctywhryqtjimwjadhhymydlsmcpycfdzrjhstxddvoqprrjufvihjcsoseltpyuaywgiocfodtylluuikkqkbrdxgjhrqiselmwnpdzdmpsvbfimnoulayqgdiavdgeiilayrafxlgxxtoqskmtixhbyjikfmsmxwribfzeffccczwdwukubopsoxliagenzwkbiveiajfirzvngverrbcwqmryvckvhpiioccmaqoxgmbwenyeyhzhliusupmrgmrcvwmdnniipvztmtklihobbekkgeopgwipihadswbqhzyxqsdgekazdtnamwzbitwfwezhhqznipalmomanbyezapgpxtjhudlcsfqondoiojkqadacnhcgwkhaxmttfebqelkjfigglxjfqegxpcawhpihrxydprdgavxjygfhgpcylpvsfcizkfbqzdnmxdgsjcekvrhesykldgptbeasktkasyuevtxrcrxmiylrlclocldmiwhuizhuaiophykxskufgjbmcmzpogpmyerzovzhqusxzrjcwgsdpcienkizutedcwrmowwolekockvyukyvmeidhjvbkoortjbemevrsquwnjoaikhbkycvvcscyamffbjyvkqkyeavtlkxyrrnsmqohyyqxzgtjdavgwpsgpjhqzttukynonbnnkuqfxgaatpilrrxhcqhfyyextrvqzktcrtrsbimuokxqtsbfkrgoiznhiysfhzspkpvrhtewthpbafmzgchqpgfsuiddjkhnwchpleibavgmuivfiorpteflholmnxdwewj";
    final String expectedString = "xrcrx";

    Assert.assertEquals(expectedString, obj.longestPalindrome(inputString));
    Assert.assertEquals(expectedString, obj.longestPalindromeUsingDynamicProgramming(inputString));
  }
}
