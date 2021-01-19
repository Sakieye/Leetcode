package BlindCurated75;

public class ValidParentheses {
  public static boolean isValid(String s) {
    char[] stack = new char[s.length()];
    int head = 0;

    for (char c : s.toCharArray()) {
      switch (c) {
        case '(':
          stack[head++] = ')';
          break;
        case '{':
          stack[head++] = '}';
          break;
        case '[':
          stack[head++] = ']';
          break;
        default:
          if (head == 0 || stack[--head] != c)
            return false;
          break;
      }
    }
    return head == 0;
  }

  public static void main(String[] args) {
    // 1 <= s.length <= 104
    String[] strs = {"()", "()[]{}", "{[]}", "(]", "([)]", "(){}}{"};

    for (String s : strs) {
      System.out.println(isValid(s));
    }
  }
}
