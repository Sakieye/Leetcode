package BlindCurated75;

public class IsPalindrome {
  public static boolean isPalindrome(String s) {
    int n = s.length();

    if (n == 0) return false;
    if (n == 1) return true;

    int l = n / 2;
    int r = l;
    // l, r >= 1
    if (l * 2 == n) {
      l--;
    }

    while (0 <= l && r < n) {
      if (s.charAt(l) != s.charAt(r)) {
        return false;
      }
      l--;
      r++;
    }

    return true;
  }

  public static void main(String[] args) {
    String[] strs = {" ", "a", "aa", "aaa", "dbacabd", "dbacabe", "ab", ""};
    for (String s : strs) {
      System.out.println(isPalindrome(s));
    }
  }
}
