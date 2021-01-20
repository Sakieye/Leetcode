package blind.curated75;

import static java.lang.Math.pow;
import static java.lang.Math.random;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    int n = nums.length;
    if (n >= 3) {
      Arrays.sort(nums);
      for (int i = 0; i < n - 2; i++) {
        if (nums[i] > 0)
          break;
        if (i == 0 || nums[i] != nums[i - 1]) { // i = 0初始掃描，其後都只要確認是否跟前一位相同，若相同則肯定在之前的掃描就已加入res
          int li = i + 1;
          int ri = n - 1;
          int target = -nums[i];
          while (li < ri) {
            int sum = nums[li] + nums[ri];
            if (sum == target) {
              res.add(Arrays.asList(nums[i], nums[li], nums[ri]));
              // 因已檢驗nums[li] + nums[ri]，其他和這兩個相同的數值，都直接跳過
              while (li < ri && nums[li] == nums[li + 1])
                li++;
              while (li < ri && nums[ri] == nums[ri - 1])
                ri--;
              li++;
              ri--;
            } else if (sum < target) {
              li++;
            } else {
              ri--;
            }
          }
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    int[] nums1 = {-1, 0, 1, 2, -1, -4}; // [[-1,-1,2],[-1,0,1]]
    // afterSort [-4, -1, -1, 0, 1, 2]
    int[] nums2 = {}; // []
    int[] nums3 = {0}; // []
    int[] nums4 = {-7, -3, -2, -1, -1, 2, 5}; // [[-7,2,5],[-3,-2,5],[-1,-1,2]]
    int[][] numArrays = {nums1, nums2, nums3, nums4};

    for (int[] nums : numArrays) {
      System.out.println(threeSum(nums));
    }

    // MonteCarlo
    final int N = 50001;
    int sum = 0;
    for (int i = 1; i < N; i++)
      if (pow(random(), 2) + pow(random(), 2) < 1) {
        sum++;
      }
    System.out.printf("PI = %f%n", 4.0 * sum / (N - 1));
  }
}
