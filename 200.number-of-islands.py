#
# @lc app=leetcode id=200 lang=python3
#
# [200] Number of Islands
#

# @lc code=start
class Solution:
    def numIslands(self, grid: list[list[str]]) -> int:
        m = len(grid)
        n = len(grid[0])
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    # find an island, start to DFS
                    stack = [[i, j]]
                    count += 1
                    while stack:
                        [row, col] = stack.pop()
                        grid[row][col] = "0"
                        if row - 1 >= 0 and grid[row - 1][col] == "1":
                            stack.append([row - 1, col])
                        if row + 1 < m and grid[row + 1][col] == "1":
                            stack.append([row + 1, col])
                        if col - 1 >= 0 and grid[row][col - 1] == "1":
                            stack.append([row, col - 1])
                        if col + 1 < n and grid[row][col + 1] == "1":
                            stack.append([row, col + 1])
        return count


# @lc code=end
