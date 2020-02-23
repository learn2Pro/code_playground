# 143. Reorder List
from src.main.python.ListNode import ListNode


class _143_Solution:
    # constant space
    def reorderList(self, head: ListNode) -> None:
        if not head or not head.next: return
        fast = slow = previous = head
        step = 0
        while fast and fast.next:
            fast = fast.next.next
            slow = slow.next
            previous = slow
            step += 1
        if fast: previous = slow;slow = slow.next;step += 1
        while slow:
            tmp = slow.next
            slow.next = previous
            previous = slow
            slow = tmp
        last, left, right = None, head, previous
        while step > 0:
            tmp = left.next
            left.next = right
            if last: last.next = left
            last = right
            step -= 1
            left = tmp
            right = right.next
        if last: last.next = None
        return head

    # def reorderList(self, head: ListNode) -> None:
    #     """
    #     Do not return anything, modify head in-place instead.
    #     """
    #     array = []
    #     node = head
    #     while node: array.append(node);node = node.next;
    #     i, j, previous = 0, len(array) - 1, None
    #     while i <= j:
    #         array[i].next = array[j]
    #         if previous: previous.next = array[i]
    #         previous = array[j]
    #         i += 1
    #         j -= 1
    #     if previous: previous.next = None
    #     return head
