from typing import Optional


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        fst = headA
        while fst and fst.next:
            fst = fst.next
        fst.next = headB
        slow = fast = headA
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if fast == slow:
                break
        if not fast or not fast.next:
            fst.next = None
            return None
        slow = headA
        while slow != fast:
            slow = slow.next
            fast = fast.next
        fst.next = None
        return slow

# leetcode submit region end(Prohibit modification and deletion)
