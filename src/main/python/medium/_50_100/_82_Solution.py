# 82. Remove Duplicates from Sorted List II
from src.main.python import ListNode


class _82_Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if head is None or head.next is None: return head
        headhead = ListNode.ListNode(head.val - 1)
        headhead.next = head
        p0, p1, count = headhead, head, 0
        while p1:
            while p1.next and p1.val == p1.next.val: p1 = p1.next;count += 1
            if count == 0:
                p0 = p1
                if p1: p1 = p1.next
            else:
                p0.next = p1.next
                p0 = p0.next
                p1 = p1.next
            count = 0
        return headhead.next

