# 445. Add Two Numbers II
import ListNode


class _445_Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        def reverse(node: ListNode):
            last = node
            curr = node.next
            node.next = None
            while curr is not None:
                tmp = curr.next
                curr.next = last
                last = curr
                curr = tmp
            return last

        def get(n):
            if n is None:
                return 0
            else:
                return n.val

        def add(n0, n1):
            carry = 0
            head = curr = ListNode(-1)
            while n0 != None or n1 != None:
                carry, out = divmod(get(n0) + get(n1) + carry, 10)
                curr.next = ListNode(out)
                curr = curr.next
                if (n0 != None): n0 = n0.next
                if (n1 != None): n1 = n1.next

            if (carry != 0): curr.next = ListNode(carry)

            return head.next

        return reverse(add(reverse(l1), reverse(l2)))
