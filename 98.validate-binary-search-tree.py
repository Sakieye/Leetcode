#
# @lc app=leetcode id=98 lang=python3
#
# [98] Validate Binary Search Tree
#

# @lc code=start
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isValidBST(
        self, root: TreeNode, floor=float("-inf"), ceiling=float("inf")
    ) -> bool:
        if not root:
            return True
        if root.val <= floor or root.val >= ceiling:
            return False
        return self.isValidBST(root.left, floor, root.val) and self.isValidBST(
            root.right, root.val, ceiling
        )


# @lc code=end
