package blind.curated75;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {

  public static void main(String[] args) {
    int[][] m1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] m2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    int[][] m3 = {{6, 9, 7}};

    System.out.println(spiralOrder(m1));
    System.out.println(spiralOrder(m2));
    System.out.println(spiralOrder(m3));
  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new LinkedList<>();
    // i for row, j for col
    int firstI = 0;
    int firstJ = 0;
    int lastI = matrix.length - 1;
    int lastJ = matrix[0].length - 1;

    while (firstI <= lastI && firstJ <= lastJ) {

      // firstRow ->
      for (int j = firstJ; j <= lastJ; j++) {
        res.add(matrix[firstI][j]);
      }
      firstI++;

      // lastCol go down
      for (int i = firstI; i <= lastI; i++) {
        res.add(matrix[i][lastJ]);
      }
      lastJ--;


      if (firstI <= lastI) {
        // lastRow <-
        for (int j = lastJ; j >= firstJ; j--) {
          res.add(matrix[lastI][j]);
        }
      }
      lastI--;

      if (firstJ <= lastJ) {
        // firstCol go up
        for (int i = lastI; i >= firstI; i--) {
          res.add(matrix[i][firstJ]);
        }
      }
      firstJ++;
    }

    // middle one
    if (firstI == lastI && firstJ == lastJ) {
      res.add(matrix[lastI][lastJ]);
    }

    return res;
  }

}
