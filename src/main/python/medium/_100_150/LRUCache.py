from collections import OrderedDict


class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.lst = OrderedDict()

    def get(self, key: int) -> int:
        if key not in self.lst: return -1
        # move to head
        self.lst.move_to_end(key, last=False)
        return self.lst[key]

    def put(self, key: int, value: int) -> None:
        self.lst[key] = value
        self.lst.move_to_end(key, last=False)
        if len(self.lst) > self.capacity:
            self.lst.popitem()


# class LRUCache:
#
#     def __init__(self, capacity: int):
#         self.capacity = capacity
#         self.lst = deque()
#         self.mapping = {}
#
#     def get(self, key: int) -> int:
#         if key not in self.mapping: return -1
#         search = self.mapping[key]
#         self.lst.remove((key, search))
#         self.lst.appendleft((key, search))
#         return search
#
#     def put(self, key: int, value: int) -> None:
#         if key in self.mapping:
#             self.lst.remove((key, self.mapping[key]))
#         self.lst.appendleft((key, value))
#         self.mapping[key] = value
#         if len(self.lst) > self.capacity:
#             (k, v) = self.lst.pop()
#             if len(self.mapping) > self.capacity: self.mapping.pop(k)


if __name__ == '__main__':
    instance = LRUCache(2)
    instance.put(1, 1)
    instance.put(2, 2)
    assert instance.get(1) == 1
    instance.put(3, 3)
    assert instance.get(2) == -1
    instance.put(4, 4)
    assert instance.get(1) == -1
    assert instance.get(3) == 3
    assert instance.get(4) == 4
