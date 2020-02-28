from src.main.python.TreeNode import TreeNode


class BSTIterator:

    def __init__(self, root: TreeNode):
        self.node = root
        self.stack = []
        while root: self.stack.append(root);root = root.left

    def next(self) -> int:
        """
        @return the next smallest number
        """
        ans = self.stack.pop()
        value = ans.val
        ans = ans.right
        while ans: self.stack.append(ans);ans = ans.left
        return value

    def hasNext(self) -> bool:
        """
        @return whether we have a next smallest number
        """
        return self.stack
