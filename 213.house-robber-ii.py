#
# @lc app=leetcode id=213 lang=python3
#
# [213] House Robber II
#

# @lc code=start
class Solution:
    def rob(self, nums: list[int]) -> int:
        if len(nums) < 2:
            return max(nums + [0])

        def simple_rob(l, r):
            rob, not_rob = 0, 0
            while l < r:
                not_rob, rob, l = rob, max(not_rob + nums[l], rob), l + 1
            return rob

        return max(simple_rob(0, len(nums) - 1), simple_rob(1, len(nums)))


# @lc code=end
