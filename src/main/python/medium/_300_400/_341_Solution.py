# 341. Flatten Nested List Iterator
from src.main.python.NestedInteger import NestedInteger

'''
[[1,1],2,[1,1]]
[1,[4,[6]]]
[1,[2],[3,[4]]]
[1]
[]
[[[1],2,3],1]
[[[[1]]]]
[[[[1],3]]]
'''


# use stack
class NestedIterator:
    def __init__(self, nestedList: [NestedInteger]):
        self.stack = nestedList[::-1]

    def next(self) -> int:
        return self.stack.pop().getInteger()

    def hasNext(self) -> bool:
        while self.stack:
            if self.stack[-1].isInteger():
                return True
            top = self.stack.pop()
            self.stack += top.getList()[::-1]
        return False

# use iterator
# class NestedIterator:
#     def __init__(self, nestedList: [NestedInteger]):
#         self.index = 0
#         self.lst = nestedList
#         self.num = None
#         self.inner = None
#         self.buildNext()
#
#     def buildNext(self):
#         if self.index >= len(self.lst):
#             self.num = None
#             self.inner = None
#         else:
#             if self.lst[self.index].isInteger():
#                 self.num = self.lst[self.index].getInteger()
#             else:
#                 self.inner = NestedIterator(self.lst[self.index].getList())
#         self.index += 1
#
#     def next(self) -> int:
#         if self.num != None:
#             tmp = self.num
#             self.num = None
#             return tmp
#         else:
#             return self.inner.next()
#
#     def hasNext(self) -> bool:
#         if self.num is None and (self.inner is None or not self.inner.hasNext()):
#             if self.index >= len(self.lst):
#                 return False
#             else:
#                 self.buildNext()
#                 return self.hasNext()
#         else:
#             return True
