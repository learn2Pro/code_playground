# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        carry = 0
        dummy_root = ListNode(-1)
        current = dummy_root
        while l1 != None and l2 != None:
            digit = (l1.val + l2.val + carry) % 10
            carry = (l1.val + l2.val + carry) // 10
            current.next = ListNode(digit)
            current, l1, l2 = current.next, l1.next, l2.next
        while l1 != None:
            digit = (l1.val + carry) % 10
            carry = (l1.val + carry) // 10
            current.next = ListNode(digit)
            current, l1 = current.next, l1.next
        while l2 != None:
            digit = (l2.val + carry) % 10
            carry = (l2.val + carry) // 10
            current.next = ListNode(digit)
            current, l2 = current.next, l2.next
        if carry != 0:
            current.next = ListNode(carry)
        return dummy_root.next
# leetcode submit region end(Prohibit modification and deletion)
