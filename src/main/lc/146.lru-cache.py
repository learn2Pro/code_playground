#
# @lc app=leetcode id=146 lang=python3
#
# [146] LRU Cache
#

# @lc code=start
class LRUCache:

    def __init__(self, capacity: int):
        self.container = {}
        self.capacity = capacity
        self.keys = []

    def evict(self):
        if len(self.keys) > self.capacity:
            k = self.keys.pop(0)
            del self.container[k]

    def updateOrder(self, key: int):
        if key in self.keys:
            self.keys.remove(key)
        self.keys.append(key)

    def get(self, key: int) -> int:
        if key in self.container:
            v = self.container[key]
            self.updateOrder(key)
            return v
        return -1

    def put(self, key: int, value: int) -> None:
        self.container[key] = value
        self.updateOrder(key)
        self.evict()


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
# @lc code=end
