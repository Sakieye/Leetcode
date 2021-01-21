#
# @lc app=leetcode id=70 lang=python3
#
# [70] Climbing Stairs
#

# @lc code=start
class Solution:
    def climbStairs(self, n: int) -> int:
        pre = [0, 1]
        while n > 1:
            if pre[0] <= pre[1]:
                pre[0] += pre[1]
            else:
                pre[1] += pre[0]
            n -= 1
        return sum(pre)


# @lc code=end
