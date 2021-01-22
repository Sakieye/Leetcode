#
# @lc app=leetcode id=79 lang=python3
#
# [79] Word Search
#

# @lc code=start
class Solution:
    def exist(self, board: list[list[str]], word: str) -> bool:
        self.board = board
        self.word = word
        self.m = len(board)
        self.n = len(board[0])
        self.l = len(word)
        self.visited = [[False] * self.n for row in board]

        if self.l > self.m * self.n:
            return False
        for i in range(0, self.m):
            for j in range(0, self.n):
                if self.dfs(i, j, 0):
                    return True

    def dfs(self, i, j, charIdx):
        if self.board[i][j] != self.word[charIdx]:
            return False
        if charIdx == self.l - 1:
            return True
        self.visited[i][j] = True

        if i < self.m - 1 and not self.visited[i + 1][j]:
            if self.dfs(i + 1, j, charIdx + 1):
                return True
        if i > 0 and not self.visited[i - 1][j]:
            if self.dfs(i - 1, j, charIdx + 1):
                return True
        if j < self.n - 1 and not self.visited[i][j + 1]:
            if self.dfs(i, j + 1, charIdx + 1):
                return True
        if j > 0 and not self.visited[i][j - 1]:
            if self.dfs(i, j - 1, charIdx + 1):
                return True

        self.visited[i][j] = False
        return False


# @lc code=end
