from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode(-1) # 定义一个空的头节点
        res = dummy
        p = l1
        q = l2
        t = 0        # 进位
        while p or q: # 如果两个数位数不相等,少的零补齐
            n1 = 0
            n2 = 0
            if p :
                n1 = p.val
                p = p.next
            if q:
                n2 = q.val
                q = q.next
            sum = n1 + n2 + t
            res.next = ListNode(sum % 10)  # 尾插
            res = res.next
            t = sum // 10
        if t:
            res.next = ListNode(t)
        return dummy.next


# leetcode submit region end(Prohibit modification and deletion)
