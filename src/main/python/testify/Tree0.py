from typing import List

from TreeNode import TreeNode


def reconstructInAndPre0(pre: List[int], inorder: List[int]):
    mapping = {value: index for index, value in enumerate(inorder)}

    def traversal(start, end):
        if start > end:
            return None
        v = pre.pop(0)
        node = TreeNode(v)
        node.left = traversal(start, mapping[v] - 1)
        node.right = traversal(mapping[v] + 1, end)
        return node

    return traversal(0, len(inorder) - 1)


def reconstructInAndPre1(pre: List[int], inorder: List[int]):
    v = pre.pop(0)
    root, node, index = TreeNode(v), None, 0
    stack = [root]
    for i in range(1, len(pre)):
        current = TreeNode(pre[i])
        while stack and stack[-1].val == inorder[index]:
            node = stack.pop()
            index += 1
        if not node:
            stack[-1].left = current
        else:
            node.right = current
            node = None
        stack.append(current)
    return root


def countPalindromeSubstrings(s: str):
    def manachers(input):
        A = '@#' + '#'.join(input) + '#$'
        radius = [0] * len(A)
        center = right = 0
        for i in range(1, len(A) - 1):
            if i < right:
                radius[i] = min(right - i, radius[2 * center - i])
            while A[i - radius[i] - 1] == A[i + radius[i] + 1]:
                radius[i] += 1
            if i + radius[i] > right:
                center, right = i, i + radius[i]
        return sum((v + 1) // 2 for v in radius)

    return manachers(s)


def maxPalindromSubString(s: str):
    def manachers(input):
        A = '@#' + '#'.join(input) + '#$'
        radius, maximal = [0] * len(A), 0
        center = right = 0
        for i in range(1, len(A) - 1):
            if i < right:
                radius[i] = min(right - i, radius[2 * center - i])
            while A[i - radius[i] - 1] == A[i + radius[i] + 1]:
                radius[i] += 1
            if i + radius[i] > right:
                center, right = i, i + radius[i]
            maximal = max(maximal, radius[i])
        return maximal
    return manachers(s)
