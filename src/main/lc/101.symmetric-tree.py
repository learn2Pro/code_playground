#
# @lc app=leetcode id=101 lang=python3
#
# [101] Symmetric Tree
#

# @lc code=start
# Definition for a binary tree node.
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        # q = [root]
        # while q:
        #     n = len(q)
        #     ans = []
        #     for i in range(n):
        #         curr = q.pop(0)
        #         if curr:
        #             q.append(curr.left)
        #             q.append(curr.right)
        #         ans.append('null' if not curr else curr.val)
        #     # print(ans)
        #     if ans != ans[::-1]:
        #         return False
        # return True
        if not root:
            return True

        def isMirror(left, right):
            if not left and not right:
                return True
            if not left or not right:
                return False
            return left.val == right.val and isMirror(left.left, right.right) and isMirror(left.right, right.left)
        return isMirror(root.left, root.right)


# @lc code=end
if __name__ == "__main__":
    s = Solution()
    print(s.isSymmetric(TreeNode(1,
                                 TreeNode(2, None, TreeNode(3)),
                                 TreeNode(2, None, TreeNode(3))
                                 )))
