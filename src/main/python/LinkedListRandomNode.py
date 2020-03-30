import random

from src.main.python.ListNode import ListNode

'''
["Solution","getRandom"]
[[[1,2,3]],[]]
["Solution","getRandom"]
[[[1]],[]]
["Solution","getRandom","getRandom","getRandom","getRandom","getRandom","getRandom"]
[[[1,2,3,4]],[],[],[],[],[],[]]
'''
class LinkedListRandomNode:

    def __init__(self, head: ListNode):
        """
        @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node.
        """
        self.head = head

    def getRandom(self) -> int:
        """
        Returns a random node's value.
        """
        i, h, ans = 1, self.head.next, self.head.val
        while h:
            rnd = random.randrange(0, i + 1)
            if rnd == i: ans = h.val
            h = h.next
            i += 1
        return ans

# class LinkedListRandomNode:
#
#     def __init__(self, head: ListNode):
#         """
#         @param head The linked list's head.
#         Note that the head is guaranteed to be not null, so it contains at least one node.
#         """
#         self.lst = []
#         while head:
#             self.lst.append(head.val)
#             head = head.next
#
#     def getRandom(self) -> int:
#         """
#         Returns a random node's value.
#         """
#         return random.choice(self.lst)
