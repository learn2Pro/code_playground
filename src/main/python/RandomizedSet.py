import random


class RandomizedSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dict = {}
        self.lst = []

    def insert(self, val: int) -> bool:
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        """
        if val in self.dict: return False
        self.dict[val] = len(self.lst)
        self.lst.append(val)
        return True

    def remove(self, val: int) -> bool:
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        """
        if val not in self.dict or len(self.dict) == 0: return False
        last, idx = self.lst[-1], self.dict[val]
        self.lst[idx], self.dict[last] = last, idx
        del self.dict[val]
        self.lst.pop()
        return True

    def getRandom(self) -> int:
        """
        Get a random element from the set.
        """
        if len(self.lst) == 0: return -1
        return random.choice(self.lst)

# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
