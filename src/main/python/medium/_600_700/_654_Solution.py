from typing import List

from TreeNode import TreeNode


class _654_Solution:
    # use recursive
    def constructMaximumBinaryTree(self, nums: List[int]) -> TreeNode:
        mapping = {num: index for index, num in enumerate(nums)}

        def rebuild(start, end):
            if start > end:
                return None
            maximal = max(nums[start:end + 1])
            node = TreeNode(maximal)
            node.left = rebuild(start, mapping[maximal] - 1)
            node.right = rebuild(mapping[maximal] + 1, end)
            return node

        return rebuild(0, len(nums) - 1)

    # use stack
    def constructMaximumBinaryTree(self, nums: List[int]) -> TreeNode:
        if not nums: return None
        stack = []
        for num in nums:
            if not stack or stack[-1].val > num:
                node = TreeNode(num)
                if stack: stack[-1].right = node
                stack.append(node)
            else:
                while stack and stack[-1].val < num:
                    node = stack.pop()
                right = TreeNode(num)
                if stack: stack[-1].right = right
                stack.append(right)
                stack[-1].left = node
        return stack[0]
