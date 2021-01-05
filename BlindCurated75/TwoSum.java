package BlindCurated75;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class TwoSum {

  public static int[] twoSum(int[] nums, int target) {
    // You may assume that each input would have exactly one solution, and you may not use the same
    // element twice.

    // Input: nums = [2,7,11,15], target = 9
    // Output: [0,1]
    // Output: Because nums[0] + nums[1] == 9, we return [0, 1].
    //
    // Input: nums = [3,2,4], target = 6
    // Output: [1,2]
    //
    // Input: nums = [3,3], target = 6
    // Output: [0,1]
    var map = new LinkedHashMap<Integer, Integer>(); // pairNum : index
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];

      Integer pairIndex = map.get(num);
      if (pairIndex != null) {
        return new int[] {pairIndex, i};
      }

      int pairNum = target - num;
      map.put(pairNum, i);
    }

    return null;
  }

  public static void main(String[] args) {
    int[] input1 = {2, 7, 11, 15};
    int[] input2 = {3, 2, 4};
    int[] input3 = {3, 3};
    int[] input4 = {1, 4, 5, 12, 11, 6, 7};
    var inputs = new LinkedList<int[]>();
    inputs.add(input1);
    inputs.add(input2);
    inputs.add(input3);
    inputs.add(input4);
    int[] targets = {9, 6, 6, 10};

    for (int i = 0; i < inputs.size(); i++) {
      System.out.println(Arrays.toString(twoSum(inputs.get(i), targets[i])));
    }
  }
}
