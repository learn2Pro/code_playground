# 328. Odd Even Linked List
from src.main.python.ListNode import ListNode

'''
[1,2,3,4,5]
[1]
[1,2]
[1,2,3]
[]
'''
class _328_Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        if not head or not head.next: return head
        odd, even = head, head.next
        p0, p1 = odd, even

        while p1 and p1.next:
            p0.next = p0.next.next
            p1.next = p1.next.next
            p1 = p1.next
            p0 = p0.next

        p0.next = even
        return odd
    # def oddEvenList(self, head: ListNode) -> ListNode:
    #     if not head or not head.next: return head
    #     odd, even = head, head.next
    #     p0, p1 = odd, even
    #
    #     def forward(step: int, node: ListNode) -> ListNode:
    #         while step > 0:
    #             step -= 1
    #             if not node: continue
    #             node = node.next
    #         return node
    #
    #     last = p0
    #     while p0:
    #         next0 = forward(2, p0)
    #         next1 = forward(2, p1)
    #         p0.next = next0
    #         if p1: p1.next = next1
    #         if p1: p1 = p1.next
    #         last = p0
    #         p0 = p0.next
    #
    #     last.next = even
    #     return odd
