class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.lookup = {}

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        current = self.lookup
        for c in word:
            if c not in current: current[c] = {}
            current = current[c]
        current["_"] = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        current = self.lookup
        for c in word:
            if c not in current: return False
            current = current[c]
        return "_" in current

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        current = self.lookup
        for c in prefix:
            if c not in current: return False
            current = current[c]
        return True


if __name__ == '__main__':
    instance = Trie()
    instance.insert("apple")
    assert instance.search("apple")
    assert not instance.search("app")
    assert instance.startsWith("app")
    instance.insert("app")
    assert instance.search("app")
