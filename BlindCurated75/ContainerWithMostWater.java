package BlindCurated75;

public class ContainerWithMostWater {
  public static int maxArea(int[] height) {
    int maxArea = 0;
    int l = 0;
    int r = height.length - 1;

    while (r > l) {
      maxArea = Math.max(maxArea, (r - l) * (Math.min(height[r], height[l])));
      if (height[l] < height[r]) {
        l++;
      } else {
        r--;
      }
    }

    return maxArea;
  }

  public static void main(String[] args) {
    int[] h1 = {1, 8, 6, 2, 5, 4, 8, 3, 7}; // 49
    int[] h2 = {1, 1}; // 1
    int[] h3 = {4, 3, 2, 1, 4}; // 16
    int[] h4 = {1, 2, 1}; // 2
    int[] h5 = {3, 9, 3, 4, 7, 2, 12, 6}; // 45
    int[] h6 = {3, 9, 3, 4, 7, 2, 12, 6, 100, 0, 100}; // 200
    int[] h7 = {2, 1}; // 1
    int[][] heights = {h1, h2, h3, h4, h5, h6, h7};
    for (int[] height : heights) {
      System.gc();
      long start = System.currentTimeMillis();
      System.out.println(maxArea(height));
      System.out.printf("cost %d ms%n", System.currentTimeMillis() - start);
    }
  }
}
