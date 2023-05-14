from typing import Optional


class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random


# leetcode submit region begin(Prohibit modification and deletion)
"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""


class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        visited = {}

        def dfs(node):
            if not node:
                return None
            if node in visited:
                return visited[node]
            clone = Node(node.val, None, None)
            visited[node] = clone
            clone.next = dfs(node.next)
            clone.random = dfs(node.random)
            return clone

        if not head:
            return None

        dfs(head)
        return visited[head]

# leetcode submit region end(Prohibit modification and deletion)
