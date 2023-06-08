from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left: Optional[TreeNode] = left
        self.right: Optional[TreeNode] = right


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class BSTIterator:

    # 二叉搜索树的中序遍历是递增序列
    # 二叉搜索树的中序遍历的非递归实现
    # 二叉搜索树的中序遍历的Morris遍历实现
    def __init__(self, root: Optional[TreeNode]):
        self.stack = []
        self.pushAll(root)

    def next(self) -> int:
        """
        @return the next smallest number
        """
        node = self.stack.pop()
        self.pushAll(node.right)
        return node.val

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return len(self.stack) > 0

    def pushAll(self, node: Optional[TreeNode]):
        while node:
            self.stack.append(node)
            node = node.left

# Your BSTIterator object will be instantiated and called as such:
# obj = BSTIterator(root)
# param_1 = obj.next()
# param_2 = obj.hasNext()
# leetcode submit region end(Prohibit modification and deletion)
