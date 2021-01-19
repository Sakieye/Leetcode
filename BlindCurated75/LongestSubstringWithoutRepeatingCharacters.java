package BlindCurated75;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
  public static int lengthOfLongestSubstring(String s) {
    int tempMaxLen = 0;
    int lastNonRepeatStrStart = 0;
    var charMap = new HashMap<Character, Integer>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (charMap.containsKey(c)) { // 重複char出現
        tempMaxLen = Math.max(tempMaxLen, i - lastNonRepeatStrStart);
        lastNonRepeatStrStart = Math.max(charMap.get(c) + 1, lastNonRepeatStrStart); // abbcad，巡到i=2的b時，應更新為上一次b位置+1，但巡到i=4的a時，不應是上一次a位置+1，因其<上一次b位置+1
      }
      charMap.put(c, i);
    }

    return Math.max(tempMaxLen, s.length() - lastNonRepeatStrStart);
  }

  public static void main(String[] args) {
    String s1 = "abcabcbb"; // 3
    String s2 = "bbbbb"; // 1
    String s3 = "pwwkew"; // 3
    String s4 = ""; // 0
    String s5 = "pwwkewstrstrkew"; // 6
    String s6 = "dvdf"; // 3
    String s7 = "abba"; // 2
    String[] arr = {s1, s2, s3, s4, s5, s6, s7};
    for (String s : arr) {
      System.out.println(lengthOfLongestSubstring(s));
    }
  }
}
