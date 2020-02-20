# 127. Word Ladder
from typing import List

'''
"hit"
"cog"
["hot","dot","dog","lot","log","cog"]
"hit"
"cog"
[]
"hit"
"cog"
["hot"]
"hit"
"cog"
["hot","dot","dog","lot","log"]
"a"
"b"
["c","d"]
'''


class _127_Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        smaller = set()
        bigger = set()
        visited = set()
        remain = set(wordList)
        if endWord not in remain: return 0
        smaller.add(beginWord)
        bigger.add(endWord)
        level = 1
        while smaller and bigger:
            if len(smaller) > len(bigger):
                tmp = bigger
                bigger = smaller
                smaller = tmp
            next = set()
            for word in smaller:
                for i in range(len(word)):
                    for j in range(26):
                        c = chr(ord('a') + j)
                        newly = word[0:i] + c + word[i + 1:]
                        if newly == word: continue
                        if newly in bigger: return level + 1
                        if newly not in visited and newly in remain:
                            visited.add(newly)
                            next.add(newly)
            level += 1
            smaller = next
        return 0
    # def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
    #     remain = set(wordList)
    #     queue = []
    #     queue.append(beginWord)
    #     level = 1
    #     while queue:
    #         size = len(queue)
    #         for l in range(size):
    #             current = queue.pop(0)
    #             if current == endWord: return level
    #             for i in range(len(current)):
    #                 for j in range(26):
    #                     newly = chr(j + ord('a'))
    #                     if newly == current[i]: continue
    #                     concat = current[0:i] + newly + current[i + 1:]
    #                     if concat in remain: queue.append(concat);remain.remove(concat)
    #         level += 1
    #     return 0


if __name__ == '__main__':
    instance = _127_Solution
    assert instance.ladderLength(instance, "hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]) == 5
