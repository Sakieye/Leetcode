#
# @lc app=leetcode id=139 lang=python3
#
# [139] Word Break
#

# @lc code=start
class Solution:
    def wordBreak(self, s: str, words: list[str]) -> bool:
        # ok[i] tells whether s[:i] can be built.
        ok = [True]
        w_len = max(map(len, words + [""]))
        words = set(words)
        for i in range(1, len(s) + 1):
            # before j can be built and s[j:i] can be built -> before i can be built
            ok += (any(ok[j] and s[j:i] in words for j in range(max(0, i - w_len), i)),)
        return ok[-1]


# @lc code=end
