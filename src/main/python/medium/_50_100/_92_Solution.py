# 92. Reverse Linked List II
from src.main.python.ListNode import ListNode


class _92_Solution:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        if head is None or head.next is None: return head
        headhead = ListNode(-1)
        headhead.next = head
        start = headhead
        iter = m
        while start and iter > 1: start = start.next;iter -= 1
        if not start or iter > 1: return head
        last = top = p0 = start.next
        iter = max(n - m, 0)
        while p0 and iter >= 0:
            tmp = p0.next
            p0.next = last
            last = p0
            p0 = tmp
            iter -= 1
        if top: top.next = p0
        start.next = last
        return headhead.next


if __name__ == '__main__':
    instance = _92_Solution
    l0, l1, l2, l3, l4 = ListNode(1), ListNode(2), ListNode(3), ListNode(4), ListNode(5)
    l0.next = l1;
    l1.next = l2;
    l2.next = l3;
    l3.next = l4
    assert instance.reverseBetween(instance, l0, 2, 4) == l0
