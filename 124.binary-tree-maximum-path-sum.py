#
# @lc app=leetcode id=124 lang=python3
#
# [124] Binary Tree Maximum Path Sum
#

# @lc code=start
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        self.max_path = float("-inf")

        def get_max_path(node):
            if node is None:
                return 0
            gain_on_left = max(get_max_path(node.left), 0)
            gain_on_right = max(get_max_path(node.right), 0)
            cur_max_path = node.val + gain_on_left + gain_on_right
            self.max_path = max(self.max_path, cur_max_path)

            # choose the large one to be path (can't choose both branches)
            return node.val + max(gain_on_left, gain_on_right)

        get_max_path(root)
        return self.max_path


# @lc code=end
