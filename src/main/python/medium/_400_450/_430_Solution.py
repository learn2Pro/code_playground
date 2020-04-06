class Node:
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child


# 430. Flatten a Multilevel Doubly Linked List
'''
[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
[1,2,null,3]
[1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,null,null,13,14,null,null,11,12]
[]
[1]
'''


class _430_Solution:
    def flatten(self, head: 'Node') -> 'Node':
        def traversal(node: 'Node') -> 'Node':
            if node.next is None and node.child is None: return node
            while node.next and node.child is None: node = node.next
            if node.child is None:
                return traversal(node)
            else:
                node.child.prev = node
                next = node.next
                node.next = node.child
                tail = traversal(node.child)
                if next:
                    next.prev = tail
                    tail.next = next
                node.child = None
                return traversal(next or tail)

        if not head: return head
        traversal(head)
        return head

    # use stack
    def flatten(self, head: 'Node') -> 'Node':
        if not head: return head
        stack, p = [], head
        while p:
            if p.child:
                stack.append(p.next)
                p.next = p.child
                if p.child: p.child.prev = p
                p.child = None
            elif p.next is None and len(stack) > 0:
                p.next = stack.pop()
                if p.next: p.next.prev = p
            p = p.next
        return head
