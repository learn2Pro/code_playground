from collections import deque

from src.main.python.TreeNode import TreeNode


class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        if not root: return ""
        queue, ans = deque([root]), []
        while queue:
            curr = queue.popleft()
            if curr is None:
                ans.append("null")
            else:
                ans.append(str(curr.val))
                queue.append(curr.left)
                queue.append(curr.right)
        return ",".join(ans).rstrip(',null')

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """
        if not data: return None
        items = deque(data.split(','))
        root, n = TreeNode(items.popleft()), len(items)
        nodeQ =deque([root])
        front = 0
        while items:
            curr = nodeQ.popleft()
            item = items.popleft()
            if item != "null":
                curr.left = TreeNode(int(item))
                nodeQ.append(curr.left)
            if not items: break
            item = items.popleft()
            if item != "null":
                curr.right = TreeNode(int(item))
                nodeQ.append(curr.right)
        return root

    # def serialize(self, root):
    #     """Encodes a tree to a single string.
    #
    #     :type root: TreeNode
    #     :rtype: str
    #     """
    #     if not root: return ""
    #     ans0 = []
    #
    #     def preorder(node: TreeNode) -> None:
    #         if node:
    #             ans0.append(str(node.val))
    #             preorder(node.left)
    #             preorder(node.right)
    #         else:
    #             ans0.append("null")
    #
    #     preorder(root)
    #     return ','.join(ans0)
    #
    # def deserialize(self, data):
    #     """Decodes your encoded data to tree.
    #
    #     :type data: str
    #     :rtype: TreeNode
    #     """
    #     if not data or len(data) == 0: return None
    #     preorder = iter(data.split(','))
    #
    #     def buildTree() -> TreeNode:
    #         curr = next(preorder)
    #         if curr == "null": return None
    #         node = TreeNode(int(curr))
    #         node.left = buildTree()
    #         node.right = buildTree()
    #         return node
    #
    #     return buildTree()


if __name__ == '__main__':
    obj = Codec()
    assert obj.serialize(obj.deserialize("3,2,4,3")) == "3,2,4,3"
    assert obj.serialize(obj.deserialize("3,2,3,null,null,null,4,null,null")) == "3,2,3,null,4,null,null"
    assert obj.serialize(obj.deserialize("1,null,null")) == "1,null,null"
    assert obj.serialize(obj.deserialize("1,2#2,1")) == "1,2#2,1"
