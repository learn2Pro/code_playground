# 662. Maximum Width of Binary Tree
'''
[1,3,2,5,3,null,9]
[1,3,null,5,3]
[1,3,2,5]
[1,3,2,5,null,null,9,6,null,null,7]
[1]
[1,null,3]
[1,3,4,5,6,null,7,8]
[0,0,0,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null,null,0,0,null]
[1,1,1,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,null,1,1,null,1,null,1,null,1,null,1,null]
'''


class _662_Solution:
    # use bfs
    def widthOfBinaryTree(self, root: TreeNode) -> int:
        if not root: return 0
        queue, maximal = [[root, 0]], 1
        while queue:
            size = len(queue)
            maximal = max(maximal, queue[-1][1] - queue[0][1] + 1)
            for i in range(size):
                node, pos = queue.pop(0)
                if node.left: queue.append([node.left, 2 * pos])
                if node.right: queue.append([node.right, 2 * pos + 1])
        return maximal

    def widthOfBinaryTree(self, root: TreeNode) -> int:
        if not root: return 0
        mapping, maximal = {}, 1

        def dfs(node, depth, pos):
            nonlocal maximal
            if not node: return
            if depth not in mapping: mapping[depth] = pos
            maximal = max(maximal, pos - mapping.get(depth, 0) + 1)
            dfs(node.left, depth + 1, 2 * pos)
            dfs(node.right, depth + 1, 2 * pos + 1)

        dfs(root, 0, 0)
        return maximal
