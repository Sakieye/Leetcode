package blind.curated75;

import java.util.Arrays;

public class RotateImage {

  public static void main(String[] args) {
    int[][] i1 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
    int[][] o1 = {{15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}};
    int[][] i2 = {{1}};
    int[][] o2 = {{1}};
    int[][] i3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] o3 = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
    int[][] i4 = {{1, 2}, {3, 4}};
    int[][] o4 = {{3, 1}, {4, 2}};

    int[][][] inputs = {i1, i2, i3, i4};
    int[][][] outputs = {o1, o2, o3, o4};

    for (int i = 0; i < inputs.length; i++) {
      System.out.println(Arrays.deepToString(rotate(inputs[i])));
      System.out.println(Arrays.deepToString(outputs[i]));
    }
  }

  public static int[][] rotate(int[][] matrix) {
    // outermost to innermost, F(first), S(second), T(third)
    // 1 2 3 4 5 F
    // X 1 2 3 S X
    // X X 1 T X X
    // X X X X X X
    // X X X X X X
    // X X X X X X
    for (int row = 0; row < matrix.length / 2; row++) {
      for (int col = row; col <= (matrix.length - 2) - row; col++) {
        int upperLeftMostVal = matrix[row][col]; // The upper leftmost value in this iteration
        int preRow1 = matrix.length - 1 - col;
        matrix[row][col] = matrix[preRow1][row];
        int preRow2 = matrix.length - 1 - row;
        matrix[preRow1][row] = matrix[preRow2][preRow1];
        int preRow3 = matrix.length - 1 - preRow1;
        matrix[preRow2][preRow1] = matrix[preRow3][preRow2];
        matrix[preRow3][preRow2] = upperLeftMostVal;
      }
    }

    return matrix;
  }
}
