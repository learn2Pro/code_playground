# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# 623. Add One Row to Tree
'''
[4,2,6,3,1,5]
1
2
[4,2,null,3,1]
1
3
[]
1
1
[1]
1
1
[1,2]
1
2
[1,2,3]
4
3
[1,2,3,4,null,null,5,6,null,null,7]
9
1
[1,2,3,4,null,null,5,6,null,null,7]
9
2
[1,2,3,4,null,null,5,6,null,null,7]
9
3
[1,2,3,4,null,null,5,6,null,null,7]
9
4
[1,2,3,4,null,null,5,6,null,null,7]
9
5
[1,2,3,4,null,null,5,6,null,null,7]
9
6
[1,2,3,4,null,null,5,6,null,null,7]
9
100
'''


class _623_Solution:
    def addOneRow(self, root: TreeNode, v: int, d: int) -> TreeNode:
        if d == 1:
            newly = TreeNode(v)
            newly.left = root
            return newly
        if not root:
            return root
        queue, depth = [root], 1
        while queue:
            size = len(queue)
            for i in range(size):
                current = queue.pop(0)
                if depth == d-1:
                    l, r = current.left, current.right
                    current.left, current.right = TreeNode(v), TreeNode(v)
                    current.left.left, current.right.right = l, r
                else:
                    if current.left:
                        queue.append(current.left)
                    if current.right:
                        queue.append(current.right)
            if depth == d-1:
                break
            depth += 1
        return root

    def addOneRow(self, root: TreeNode, v: int, d: int) -> TreeNode:
        if not root:
            return root
        if d == 1:
            newly = TreeNode(v)
            newly.left = root
            return newly

        def dfs(node, depth):
            if not node:
                return
            if depth == d-1:
                l, r = current.left, current.right
                current.left, current.right = TreeNode(v), TreeNode(v)
                current.left.left, current.right.right = l, r
                return
            else:
                dfs(node.left, depth+1)
                dfs(node.right, depth+1)
        dfs(root,1)
        return root
