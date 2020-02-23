# 147. Insertion Sort List
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


class _147_Solution:
    # extra space
    def insertionSortList(self, head: ListNode) -> ListNode:
        array = []
        node = head
        while node: array.append(node.val);node = node.next
        array.sort()
        node = head
        for i in range(len(array)):
            node.val = array[i]
            node = node.next
        return head
    # def insertionSortList(self, head: ListNode) -> ListNode:
    #     if head is None or head.next is None: return head
    #     root = previous = head
    #     current = head.next
    #     while current:
    #         last = None
    #         node = root
    #         next = current.next
    #         while node and node != current and current.val > node.val:
    #             last = node
    #             node = node.next
    #         if current == node: previous = current;current = next;continue
    #         if last:
    #             last.next = current
    #         else:
    #             root = current
    #         current.next = node
    #         previous.next = next
    #         current = next
    #     return root


if __name__ == '__main__':
    instance = _147_Solution
    n1 = ListNode(1);
    n2 = ListNode(2);
    n3 = ListNode(3);
    n4 = ListNode(4)
    n4.next = n2
    n2.next = n1
    n1.next = n3
    assert instance.insertionSortList(instance, n4) == n1
