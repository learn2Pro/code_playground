# 648. Replace Words
from typing import List


class Trie:
    def __init__(self):
        self.lookup = {}

    def add(self, word):
        current = self.lookup
        for c in word:
            if c not in current: current[c] = {}
            current = current[c]
        current['_'] = word

    def searchPrefix(self, successor):
        current = self.lookup
        for c in successor:
            if c not in current: return successor
            current = current[c]
            if '_' in current: return current['_']
        return successor if '_' not in current else current['_']


class _648_Solution:
    def replaceWords(self, dict: List[str], sentence: str) -> str:
        root = Trie()
        for word in dict:
            root.add(word)
        return ' '.join(map(lambda s: root.searchPrefix(s), sentence.split(' ')))
