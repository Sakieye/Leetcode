#
# @lc app=leetcode id=73 lang=python3
#
# [73] Set Matrix Zeroes
#

# @lc code=start
class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        m = len(matrix)
        n = len(matrix[0])
        rows = set()
        cols = set()
        for row in range(m):
            for col in range(n):
                if matrix[row][col] == 0:
                    rows.add(row)
                    cols.add(col)
        while rows:
            row = rows.pop()
            for col in range(n):
                matrix[row][col] = 0
        while cols:
            col = cols.pop()
            for row in range(m):
                matrix[row][col] = 0


# @lc code=end
