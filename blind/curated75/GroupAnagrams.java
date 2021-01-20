package blind.curated75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

  public static void main(String[] args) {
    String[] strs1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
    String[] strs2 = { "" };
    String[] strs3 = { "a" };
    List strss = new LinkedList();
    strss.add(strs1);
    strss.add(strs2);
    strss.add(strs3);

    strss.forEach(strs -> System.out.println(groupAnagrams((String[]) strs)));
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> res = new ArrayList<>();
    Map<Long, List<String>> strHashMap = new HashMap<>();
    int[] alpha = getAplha();

    for (String str : strs) {
      long strHash = 1;

      for (int i = 0; i < str.length(); i++) {
        strHash *= alpha[str.charAt(i) - 'a'];
      }

      List<String> anagrams = strHashMap.getOrDefault(strHash, new LinkedList<String>());
      anagrams.add(str);
      strHashMap.put(strHash, anagrams);
    }

    strHashMap.forEach((strHash, anagrams) -> res.add(anagrams));

    return res;
  }

  private static int[] getAplha() {
    int[] alpha = new int[26];
    alpha[0] = 2; // a
    alpha[1] = 3; // b
    alpha[2] = 5; // c
    alpha[3] = 7; // d
    alpha[4] = 11; // e
    alpha[5] = 13; // f
    alpha[6] = 17; // g
    alpha[7] = 19; // h
    alpha[8] = 23; // i
    alpha[9] = 29; // j
    alpha[10] = 31; // k
    alpha[11] = 37; // l
    alpha[12] = 41; // m
    alpha[13] = 43; // n
    alpha[14] = 47; // o
    alpha[15] = 53; // p
    alpha[16] = 59; // q
    alpha[17] = 61; // r
    alpha[18] = 67; // s
    alpha[19] = 71; // t
    alpha[20] = 73; // u
    alpha[21] = 79; // v
    alpha[22] = 83; // w
    alpha[23] = 89; // x
    alpha[24] = 97; // y
    alpha[25] = 101; // z
    return alpha;
  }
}
