#
# @lc app=leetcode id=207 lang=python3
#
# [207] Course Schedule
#

# @lc code=start

from collections import defaultdict
from collections import deque


class Solution:
    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        count = 0
        preq_dict = defaultdict(list)
        in_count = defaultdict(int)
        queue = deque()

        for course, prereq in prerequisites:
            preq_dict[prereq].append(course)
            in_count[course] += 1

        for c in range(numCourses):
            if c not in in_count:  # course has no prerequisite
                queue.append(c)

        while queue:
            take_course = queue.popleft()
            count += 1
            for next_course in preq_dict[take_course]:
                in_count[next_course] -= 1
                if in_count[next_course] == 0:
                    queue.append(next_course)

        return count == numCourses


# @lc code=end
