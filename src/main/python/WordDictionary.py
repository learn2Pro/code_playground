# 211. Add and Search Word - Data structure design

'''
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["a"],["aa"],["aaa"],["a"],["a"],["."],["a."]]
'''


class WordDictionary:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.lookup = {}

    def addWord(self, word: str) -> None:
        """
        Adds a word into the data structure.
        """
        current = self.lookup
        for c in word:
            if c not in current: current[c] = {}
            current = current[c]
        current["_"] = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        """
        queue = []
        queue.append(self.lookup)
        i = 0
        n = len(word)
        while queue:
            size = len(queue)
            for _ in range(size):
                node = queue.pop(0)
                if i == n:
                    if node.get("_", False): return True
                else:
                    if word[i] == '.':
                        for entry in node:
                            if entry == "_": continue
                            queue.append(node[entry])
                    else:
                        if word[i] in node: queue.append(node[word[i]])
            i += 1
        return False


if __name__ == '__main__':
    instance = WordDictionary()
    instance.addWord("at")
    instance.addWord("and")
    instance.addWord("an")
    instance.addWord("add")
    assert not instance.search("a")
    assert not instance.search(".at")
    instance.addWord("bat")
    assert instance.search(".at")
    assert instance.search("an.")
    assert not instance.search("a.d.")
    assert not instance.search("b.")
    assert instance.search("a.d")
    assert not instance.search(".")
