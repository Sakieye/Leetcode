#
# @lc app=leetcode id=62 lang=python3
#
# [62] Unique Paths
#

# @lc code=start
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        """
        Partial DP, (memory, time) = (m, mn) or (n,mn)
        Full DP, (memory, time) = (mn, mn/2 <- worst (n-1)*...*(1))
        """
        if m == 1 or n == 1:
            return 1

        dpRow = [1] * n  # dpRow[0] = 1 always
        for row in range(1, m):
            for col in range(1, n):
                dpRow[col] += dpRow[col - 1]
        return dpRow[-1]


# @lc code=end