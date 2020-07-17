# 652. Find Duplicate Subtrees
from typing import List

from TreeNode import TreeNode

'''
[1,2,3,4,null,2,4,null,null,4]
[]
[1]
[1,null,2]
[1,2,2]
[3,3,3,3,null,null,3]
[2,1,11,11,null,1]
'''


class _652_Solution:
    def findDuplicateSubtrees(self, root: TreeNode) -> List[TreeNode]:
        visited = set()
        ans = {}

        def traversal(node):
            if not node:
                return "$"
            partial_pre = "{},{},{}".format(str(node.val), traversal(node.left), traversal(node.right))
            if partial_pre in visited:
                ans[partial_pre] = node
            visited.add(partial_pre)
            return partial_pre

        traversal(root)
        return [v for k, v in ans.items()]
