# 2. Add Two Numbers
import ListNode


class _2_Solution:

    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
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

        return add(l1, l2)


if __name__ == '__main__':
    instance = _2_Solution()
    # n0 = ListNode.ListNode(1)
    # n1 = .ListNode(2)
    # instance.addTwoNumbers(n0, n1)
