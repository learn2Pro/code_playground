# 86. Partition List
from src.main.python.ListNode import ListNode

'''[1,4,3,2,5,2]
3
[]
1
[1,2]
1
[2,1]
1
[2,1]
2
[3]
1
[3]
4
[1,1,1,1]
0
[1,2,3,4,5]
6
[4,5,2,1]
3'''
class _86_Solution:
    def partition(self, head: ListNode, x: int) -> ListNode:
        if head is None or head.next is None: return head
        smallerHead, biggerHead = None, None
        smaller, bigger, pointer = None, None, head
        while pointer:
            if pointer.val < x:
                if smaller:
                    smaller.next = pointer
                    smaller = smaller.next
                else:
                    smaller = pointer
                    smallerHead = smaller
            else:
                if bigger:
                    bigger.next = pointer
                    bigger = bigger.next
                else:
                    bigger = pointer
                    biggerHead = bigger
            tmp = pointer.next
            pointer.next = None
            pointer = tmp
        if smaller:
            smaller.next = biggerHead
            return smallerHead
        else:
            return biggerHead
