# 129. Sum Root to Leaf Numbers
from src.main.python.TreeNode import TreeNode

'''[1,2,3]
[1]
[1,2]
[1,2,null,3]
[4,9,0,5,1]
[1,null,2]'''


class _129_Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        if root is None: return 0
        stack = [(root, root.val)]
        ans = 0
        while stack:
            current, val = stack.pop()
            if current.left is None and current.right is None:
                ans += val
            if current.right:
                stack.append((current.right, val * 10 + current.right.val))
            if current.left:
                stack.append((current.left, val * 10 + current.left.val))
        return ans


# def sumNumbers(self, root: TreeNode) -> int:
#     sum = 0
#
#     def dfs(previous: int, node: TreeNode) -> None:
#         if node is None:
#             return
#         if node.left is None and node.right is None:
#             nonlocal sum
#             sum += previous * 10 + node.val
#             return
#         dfs(previous * 10 + node.val, node.left)
#         dfs(previous * 10 + node.val, node.right)
#
#     dfs(0, root)
#     return sum


if __name__ == '__main__':
    instance = _129_Solution
    # assert instance.sumNumbers(instance,)
