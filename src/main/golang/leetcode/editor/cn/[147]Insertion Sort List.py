from typing import Optional
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next: Optional[ListNode] = next
# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def insertionSortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return head
        dummy = ListNode(-1)
        dummy.next = head
        cur = head.next
        head.next = None
        while cur:
            next = cur.next
            cur.next = None
            node = dummy
            while node.next and node.next.val < cur.val:
                node = node.next
            cur.next = node.next
            node.next = cur
            cur = next
        return dummy.next
# leetcode submit region end(Prohibit modification and deletion)
