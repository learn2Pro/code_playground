# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
from typing import Optional, List


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    # def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
    #     def merge2Lists(self, l1: Optional[ListNode], l2: Optional[ListNode]):
    #         if not l1: return l2
    #         if not l2: return l1
    #         if l1.val < l2.val:
    #             l1.next = merge2Lists(self, l1.next, l2)
    #             return l1
    #         else:
    #             l2.next = merge2Lists(self, l1, l2.next)
    #             return l2
    #
    #     if not lists:
    #         return None
    #     return reduce(lambda l1, l2: merge2Lists(self, l1, l2), lists)
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        heap = []
        for i, lst in enumerate(lists):
            while lst:
                heap.append(lst.val)
                lst = lst.next
        dummy = ListNode()
        cur = dummy
        heap.sort()
        for num in heap:
            cur.next = ListNode(num)
            cur = cur.next
        return dummy.next

# leetcode submit region end(Prohibit modification and deletion)
