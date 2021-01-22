#
# @lc app=leetcode id=23 lang=python3
#
# [23] Merge k Sorted Lists
#

# @lc code=start
# Definition for singly-linked list.
from queue import PriorityQueue


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeKLists(self, lists: list[ListNode]) -> ListNode:
        if not lists:
            return None
        ans = ListNode()
        i = ans
        values = []
        for node in lists:
            j = node
            while j:
                values.append(j.val)
                j = j.next

        for v in sorted(values):
            i.next = ListNode(val=v)
            i = i.next
        return ans.next


# @lc code=end
