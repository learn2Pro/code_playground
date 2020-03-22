# 337. House Robber III
from src.main.python.TreeNode import TreeNode

'''
[3,2,3,null,3,null,1]
[3,4,5,1,3,null,1]
[3,50,5,5,null,null,100]
[]
[1]
[1,2]
[1,2,3,4]
[41,37,44,24,39,42,48,1,35,38,40,null,43,46,49,0,2,30,36,null,null,null,null,null,null,45,47,null,null,null,null,null,4,29,32,null,null,null,null,null,null,3,9,26,null,31,34,null,null,7,11,25,27,null,null,33,null,6,8,10,16,null,null,null,28,null,null,5,null,null,null,null,null,15,19,null,null,null,null,12,null,18,20,null,13,17,null,null,22,null,14,null,null,21,23]
'''


class _337_Solution:
    def rob(self, root: TreeNode) -> int:
        if not root: return 0

        def dfs(node: TreeNode) -> (int, int):
            if not node:
                return 0, 0
            lr, lnr = dfs(node.left)
            rr, rnr = dfs(node.right)
            return (node.val + lnr + rnr, max(lnr + rnr, lr + rr, lr + rnr, rr + lnr))

        return max(dfs(root))
