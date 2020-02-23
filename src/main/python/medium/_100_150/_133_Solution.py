# 133. Clone Graph

from src.main.python.graph.Node import Node


class _133_Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if node is None: return node
        ans = Node(node.val, [])
        mapping = {node.val: ans}
        queue = []
        queue.append((node, ans))
        while queue:
            current, copy = queue.pop(0)
            for neighbor in current.neighbors:
                neighbor_clone = mapping.get(neighbor.val, Node(neighbor.val, []))
                copy.neighbors.append(neighbor_clone)
                if neighbor.val in mapping: continue
                mapping[neighbor.val] = neighbor_clone
                queue.append((neighbor, neighbor_clone))
        return ans


if __name__ == '__main__':
    n0 = Node(1, [])
    n1 = Node(2, [])
    n2 = Node(3, [])
    n3 = Node(4, [])
    n0.neighbors.append(n1)
    n0.neighbors.append(n2)
    n1.neighbors.append(n0)
    n1.neighbors.append(n2)
    n2.neighbors.append(n1)
    n2.neighbors.append(n3)
    n3.neighbors.append(n0)
    n3.neighbors.append(n2)
    instance = _133_Solution
    assert instance.cloneGraph(instance, n0) == n0
