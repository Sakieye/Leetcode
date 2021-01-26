#
# @lc app=leetcode id=239 lang=python3
#
# [239] Sliding Window Maximum
#
from collections import deque

# @lc code=start
class Solution:
    def maxSlidingWindow(self, nums: list[int], k: int) -> list[int]:
        q = deque()
        res = []

        for i in range(len(nums)):
            # the left most (max) element is out of window
            if q and i - q[0] == k:
                q.popleft()

            while q:
                if nums[i] > nums[q[-1]]:
                    q.pop()
                else:
                    break

            q.append(i)
            if i >= k - 1:
                res.append(nums[q[0]])

        return res


# @lc code=end
