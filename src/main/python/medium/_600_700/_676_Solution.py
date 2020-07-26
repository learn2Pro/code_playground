import collections
from typing import List


class MagicDictionary:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.lookup = {}

    def __insert(self, word):
        current = self.lookup
        for c in word:
            if c not in current: current[c] = {}
            current = current[c]
        current['_'] = word

    def buildDict(self, dict: List[str]) -> None:
        """
        Build a dictionary through a list of words
        """
        for word in dict:
            self.__insert(word)

    def search(self, word: str) -> bool:
        """
        Returns if there is any word in the trie that equals to the given word after modifying exactly one character
        """

        def dfs(i, remain, lookup):
            if i >= len(word):
                return not remain and '_' in lookup
            if remain:
                for k, v in lookup.items():
                    if k == word[i] or k == '_': continue
                    if dfs(i + 1, False, v): return True
            if word[i] not in lookup: return False
            return dfs(i + 1, remain, lookup[word[i]])

        return dfs(0, True, self.lookup)


class MagicDictionary:
    def _candidate(self, word):
        for i in range(len(word)):
            yield word[:i] + "*" + word[i + 1:]

    def buildDict(self, dict: List[str]) -> None:
        self.words = set(dict)
        self.near = collections.Counter(cand for word in dict for cand in self._candidate(word))

    def search(self, word: str) -> bool:
        return any(
            self.near[cand] > 1 or self.near[cand] == 1 and word not in self.words for cand in self._candidate(word))


'''
["MagicDictionary", "buildDict", "search", "search", "search", "search"]
[[], [["hello","leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
["MagicDictionary", "buildDict", "search", "search", "search", "search","search","search", "search", "search", "search"]
[[], [["hello","leetcode","","x","xxx"]],["ax"],["axx"],["xax"],["xxa"],[""] ,["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
["MagicDictionary", "buildDict", "search", "search", "search", "search"]
[[], [["hello","hallo","leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]'''
if __name__ == '__main__':
    obj = MagicDictionary()
    obj.buildDict(["hello", "leetcode"])
    assert not obj.search("hello")
    assert obj.search("hhllo")
    assert not obj.search("hell")
    assert not obj.search("leetcoded")
