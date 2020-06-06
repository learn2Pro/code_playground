# 508. Most Frequent Subtree Sum
from typing import List

from src.main.python.TreeNode import TreeNode


class _508_Solution:
    def findFrequentTreeSum(self, root: TreeNode) -> List[int]:
        dict, maximal = {}, -0xffffffff

        def dfs(node: TreeNode) -> int:
            nonlocal maximal
            if not node:
                return 0
            acc = node.val + dfs(node.left) + dfs(node.right)
            dict[acc] = dict.get(acc, 0) + 1
            maximal = max(maximal, dict[acc])
            return acc

        dfs(root)
        ans = []
        for k, v in dict.items():
            if v == maximal: ans.append(k)
        return ans
'''
[5,2,-3]
[]
[2]
[2,2,2,2,-2]
[1,1,-1,-1,-1,1,1,null,null,1,-1,null,1]
[3,1,5,0,2,4,6]
'''
