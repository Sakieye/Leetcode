#
# @lc app=leetcode id=139 lang=python3
#
# [139] Word Break
#
from functools import lru_cache

# @lc code=start
class Solution:
    def wordBreak(self, s: str, words: list[str]) -> bool:
        n = len(s)

        @lru_cache(maxsize=n + 1)
        def word(i):
            if i == n:
                return True
            for w in words:
                w_len = len(w)
                new_idx = i + w_len
                if new_idx <= n and s[i:new_idx] == w:
                    if word(new_idx):
                        return True
            return False

        return word(0)


# @lc code=end
