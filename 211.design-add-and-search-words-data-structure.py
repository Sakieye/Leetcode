#
# @lc app=leetcode id=211 lang=python3
#
# [211] Design Add and Search Words Data Structure
#

# @lc code=start
class WordDictionary:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.word_dict = {}

    def addWord(self, word: str) -> None:
        w_dict = self.word_dict
        for c in word:
            if c not in w_dict:
                w_dict[c] = {}
            w_dict = w_dict[c]
        w_dict["#"] = {}  # end mark

    def search(self, word: str) -> bool:
        w_dict = self.word_dict

        def dfs(word, w_dict):
            if not word:
                if "#" in w_dict:
                    return True
                return False
            if word[0] == ".":
                return any([dfs(word[1:], children) for children in w_dict.values()])
            else:
                if word[0] not in w_dict:
                    return False
                return dfs(word[1:], w_dict[word[0]])

        return dfs(word, w_dict)


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)
# @lc code=end
