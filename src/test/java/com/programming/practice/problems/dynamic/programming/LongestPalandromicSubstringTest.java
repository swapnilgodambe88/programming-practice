package com.programming.practice.problems.dynamic.programming;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link LongestPalandromicSubstring}.
 *
 * @author Swapnil Godambe. Copyright 2020.
 */
public final class LongestPalandromicSubstringTest {

  @Test
  public void testEmptyString() {
    final LongestPalandromicSubstring obj = new LongestPalandromicSubstring();

    final String inputString = "";
    final String expectedString = "";

    Assert.assertEquals(expectedString, obj.longestPalindrome(inputString));
    Assert.assertEquals(expectedString, obj.longestPalindromeUsingDynamicProgramming(inputString));
  }

  @Test
  public void testSingleCharacterSolution() {
    final LongestPalandromicSubstring obj = new LongestPalandromicSubstring();

    final String inputString = "abcdefg";
    final String expectedString = "a";

    Assert.assertEquals(expectedString, obj.longestPalindrome(inputString));
    Assert.assertEquals(expectedString, obj.longestPalindromeUsingDynamicProgramming(inputString));
  }

  @Test
  public void testInputStringIsPalindrome() {
    final LongestPalandromicSubstring obj = new LongestPalandromicSubstring();

    final String inputString = "abcdefggfedcba";
    final String expectedString = inputString;

    Assert.assertEquals(expectedString, obj.longestPalindrome(inputString));
    Assert.assertEquals(expectedString, obj.longestPalindromeUsingDynamicProgramming(inputString));
  }

  @Test
  public void testRandomString1() {
    final LongestPalandromicSubstring obj = new LongestPalandromicSubstring();

    final String inputString = "babad";
    final String expectedString = "bab";

    Assert.assertEquals(expectedString, obj.longestPalindrome(inputString));
    Assert.assertEquals(expectedString, obj.longestPalindromeUsingDynamicProgramming(inputString));
  }

  @Test
  public void testRandomString2() {
    final LongestPalandromicSubstring obj = new LongestPalandromicSubstring();

    final String inputString = "cbbd";
    final String expectedString = "bb";

    Assert.assertEquals(expectedString, obj.longestPalindrome(inputString));
    Assert.assertEquals(expectedString, obj.longestPalindromeUsingDynamicProgramming(inputString));
  }

  @Test
  public void testLongString() {
    final LongestPalandromicSubstring obj = new LongestPalandromicSubstring();

    final String inputString =
        "cyyoacmjwjubfkzrrbvquqkwhsxvmytmjvbborrtoiyotobzjmohpadfrvmxuagbdczsjuekjrmcwyaovpiogspbslcppxojgbfxhtsxmecgqjfuvahzpgprscjwwutwoiksegfreortttdotgxbfkisyakejihfjnrdngkwjxeituomuhmeiesctywhryqtjimwjadhhymydlsmcpycfdzrjhstxddvoqprrjufvihjcsoseltpyuaywgiocfodtylluuikkqkbrdxgjhrqiselmwnpdzdmpsvbfimnoulayqgdiavdgeiilayrafxlgxxtoqskmtixhbyjikfmsmxwribfzeffccczwdwukubopsoxliagenzwkbiveiajfirzvngverrbcwqmryvckvhpiioccmaqoxgmbwenyeyhzhliusupmrgmrcvwmdnniipvztmtklihobbekkgeopgwipihadswbqhzyxqsdgekazdtnamwzbitwfwezhhqznipalmomanbyezapgpxtjhudlcsfqondoiojkqadacnhcgwkhaxmttfebqelkjfigglxjfqegxpcawhpihrxydprdgavxjygfhgpcylpvsfcizkfbqzdnmxdgsjcekvrhesykldgptbeasktkasyuevtxrcrxmiylrlclocldmiwhuizhuaiophykxskufgjbmcmzpogpmyerzovzhqusxzrjcwgsdpcienkizutedcwrmowwolekockvyukyvmeidhjvbkoortjbemevrsquwnjoaikhbkycvvcscyamffbjyvkqkyeavtlkxyrrnsmqohyyqxzgtjdavgwpsgpjhqzttukynonbnnkuqfxgaatpilrrxhcqhfyyextrvqzktcrtrsbimuokxqtsbfkrgoiznhiysfhzspkpvrhtewthpbafmzgchqpgfsuiddjkhnwchpleibavgmuivfiorpteflholmnxdwewj";
    final String expectedString = "xrcrx";

    Assert.assertEquals(expectedString, obj.longestPalindrome(inputString));
    Assert.assertEquals(expectedString, obj.longestPalindromeUsingDynamicProgramming(inputString));
  }
}
