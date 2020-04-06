# 429. N-ary Tree Level Order Traversal
from collections import deque
from typing import List


class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class _429_Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root: return []
        queue, ans = deque([root]), []
        while queue:
            size = len(queue)
            level = []
            for _ in range(size):
                head = queue.popleft()
                level.append(head.val)
                if head.children:
                    for child in head.children:
                        if not child: continue
                        queue.append(child)
            ans.append(level)
        return ans


if __name__ == '__main__':
    r0 = Node(1, [Node(2, [Node(3)])])
    obj = _429_Solution()
    assert obj.levelOrder(r0) == [[1], [2], [3]]
