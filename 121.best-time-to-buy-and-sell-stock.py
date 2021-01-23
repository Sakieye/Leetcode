#
# @lc app=leetcode id=121 lang=python3
#
# [121] Best Time to Buy and Sell Stock
#

# @lc code=start
class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        res = 0
        curMin = prices[0]
        for i, price in enumerate(prices):
            res = max(res, price - curMin)
            curMin = min(curMin, price)

        return res


# @lc code=end
