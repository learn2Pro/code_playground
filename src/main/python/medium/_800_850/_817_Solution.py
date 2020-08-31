# 817. Linked List Components
import collections
from typing import List

from src.main.python.ListNode import ListNode

'''
[0,1,2,3]
[0,1,3]
[0,1,2,3,4,5]
[0,1,2]
[0,1,2,3,4]
[0,3,1,4]
[4,2,1,3,0]
[0,2]
[0]
[0]
[1,0]
[1,0]
[10,9,8,6,4,2,1,5,0,3,7]
[7,8]
[2,0,1]
[2,1]
'''


class _817_Solution:
    def numComponents(self, head: ListNode, G: List[int]) -> int:
        ans = 0
        cand = set(G)
        while head and cand:
            v = head.val
            if v in cand:
                while v in cand:
                    cand.remove(v)
                    head = head.next
                    v = head.val if head else -1
                ans += 1
            else:
                head = head.next

        return ans
