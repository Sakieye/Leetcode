#
# @lc app=leetcode id=15 lang=python3
#
# [15] 3Sum
#

# @lc code=start
class Solution:
    def threeSum(self, nums):
        # test
        # [-1,-5,-2,0,1,2,3,5]\n[0,0,0,0]\n
        ans = []
        n = len(nums)
        if n < 3:
            return ans
        nums.sort()
        preNum = None
        for i in range(n - 2):
            num = nums[i]
            if num > 0:
                break
            if preNum != num or i == 0:
                li = i + 1
                ri = n - 1
                while li < ri:
                    sum = nums[li] + nums[ri]
                    if sum == -num:
                        ans.append([num, nums[li], nums[ri]])
                        # skip same value
                        while li < ri and nums[li] == nums[li + 1]:
                            li += 1
                        while li < ri and nums[ri] == nums[ri - 1]:
                            ri -= 1
                        li += 1
                        ri -= 1
                    elif sum < -num:
                        li += 1
                    else:
                        ri -= 1
            preNum = num
        return ans


# @lc code=end
