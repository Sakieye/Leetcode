#
# @lc app=leetcode id=76 lang=python3
#
# [76] Minimum Window Substring
#
import collections

# @lc code=start
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t) > len(s):
            return ""

        need, missing = collections.Counter(t), len(t)
        start, end, i = 0, 0, 0
        # i, j -> shift j until first match
        # 0, 1
        for j, char in enumerate(s, 1):
            if need[char] > 0:
                missing -= 1
            need[char] -= 1
            if missing == 0:  # find matched window
                # i -> shift i to the first appearing char
                while i < j and need[s[i]] < 0:
                    need[s[i]] += 1
                    i += 1
                if end == 0 or j - i < end - start:  # update
                    start, end = i, j
                # because we find matched window, need[s[i]] = 0, before shift i, recover the value
                need[s[i]] += 1
                missing += 1
                i += 1

        return s[start:end]


# @lc code=end
