# leetcode submit region begin(Prohibit modification and deletion)
class LRUCache:
    class Node:
        def __init__(self, key, val):
            self.key = key
            self.val = val
            self.prev = None
            self.next = None

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}
        self.head = None
        self.tail = None

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        node = self.cache[key]
        self.adjustOrder(node)
        return node.val

    def adjustOrder(self, node):
        if node == self.head:
            return
        if node == self.tail:
            self.tail = node.prev
            self.tail.next = None
        else:
            node.prev.next = node.next
            node.next.prev = node.prev
        node.prev = None
        node.next = self.head
        self.head.prev = node
        self.head = node

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            node = self.cache[key]
            node.val = value
            self.adjustOrder(node)
        else:
            if len(self.cache) == self.capacity:
                del self.cache[self.tail.key]
                if self.tail == self.head:
                    self.head = None
                    self.tail = None
                else:
                    self.tail = self.tail.prev
                    self.tail.next = None
            node = LRUCache.Node(key, value)
            self.cache[key] = node
            if self.head:
                node.next = self.head
                self.head.prev = node
                self.head = node
            else:
                self.head = node
                self.tail = node

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
# leetcode submit region end(Prohibit modification and deletion)
