# 61. Rotate List
from src.main.python import ListNode

'''
[1,2,3,4,5]
2
[1,2,3,4,5]
0
[1,2,3,4,5]
1
[1,2,3,4,5]
3
[1,2,3,4,5]
4
[1,2,3,4,5]
5
[1,2]
3
[]
1
[1]
1
'''


class _61_Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if head == None or k == 0: return head
        p0, p1, sz = head, head, 0
        while p1 != None: p1 = p1.next;sz += 1
        k %= sz
        p1 = head
        while k > 0: p1 = p1.next;k -= 1
        while p1.next != None:
            p0 = p0.next
            p1 = p1.next
        tmp = p0.next
        p1.next = head
        p0.next = None
        return tmp if tmp != None else head
