# 98. Validate Binary Search Tree

from src.main.python.TreeNode import TreeNode

'''
[2,1,3]
[]
[2]
[1,2]
[2,1]'''


class _98_Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        stack = []
        last = None
        node = root
        while node: stack.append(node);node = node.left;
        while stack:
            current = stack.pop()
            if last is not None and current.val <= last:
                return False
            last = current.val
            current = current.right
            while current: stack.append(current);current = current.left;
        return True


if __name__ == '__main__':
    instance = _98_Solution
    n0, n1, n2 = TreeNode(0), TreeNode(-1), TreeNode(3)
    n0.right = n1
    assert instance.isValidBST(instance, n0) == False
