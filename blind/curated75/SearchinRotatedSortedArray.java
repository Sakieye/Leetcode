package blind.curated75;

public class SearchinRotatedSortedArray {
  public static int search(int[] nums, int target) {
    int minIdx = findMinIdx(nums);
    if (target == nums[minIdx])
      return minIdx;

    int n = nums.length;
    // 0 --- minIdx --- n-1 // target?
    Integer left;
    Integer right;

    if (target > nums[n - 1]) {
      left = 0;
      right = minIdx;
    } else {
      left = minIdx + 1;
      right = n - 1;
    }

    while (left <= right) {
      int mid = (left + right) / 2;
      if (target == nums[mid]) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return -1;
  }

  public static int findMinIdx(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (right > left) {
      int mid = (left + right) / 2;
      if (nums[mid] > nums[right]) { // 左邊卻比右邊大，表示最低位在右邊
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  public static void main(String[] args) {
    // 1 <= nums.length <= 5000
    // -10^4 <= nums[i] <= 10^4
    // All values of nums are unique.
    // nums is guranteed to be rotated at some pivot.
    // -10^4 <= target <= 10^4

    int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
    int[] nums2 = {1};
    int[] nums3 = {1, 3};
    int[] targets = {0, 3, 0, 3};
    int[][] numsArray = {nums1, nums1, nums2, nums3};

    // 4, -1, -1, 1
    for (int i = 0; i < targets.length; i++) {
      System.out.println(search(numsArray[i], targets[i]));
    }
  }
}
