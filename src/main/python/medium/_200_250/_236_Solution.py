# 236. Lowest Common Ancestor of a Binary Tree
from src.main.python.TreeNode import TreeNode


class _236_Solution:
    # recusive
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if p==q:return p
        if root in [None, p, q]: return root
        left, right = (self.lowestCommonAncestor(self, kid, p, q) for kid in (root.left, root.right))
        return root if left and right else left or right
    # iterative0
    # def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
    #     # 2->bp,1->ld,0->bd
    #     if not root: return root
    #     if p == q: return p
    #     stack = [(root, 2)]
    #     index, found = -1, False
    #     while stack:
    #         if stack[-1][1] == 0:
    #             stack.pop()
    #             if found and index >= len(stack): index -= 1
    #             continue
    #         parent, state = stack[-1]
    #         child = None
    #         if state == 2:
    #             if parent == p or parent == q:
    #                 if found:
    #                     return stack[index][0]
    #                 else:
    #                     found = True
    #                     index = len(stack) - 1
    #             child = parent.left
    #         else:
    #             child = parent.right
    #         stack[-1] = (parent, state - 1)
    #         if child: stack.append((child, 2))
    #     return None

    # iterative1
    # def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
    #     if not root: return root
    #     if p == q: return p
    #     stack = [root]
    #     parent = {root: None}
    #     while stack:
    #         node = stack.pop()
    #         if node.left:
    #             stack.append(node.left)
    #             parent[node.left] = node
    #         if node.right:
    #             stack.append(node.right)
    #             parent[node.right] = node
    #     path = set()
    #     while p:
    #         path.add(p)
    #         p = parent[p]
    #     while q not in path:
    #         q = parent[q]
    #     return q
    # dfs
    # def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
    #     if not root: return root
    #     if p == q: return p
    #     counter, ans = 0, None
    #
    #     def dfs(node: TreeNode) -> int:
    #         if not node:
    #             return 0
    #         nonlocal counter, ans
    #         left = dfs(node.left)
    #         right = dfs(node.right)
    #         mid = node == p or node == q
    #         if mid + left + right >= 2:
    #             ans = node
    #         return mid or left or right
    #
    #     dfs(root)
    #     return ans
    # def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
    #     if not root: return root
    #
    #     def find(node: TreeNode, target: TreeNode) -> bool:
    #         if not node:
    #             return False
    #         if node == target:
    #             return True
    #         return find(node.left, target) or find(node.right, target)
    #
    #     if p == q: return p
    #     if root == p:
    #         if find(root.left, q) or find(root.right, q):
    #             return root
    #     elif find(root.left, p):
    #         if root == q or find(root.right, q): return root
    #         return self.lowestCommonAncestor( root.left, p, q)
    #     else:
    #         if root == q or find(root.left, q): return root
    #         return self.lowestCommonAncestor( root.right, p, q)

if __name__ == '__main__':
    instance = _236_Solution
    n0 = TreeNode(3)
    n1 = TreeNode(5)
    n2 = TreeNode(1)
    n3 = TreeNode(6)
    n4 = TreeNode(2)
    n5 = TreeNode(0)
    n6 = TreeNode(8)
    n7 = TreeNode(7)
    n8 = TreeNode(4)
    n0.left = n1
    n0.right = n2
    n1.left = n3
    n1.right = n4
    n2.left = n5
    n2.right = n6
    n4.left = n7
    n4.right = n8
    assert instance.lowestCommonAncestor(instance, n0, n1, n8) == n1
