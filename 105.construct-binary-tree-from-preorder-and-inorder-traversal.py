#
# @lc app=leetcode id=105 lang=python3
#
# [105] Construct Binary Tree from Preorder and Inorder Traversal
#

# @lc code=start
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def buildTree(self, preorder: list[int], inorder: list[int]) -> TreeNode:
        inorder_dict = {}
        for i, num in enumerate(inorder):
            inorder_dict[num] = i

        preorder_iter = iter(preorder)

        def helper(start, end):
            if start > end:
                return

            root_val = next(preorder_iter)
            root = TreeNode(root_val)
            root_idx = inorder_dict[root_val]

            root.left = helper(start, root_idx - 1)
            root.right = helper(root_idx + 1, end)
            return root

        return helper(0, len(inorder) - 1)


# @lc code=end
