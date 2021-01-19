package BlindCurated75;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    var res = new LinkedList<List<Integer>>();
    backtrack(res, new LinkedList<Integer>(), candidates, target, 0);
    return res;
  }

  private static void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums,
      int remain, int start) {
    if (remain < 0)
      return;
    else if (remain == 0)
      res.add(new LinkedList<>(tempList)); // 用new，避免被其他步驟remove修改掉
    else {
      for (int i = start; i < nums.length; i++) {
        tempList.add(nums[i]);
        backtrack(res, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same
                                                             // elements
        tempList.remove(tempList.size() - 1);
      }
    }
  }

  public static void main(String[] args) {
    int[][] cArray = {{2, 3, 6, 7}, {2, 3, 5}, {2}, {1}, {1}, {2, 3, 6, 7}};
    int[] targets = {7, 8, 1, 1, 2, 12};

    // [[2,2,3],[7]]
    // [[2,2,2,2],[2,3,3],[3,5]]
    // []
    // [[1]]
    // [[1,1]]
    // [[2,2,2,2,2,2],[2,2,2,3,3],[2,2,2,6],[2,3,7],[3,3,3,3],[3,3,6],[6,6]]

    for (int i = 0; i < cArray.length; i++) {
      System.out.println(combinationSum(cArray[i], targets[i]));
    }
  }
}
