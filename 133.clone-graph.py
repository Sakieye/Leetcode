#
# @lc app=leetcode id=133 lang=python3
#
# [133] Clone Graph
#

# @lc code=start
"""
# Definition for a Node.
"""


class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


class Solution:
    def __init__(self) -> None:
        self.visited = {}

    def cloneGraph(self, node: Node) -> Node:
        if not node:
            return

        if node.val in self.visited:
            return self.visited[node.val]

        self.visited[node.val] = Node(node.val)  # new node
        nbrs = [self.cloneGraph(n) for n in node.neighbors]
        self.visited[node.val].neighbors = nbrs

        return self.visited[node.val]


# @lc code=end
