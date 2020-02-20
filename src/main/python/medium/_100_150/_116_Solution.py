# 116. Populating Next Right Pointers in Each Node
from src.main.python.Node import Node

'''[1,2,3,4,5,6,7]
[]
[1]
[1,2]
[1,null,3]
[1,2,3,4,5,null,7]
[1,2,3,4,null,null,7]'''


class _116_Solution:
    def connect(self, root: Node) -> Node:
        if not root: return root
        node = root
        while node:
            curr = node
            while curr:
                if curr.left:
                    curr.left.next = curr.right
                if curr.next and curr.right:
                    curr.right.next = curr.next.left
                curr = curr.next
            node = node.left
        return root
    # def connect(self, root: Node) -> Node:
    #     if not root: return root
    #     queue = []
    #     queue.append(root)
    #     while queue:
    #         size = len(queue)
    #         for i in range(size):
    #             current = queue.pop(0)
    #             if i < size - 1:
    #                 current.next = queue[0]
    #             else:
    #                 current.next = None
    #             if current.left: queue.append(current.left)
    #             if current.right: queue.append(current.right)
    #     return root
