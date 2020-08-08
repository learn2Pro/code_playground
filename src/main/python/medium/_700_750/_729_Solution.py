# 729. My Calendar I
import bisect
import collections
import heapq


class MyCalendar:

    def __init__(self):
        self.arr = [[-0x7fffffff, -0x7fffffff], [0x7fffffff, 0x7fffffff]]

    def book(self, start: int, end: int) -> bool:
        for i in range(len(self.arr) - 1):
            c, n = self.arr[i], self.arr[i + 1]
            if start >= c[1] and end <= n[0]:
                self.arr.insert(i + 1, [start, end])
                return True
        return False

    class Node:
        def __init__(self, start, end):
            self.start, self.end = start, end
            self.left = self.right = None

        def insert(self, node):
            if node.start >= self.end:
                if not self.right:
                    self.right = node
                    return True
                return self.right.insert(node)
            elif node.end <= self.start:
                if not self.left:
                    self.left = node
                    return True
                return self.left.insert(node)
            else:
                return False

    def __init__(self):
        self.tree = None

    def book(self, start: int, end: int) -> bool:
        if not self.tree:
            self.tree = self.Node(start, end)
            return True
        return self.tree.insert(self.Node(start, end))

    class Node:
        def __init__(self, start, end):
            self.start, self.end = start, end
            self.left = self.right = None

    class Tree:
        def __init__(self):
            self.root = None

        def insert(self, node, current):
            if not self.root:
                self.root = node
                return node
            if not current:
                return node
            if node.start >= current.end:
                right = self.insert(node, current.right)
                if right:
                    current.right = right
                    return current
                else:
                    return None
            elif node.end <= current.start:
                left = self.insert(node, current.left)
                if left:
                    current.left = left
                    return current
                else:
                    return None
            else:
                return None

    def __init__(self):
        self.tree = self.Tree()

    def book(self, start: int, end: int) -> bool:
        return self.tree.insert(self.Node(start, end), self.tree.root)


if __name__ == '__main__':
    obj = MyCalendar()
    assert obj.book(47, 50)
    assert obj.book(33, 41)
    assert not obj.book(39, 45)
    assert not obj.book(33, 42)
    assert obj.book(25, 32)
    assert not obj.book(26, 35)
    assert obj.book(19, 25)
    assert obj.book(3, 8)
    assert obj.book(8, 13)
    assert not obj.book(18, 27)
