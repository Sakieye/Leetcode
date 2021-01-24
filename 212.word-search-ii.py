#
# @lc app=leetcode id=212 lang=python3
#
# [212] Word Search II
#

# @lc code=start
class Solution:
    def findWords(self, board: list[list[str]], words: list[str]) -> list[str]:
        self.res, self.m, self.n = [], len(board), len(board[0])
        t = Trie()
        for w in words:
            t.insert(w)

        for i in range(self.m):
            for j in range(self.n):
                self.dfs(board, i, j, t.trie)

        return self.res

    def dfs(self, board, i, j, trie):
        if "end" in trie:
            self.res.append(trie["end"])
            del trie["end"]  # de-duplication
        if i < 0 or j < 0 or i >= self.m or j >= self.n:
            return
        char = board[i][j]
        if char not in trie:
            return
        next_dict = trie[char]
        board[i][j] = "#"  # visiting
        self.dfs(board, i - 1, j, next_dict)
        self.dfs(board, i + 1, j, next_dict)
        self.dfs(board, i, j - 1, next_dict)
        self.dfs(board, i, j + 1, next_dict)
        board[i][j] = char


class Trie:
    def __init__(self) -> None:
        self.trie = {}

    def insert(self, word) -> None:
        """
        insert('abc') -> {'c':{'b':{'a':{'end':word}}}}
        """
        t = self.trie
        for c in word:
            if c not in t:
                t[c] = {}
            t = t[c]
        t["end"] = word

    def __str__(self) -> str:
        return str(self.trie)


# @lc code=end
