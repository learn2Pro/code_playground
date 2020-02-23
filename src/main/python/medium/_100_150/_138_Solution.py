# 138. Copy List with Random Pointer
from src.main.python.random.Node import Node

'''
[[7,null],[13,0],[11,4],[10,2],[1,0]]
[]
[[3,null],[3,0],[3,null]]
[[1,1],[2,1]]
'''
class _138_Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if not head: return head
        root = Node(head.val, None, None)
        mapping = {head: root}
        queue = []
        queue.append(head)
        while queue:
            current = queue.pop(0)
            if current.next:
                copy = mapping.get(current.next, Node(current.next.val, None, None))
                mapping[current].next = copy
                if current.next not in mapping: queue.append(current.next)
                mapping[current.next] = copy
            if current.random:
                copy = mapping.get(current.random, Node(current.random.val, None, None))
                mapping[current].random = copy
                if current.random not in mapping: queue.append(current.random)
                mapping[current.random] = copy
        return root
