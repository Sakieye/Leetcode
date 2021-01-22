#
# @lc app=leetcode id=39 lang=python3
#
# [39] Combination Sum
#

# @lc code=start
class Solution:
    def combinationSum(self, candidates: list[int], target: int) -> list[list[int]]:
        if not candidates or len(candidates) == 0:
            return []

        res = []

        def dfs(candidates, start, comb, target, res):
            if target == 0:
                res.append(comb)
                return
            if candidates[start] > target:
                return
            for i in range(start, len(candidates)):
                dfs(candidates, i, comb + [candidates[i]], target - candidates[i], res)

        dfs(sorted(candidates), 0, [], target, res)

        return res


# @lc code=end
