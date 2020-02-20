# 117. Populating Next Right Pointers in Each Node II


'''
[1,2,3,4,5,null,7]
[]
[1]
[1,2]
[1,null,3,4,5]
[1,2,3,4,null,null,5]
[1,2,3,4,5,null,6,7,null,null,null,null,8]
[-1,-7,9,null,null,-1,-7,null,8,-9]
'''
from src.main.python.Node import Node


class _117_Solution:
    def connect(self, root: 'Node') -> 'Node':
        if root is None: return root
        node = root
        needle = level = Node(0)
        while node:
            while node:
                if node.left:
                    needle.next = node.left
                    needle = needle.next
                if node.right:
                    needle.next = node.right
                    needle = needle.next
                node = node.next
            needle = level
            node = level.next
            level.next = None
        return root
    # def connect(self, root: 'Node') -> 'Node':
    #     if root is None: return root
    #     queue = []
    #     queue.append(root)
    #     while queue:
    #         size = len(queue)
    #         for i in range(size):
    #             current = queue.pop(0)
    #             if i < size - 1:
    #                 current.next = queue[0]
    #             if current.left: queue.append(current.left)
    #             if current.right: queue.append(current.right)
    #     return root
