#
# @lc app=leetcode id=5 lang=python3
#
# [5] Longest Palindromic Substring
#

# @lc code=start
class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        start, end = 0, 0
        for i, centerChar in enumerate(s):
            left, right = i, i
            # shift until boundary or encounter different char
            while left >= 0 and s[left] == centerChar:
                left -= 1
            while right < n and s[right] == centerChar:
                right += 1
            while left >= 0 and right < n and s[left] == s[right]:
                left -= 1
                right += 1
            if right - left > end - start:
                end = right
                start = left

        return s[start + 1 : end]


# @lc code=end
