package blind.curated75;

public class LongestPalindromicSubstring {

  public static String longestPalindrome(String s) {
    int n = s.length();
    int start = 0;
    int end = 0;

    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      int left = i;
      int right = i;

      while (left >= 0 && s.charAt(left) == c) {
        left--;
      }

      while (right < n && s.charAt(right) == c) {
        right++;
      }

      while (left >= 0 && right < n) {
        if (s.charAt(left) != s.charAt(right)) {
          break;
        }
        left--;
        right++;
      }

      left++;
      if (end - start < right - left) {
        end = right;
        start = left;
      }
    }

    return s.substring(start, end);
  }

  public static void main(String[] args) {
    String s1 = "babad"; // bab
    String s2 = "cbbd"; // bb
    String s3 = "a"; // a
    String s4 = "ac"; // a
    String s5 = "abbabcddcbazz"; // abcddcba
    String s6 = "zzabbaabbayy"; // abbaabba
    String[] arr = {s1, s2, s3, s4, s5, s6};
    for (String s : arr) {
      System.out.println(longestPalindrome(s));
    }
  }
}
