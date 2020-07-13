import random
from typing import List


class Node:
    def __init__(self, value):
        self.value = value
        self.next = None


def reverseList(node):
    if not node or not node.next: return node
    last = None
    prev, current = node, node.next
    while current:
        tmp = current.next
        prev.next = last
        current.next = prev
        last = current
        prev = tmp
        current = tmp.next if tmp and tmp.next else None
    if prev: prev.next = last
    return prev if prev else last


def reverseList2(node):
    if not node or not node.next: return node
    last = None
    current = node
    while current:
        tmp = current.next
        current.next = last
        last = current
        current = tmp
    return last


def initNodeList(val_list):
    cur = None
    for x in val_list[::-1]:
        node = Node(x)
        node.next = cur
        cur = node
    return cur


def traverse(node):
    while node is not None:
        print(node.value)
        node = node.next

def findMinStep(lst:List[int]):
   if not lst:return -1
   dp = [0x7fffffff] * len(lst)
   dp[0] = 0
   for i,num in enumerate(lst):
        for step in range(1,num+1):
           if step+i>=len(lst):continue
           dp[step+i] = min(dp[step+i],dp[i]+1)
   return dp[-1] if dp[-1]!=0x7fffffff else -1

def rand6_to_rand7():
    tmp = 36
    while tmp > 35:
        t0, t1 = random.randrange(1, 6), random.randrange(1, 6)
        tmp = t0 * t1
    return tmp % 5


if __name__ == '__main__':
    assert findMinStep([2,3,1,1,4]) == 2
    lst = initNodeList([1, 2, 3])
    traverse(reverseList2(lst))
    lst = initNodeList([1, 2, 3, 4])
    traverse(reverseList2(lst))
    lst = initNodeList([1, 2, 3, 4, 5])
    traverse(reverseList2(lst))
    lst = initNodeList([1, 2, 3, 4, 5, 6])
    traverse(reverseList2(lst))
