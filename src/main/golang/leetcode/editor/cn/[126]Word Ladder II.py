import collections
from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Node:
    def __init__(self, word, index, pre):
        self.word = word
        self.index = index
        self.pre = pre


class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        wordId = dict()
        wordSearch = dict()
        edge = collections.defaultdict(list)
        nodeNum = 0
        def addWord(word: str):
            if word not in wordId:
                nonlocal nodeNum
                wordId[word] = nodeNum
                wordSearch[nodeNum] = word
                nodeNum += 1
        def addEdge(word: str):
            addWord(word)
            id1 = wordId[word]
            chars = list(word)
            for i in range(len(chars)):
                tmp = chars[i]
                chars[i] = "*"
                newWord = "".join(chars)
                addWord(newWord)
                id2 = wordId[newWord]
                edge[id1].append(id2)
                edge[id2].append(id1)
                chars[i] = tmp

        for word in wordList:
            addEdge(word)

        addEdge(beginWord)
        if endWord not in wordId:
            return []

        begin_id, end_id = wordId[beginWord], wordId[endWord]
        q = collections.deque([Node(beginWord, begin_id, None)])
        step, minimal = 1, float('inf')
        visited = set()
        ends = []
        while q:
            tmp = []
            for node in q:
                visited.add(node.index)
                if node.index == end_id:
                    minimal = min(minimal, step)
                    ends.append(node)
                for it in edge[node.index]:
                    if it not in visited:
                        tmp.append(Node(wordSearch[it], it, node))
            step += 1
            q = tmp
        ans = set()
        for end in ends:
            path = []
            while end:
                path.append(end.word)
                end = end.pre
            if len(path) == minimal:
                ans.add("_".join([x for x in path if "*" not in x][::-1]))
        return [x.split("_") for x in ans]

# leetcode submit region end(Prohibit modification and deletion)
