#
# @lc app=leetcode id=152 lang=python3
#
# [152] Maximum Product Subarray
#

# @lc code=start
class Solution:
    def maxProduct(self, nums: list[int]) -> int:
        if not nums:
            return 0
        res = temp_min = temp_max = nums[0]

        for num in nums[1:]:
            if num < 0:
                temp_min, temp_max = temp_max, temp_min
            temp_min = min(num, temp_min * num)
            temp_max = max(num, temp_max * num)
            res = max(res, temp_max)

        return res


# @lc code=end
