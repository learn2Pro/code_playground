from typing import Optional


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    # def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
    #     dummy = ListNode(-101)
    #     curr, p0, p1 = dummy, list1, list2
    #     while p0 != None and p1 != None:
    #         if p0.val < p1.val:
    #             curr.next = p0
    #             p0 = p0.next
    #         else:
    #             curr.next = p1
    #             p1 = p1.next
    #         curr = curr.next
    #     while p0 != None:
    #         curr.next = p0
    #         p0, curr = p0.next, curr.next
    #     while p1 != None:
    #         curr.next = p1
    #         p1, curr = p1.next, curr.next
    #     return dummy.next
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        if not list1: return list2
        if not list2: return list1
        if list1.val < list2.val:
            list1.next = self.mergeTwoLists(list1.next, list2)
            return list1
        else:
            list2.next = self.mergeTwoLists(list1, list2.next)
            return list2
# leetcode submit region end(Prohibit modification and deletion)
