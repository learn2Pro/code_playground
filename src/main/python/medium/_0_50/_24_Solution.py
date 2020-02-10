# 24. Swap Nodes in Pairs
from src.main.python import ListNode


class _24_Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if head is None: return head
        pre, p0, p1 = None, head, head.next
        i = 0
        ans = p0
        while p1:
            tmp = p1.next
            p1.next = p0
            p0.next = tmp
            if pre: pre.next = p1
            pre = p0
            p0 = tmp
            if i == 0: ans = p1
            if p0:
                p1 = p0.next
            else:
                p1 = None
            i += 1
        return ans


if __name__ == '__main__':
    instance = _24_Solution
    l0, l1, l2, l3 = ListNode.ListNode(1), ListNode.ListNode(2), ListNode.ListNode(3), ListNode.ListNode(4)
    l0.next = l1
    l1.next = l2
    l2.next = l3
    # assert instance.swapPairs(instance, l0) == l2
    assert instance.swapPairs(instance, l3) == l3
    assert instance.swapPairs(instance, l2) == l3
