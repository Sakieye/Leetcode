package blind.curated75;

public class MaxSubArray {

  public static void main(String[] args) {
    int[] n1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    int[] n2 = {-1};
    int[] n3 = {-1, -5};
    int[] n4 = {-2, 1, -3, 4};
    int[][] ns = {n1, n2, n3, n4};
    for (int[] n : ns) {
      System.out.println(maxSubArray(n));
    }
  }

  public static int maxSubArray(int[] nums) {
    int curSum = nums[0];
    int maxSum = nums[0];

    for (int i = 1; i < nums.length; i++) {
      curSum = Math.max(nums[i], curSum + nums[i]);
      maxSum = Math.max(curSum, maxSum);
    }

    return maxSum;


  }

  public static int maxSubArray2(int[] nums) {
    int maxSub = nums[0], curSum = 0;

    for (int n : nums) {
      if (curSum < 0) {
        curSum = 0;
      }
      curSum += n;
      maxSub = Math.max(maxSub, curSum);
    }
    return maxSub;
  }
}
