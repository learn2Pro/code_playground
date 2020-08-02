# 725. Split Linked List in Parts
from typing import List

from ListNode import ListNode

'''
[1,2,3,4]
5
[]
3
[1,2]
1
[1,2]
3
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
3
[]
2
[1,2,3]
1
[1,2,3,4]
2
[1,2,3,4,5]
10
'''
class _725_Solution:
    def splitListToParts(self, root: ListNode, k: int) -> List[ListNode]:
        size, node = 0, root
        while node:
            size += 1
            node = node.next
        part, remain = divmod(size, k)
        ans, node = [], root
        for i in range(k):
            fst, step, parent = node, part + 1 if remain > 0 else part, None
            remain -= 1
            while step and node:
                parent, node = node, node.next
                step -= 1
            ans.append(fst)
            if parent:
                parent.next = None
        return ans
