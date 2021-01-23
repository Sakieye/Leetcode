#
# @lc app=leetcode id=128 lang=python3
#
# [128] Longest Consecutive Sequence
#

# @lc code=start
class Solution:
    def longestConsecutive(self, nums: list[int]) -> int:
        # """O(nlogn) Since we sort"""
        # n = len(nums)
        # if n <= 1:
        #     return n

        # nums.sort()
        # maxLen = preMax = 1
        # for i in range(1, n):
        #     diff = nums[i] - nums[i - 1]
        #     if diff == 1 or diff == 0:
        #         preMax += diff
        #         maxLen = max(maxLen, preMax)
        #     else:
        #         preMax = 1
        # return maxLen

        """O(n)"""
        nums = set(nums)
        maxLen = 0
        for x in nums:
            if x - 1 not in nums:  # x is first num of consecutive seq
                y = x + 1
                while y in nums:
                    y += 1
                maxLen = max(maxLen, y - x)
        return maxLen


# @lc code=end
