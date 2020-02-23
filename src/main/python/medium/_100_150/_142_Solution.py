# 142. Linked List Cycle II
from src.main.python.ListNode import ListNode

'''
[3,2,0,-4]
1
[]
1
[1,2]
0
[1]
0
[1]
-1
'''


class _142_Solution:
    def detectCycle(self, head: ListNode) -> ListNode:
        if not head or not head.next: return None
        fast, slow, i = head, head, 0
        while fast and fast.next and (i == 0 or fast != slow):
            fast = fast.next.next
            slow = slow.next
            i += 1
        if fast != slow: return None
        slow = head
        while slow != fast:
            fast = fast.next
            slow = slow.next
        return slow
