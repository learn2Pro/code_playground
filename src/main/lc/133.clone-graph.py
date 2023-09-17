#
# @lc app=leetcode id=133 lang=python3
#
# [133] Clone Graph
#
class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""


class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        cloned = {}

        def dfs(n: Node):
            if n.val in cloned:
                print('1', n.val)
                return cloned[n.val]
            curr = Node(n.val)
            cloned[n.val] = curr
            for nxt in n.neighbors:
                v = dfs(nxt)
                # print(v, v.val)
                curr.neighbors.append(v)
            return curr
        if node is None:
            return None
        dfs(node)
        return cloned[node.val]


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    a, b, c, d = Node(1), Node(2), Node(3), Node(4)
    a.neighbors.extend([b, d])
    b.neighbors.extend([a, c])
    c.neighbors.extend([b, d])
    d.neighbors.extend([a, c])
    print(a)
    x = s.cloneGraph(a)
    print(x.val, list(map(lambda y: y.val, x.neighbors)))
    print(x.neighbors[0].val, list(
        map(lambda y: y.val, x.neighbors[0].neighbors)))
    print(x.neighbors[1].val, list(
        map(lambda y: y.val, x.neighbors[1].neighbors)))
    print(x.neighbors[1].val, list(
        map(lambda y: y.val, x.neighbors[1].neighbors)))
