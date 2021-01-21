#
# @lc app=leetcode id=3 lang=python3
#
# [3] Longest Substring Without Repeating Characters
#

# @lc code=start
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charIdx = {}
        ans, i = 0, 0
        for j, char in enumerate(s):
            if char in charIdx:
                ans = max(ans, j - i)
                # shift i, if the idx of repeated char < last i, no update
                i = max(charIdx[char] + 1, i)
            charIdx[char] = j
        return max(ans, len(s) - i)  # if no repeated char in s, ans will be 0


# @lc code=end
