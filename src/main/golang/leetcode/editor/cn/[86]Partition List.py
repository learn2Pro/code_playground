from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        dummy1 = ListNode(val=0, next=head)
        dummy2 = ListNode(val=0)
        small, large = dummy1, dummy2
        while small.next:
            if small.next.val >= x:
                large.next = small.next
                large = large.next
                small.next = small.next.next
            else:
                small = small.next
        small.next = dummy2.next
        large.next = None
        return dummy1.next
# leetcode submit region end(Prohibit modification and deletion)
