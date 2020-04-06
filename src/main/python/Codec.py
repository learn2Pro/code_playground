from src.main.python.TreeNode import TreeNode


class Codec:
    def serialize(self, root: TreeNode) -> str:
        """Encodes a tree to a single string.
        """
        if not root: return ""
        ans = []

        def preorder(node: TreeNode) -> None:
            if node:
                ans.append(str(node.val))
                preorder(node.left)
                preorder(node.right)
            else:
                ans.append("null")

        preorder(root)
        return ",".join(ans)

    def deserialize(self, data: str) -> TreeNode:
        """Decodes your encoded data to tree.
        """
        if not data: return None
        preorder = iter(data.split(','))

        def builtTree():
            curr = next(preorder)
            if curr == 'null': return None
            node = TreeNode(int(curr))
            node.left = builtTree()
            node.right = builtTree()
            return node

        return builtTree()

    # def serialize(self, root: TreeNode) -> str:
    #     """Encodes a tree to a single string.
    #     """
    #     if not root: return ""
    #     ans = []
    #
    #     def preorder(node: TreeNode) -> None:
    #         if node:
    #             ans.append(str(node.val))
    #             preorder(node.left)
    #             preorder(node.right)
    #
    #     preorder(root)
    #
    #     return ",".join(ans).rstrip(",null")
    #
    # def deserialize(self, data: str) -> TreeNode:
    #     """Decodes your encoded data to tree.
    #     """
    #     if not data: return None
    #     preorder = [int(num) for num in data.split(',')]
    #     preorder.reverse()
    #
    #     def deser(minimal, maximal) -> TreeNode:
    #         if preorder and minimal < preorder[-1] < maximal:
    #             node = TreeNode(preorder.pop())
    #             node.left = deser(minimal, node.val)
    #             node.right = deser(node.val, maximal)
    #             return node
    #
    #     return deser(-0x7fffffff, 0x7fffffff)


# def deserialize(self, data: str) -> TreeNode:
#     """Decodes your encoded data to tree.
#     """
#     if not data: return None
#     preorder = [int(num) for num in data.split(',')]
#     inorder = sorted(preorder)
#
#     def buildTree(stop: int) -> TreeNode:
#         if inorder and inorder[-1] != stop:
#             root = TreeNode(preorder.pop())
#             root.left = buildTree(root.val)
#             inorder.pop()
#             root.right = buildTree(stop)
#             return root
#
#     preorder.reverse()
#     inorder.reverse()
#     return buildTree(None)


'''
[2,1,3]
[1,2]
[1,null,3]
[]
[1]
[1,2,null,3]
[1,null,3,4]
[1,null,3,null,5]
[41,37,44,24,39,42,48,1,35,38,40,null,43,46,49,0,2,30,36,null,null,null,null,null,null,45,47,null,null,null,null,null,4,29,32,null,null,null,null,null,null,3,9,26,null,31,34,null,null,7,11,25,27,null,null,33,null,6,8,10,16,null,null,null,28,null,null,5,null,null,null,null,null,15,19,null,null,null,null,12,null,18,20,null,13,17,null,null,22,null,14,null,null,21,23]
'''
if __name__ == '__main__':
    obj = Codec()
    assert obj.serialize(obj.deserialize("1,2,null,null,null")) == "1,2,null,null,null"
    assert obj.serialize(obj.deserialize("1,null,null")) == "1,null,null"
    assert obj.serialize(obj.deserialize("1,2")) == "1,2"
    assert obj.serialize(obj.deserialize("2,1,3")) == "2,1,3"
    assert obj.serialize(obj.deserialize("1,null,3")) == "1,null,3"
    assert obj.serialize(obj.deserialize("")) == ""
    assert obj.serialize(obj.deserialize("1")) == "1"
    assert obj.serialize(obj.deserialize("1,2,null,3")) == "1,2,null,3"
