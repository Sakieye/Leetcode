#
# @lc app=leetcode id=33 lang=python3
#
# [33] Search in Rotated Sorted Array
#

# @lc code=start
class Solution:
    def search(self, nums: list[int], target: int) -> int:
        n = len(nums)

        def findMinIdx(nums):
            l = 0
            r = n - 1
            while l < r:
                mid = (l + r) // 2
                if nums[mid] > nums[r]:  # min in right side
                    l = mid + 1
                else:  # min in left side or itself
                    r = mid
            return l

        minIdx = findMinIdx(nums)
        # nums = [1], target = 1
        if nums[minIdx] == target:
            return minIdx
        # 0 --- minIdx --- n-1 // target
        l = 0
        r = 0
        if target > nums[n - 1]:
            l = 0
            r = minIdx - 1
        else:
            l = minIdx + 1
            r = n - 1
        while l <= r:
            mid = (l + r) // 2
            if nums[mid] == target:
                return mid
            elif target < nums[mid]:
                r = mid - 1
            else:
                l = mid + 1

        return -1


# @lc code=end
