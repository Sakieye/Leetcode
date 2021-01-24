#
# @lc app=leetcode id=198 lang=python3
#
# [198] House Robber
#

# @lc code=start
class Solution:
    def rob(self, nums: list[int]) -> int:
        n = len(nums)
        if n == 0:
            return 0
        elif n == 1:
            return nums[0]
        elif n == 2:
            return max(nums[0], nums[1])

        max_profit_rob_to = [nums[0], max(nums[0], nums[1])] + [0] * (n - 2)
        for i in range(2, n):
            max_profit_rob_to[i] = max(
                max_profit_rob_to[i - 2] + nums[i], max_profit_rob_to[i - 1]
            )
        return max_profit_rob_to[-1]


# @lc code=end
