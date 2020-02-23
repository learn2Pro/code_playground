# 148. Sort List
from src.main.python.ListNode import ListNode

'''
[4,2,1,3]
[1,2,3,4]
[]
[1]
[2,1]
[3,2,1]
[-1,5,3,4,0]
'''
class _148_Solution:
    def sortList(self, head: ListNode) -> ListNode:
        def mergeSort(node: ListNode) -> ListNode:
            if not node or not node.next: return node
            fast = slow = last = node
            while fast and fast.next:
                fast = fast.next.next
                last = slow
                slow = slow.next
            last.next = None
            left = mergeSort(node)
            right = mergeSort(slow)
            last = None
            root = left if left.val <= right.val else right
            while left and right:
                if left.val <= right.val:
                    if last: last.next = left
                    last = left
                    left = left.next
                else:
                    if last: last.next = right
                    last = right
                    right = right.next
            if left:
                last.next = left
            else:
                last.next = right
            return root

        return mergeSort(head)


if __name__ == '__main__':
    instance = _148_Solution
    n1 = ListNode(1);
    n2 = ListNode(2);
    n3 = ListNode(3);
    n4 = ListNode(4)
    n4.next = n2
    n2.next = n1
    n1.next = n3
    assert instance.sortList(instance, n4) == n1
