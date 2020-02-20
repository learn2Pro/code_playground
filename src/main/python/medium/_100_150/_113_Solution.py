# 113. Path Sum II
from typing import List

from src.main.python.TreeNode import TreeNode

'''
[5,4,8,11,null,13,4,7,2,null,null,5,1]
22
[1,-1,2]
0
[1,-2,-3]
-2
[]
0
[1]
1
[1]
2
'''
class _113_Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        ans = []

        def dfs(node: TreeNode, previous: List[int], remain: int) -> None:
            if node is None:
                return
            if node.left is None and node.right is None:
                if remain == node.val: ans.append(previous + [node.val])
                return
            previous.append(node.val)
            dfs(node.left, previous, remain - node.val)
            dfs(node.right, previous, remain - node.val)
            previous.pop()

        dfs(root, [], sum)
        return ans
