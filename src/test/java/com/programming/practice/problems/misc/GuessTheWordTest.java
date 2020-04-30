package com.programming.practice.problems.misc;

import org.junit.Assert;
import org.junit.Test;

/**
 * White box tests for {@link GuessTheWord}.
 *
 * @author Swapnil Godambe.<br>
 *     Copyright 2020.
 */
public final class GuessTheWordTest {

  class MasterImplementation implements GuessTheWord.Master {

    private final String[] wordList;
    private final String secretWord;
    private int count;

    public MasterImplementation(final String[] wordList, final String secretWord) {
      this.wordList = wordList;
      this.secretWord = secretWord;
      this.count = 0;
    }

    public int getAPICallCount() {
      return count;
    }

    @Override
    public int guess(final String word) {
      ++count;
      if (word.equals(secretWord)) {
        return word.length();
      }

      if (!isWordPresentInWordList(word)) {
        return -1;
      }

      int count = 0;
      for (int i = 0; i < word.length(); ++i) {
        if (secretWord.charAt(i) == word.charAt(i)) {
          ++count;
        }
      }

      return count;
    }

    private boolean isWordPresentInWordList(final String word) {
      for (final String wordInWordList : wordList) {
        if (word.equals(wordInWordList)) {
          return true;
        }
      }

      return false;
    }
  }

  private final GuessTheWord obj = new GuessTheWord();

  @Test
  public void testScenario1() {
    final String secretWord = "acckzz";
    final String[] wordList = new String[] {"acckzz", "ccbazz", "eiowzz", "abcczz"};
    final MasterImplementation master = new MasterImplementation(wordList, secretWord);

    obj.findSecretWord(wordList, master);

    Assert.assertTrue("The number of guesses exceeded 10", master.getAPICallCount() <= 10);
  }

  @Test
  public void testScenario2() {
    final String secretWord = "ccoyyo";
    final String[] wordList =
        new String[] {
          "wichbx", "oahwep", "tpulot", "eqznzs", "vvmplb", "eywinm", "dqefpt", "kmjmxr", "ihkovg",
          "trbzyb", "xqulhc", "bcsbfw", "rwzslk", "abpjhw", "mpubps", "viyzbc", "kodlta", "ckfzjh",
          "phuepp", "rokoro", "nxcwmo", "awvqlr", "uooeon", "hhfuzz", "sajxgr", "oxgaix", "fnugyu",
          "lkxwru", "mhtrvb", "xxonmg", "tqxlbr", "euxtzg", "tjwvad", "uslult", "rtjosi", "hsygda",
          "vyuica", "mbnagm", "uinqur", "pikenp", "szgupv", "qpxmsw", "vunxdn", "jahhfn", "kmbeok",
          "biywow", "yvgwho", "hwzodo", "loffxk", "xavzqd", "vwzpfe", "uairjw", "itufkt", "kaklud",
          "jjinfa", "kqbttl", "zocgux", "ucwjig", "meesxb", "uysfyc", "kdfvtw", "vizxrv", "rpbdjh",
          "wynohw", "lhqxvx", "kaadty", "dxxwut", "vjtskm", "yrdswc", "byzjxm", "jeomdc", "saevda",
          "himevi", "ydltnu", "wrrpoc", "khuopg", "ooxarg", "vcvfry", "thaawc", "bssybb", "ccoyyo",
          "ajcwbj", "arwfnl", "nafmtm", "xoaumd", "vbejda", "kaefne", "swcrkh", "reeyhj", "vmcwaf",
          "chxitv", "qkwjna", "vklpkp", "xfnayl", "ktgmfn", "xrmzzm", "fgtuki", "zcffuv", "srxuus",
          "pydgmq"
        };
    final MasterImplementation master = new MasterImplementation(wordList, secretWord);

    obj.findSecretWord(wordList, master);

    Assert.assertTrue("The number of guesses exceeded 10", master.getAPICallCount() <= 10);
  }

  @Test
  public void testScenario3() {
    final String secretWord = "hbaczn";
    final String[] wordList =
        new String[] {
          "gaxckt", "trlccr", "jxwhkz", "ycbfps", "peayuf", "yiejjw", "ldzccp", "nqsjoa", "qrjasy",
          "pcldos", "acrtag", "buyeia", "ubmtpj", "drtclz", "zqderp", "snywek", "caoztp", "ibpghw",
          "evtkhl", "bhpfla", "ymqhxk", "qkvipb", "tvmued", "rvbass", "axeasm", "qolsjg", "roswcb",
          "vdjgxx", "bugbyv", "zipjpc", "tamszl", "osdifo", "dvxlxm", "iwmyfb", "wmnwhe", "hslnop",
          "nkrfwn", "puvgve", "rqsqpq", "jwoswl", "tittgf", "evqsqe", "aishiv", "pmwovj", "sorbte",
          "hbaczn", "coifed", "hrctvp", "vkytbw", "dizcxz", "arabol", "uywurk", "ppywdo", "resfls",
          "tmoliy", "etriev", "oanvlx", "wcsnzy", "loufkw", "onnwcy", "novblw", "mtxgwe", "rgrdbt",
          "ckolob", "kxnflb", "phonmg", "egcdab", "cykndr", "lkzobv", "ifwmwp", "jqmbib", "mypnvf",
          "lnrgnj", "clijwa", "kiioqr", "syzebr", "rqsmhg", "sczjmz", "hsdjfp", "mjcgvm", "ajotcx",
          "olgnfv", "mjyjxj", "wzgbmg", "lpcnbj", "yjjlwn", "blrogv", "bdplzs", "oxblph", "twejel",
          "rupapy", "euwrrz", "apiqzu", "ydcroj", "ldvzgq", "zailgu", "xgqpsr", "wxdyho", "alrplq",
          "brklfk"
        };
    final MasterImplementation master = new MasterImplementation(wordList, secretWord);

    obj.findSecretWord(wordList, master);

    Assert.assertTrue("The number of guesses exceeded 10", master.getAPICallCount() <= 10);
  }
}
