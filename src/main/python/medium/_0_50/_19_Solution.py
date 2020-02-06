# 19. Remove Nth Node From End of List
from src.main.python.ListNode import ListNode


class _19_Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        if head is None: return head
        p0 = head
        i = 0
        while i < n and p0: p0 = p0.next;i += 1;
        if i != n: return head
        if i == n and p0 is None: return head.next
        pre, p1 = head, head
        while p0: pre = p1;p1 = p1.next;p0 = p0.next;
        pre.next = p1.next
        p1.next = None
        return head


if __name__ == '__main__':
    instance = _19_Solution
    assert instance.removeNthFromEnd(instance, )
