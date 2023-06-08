class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def __init__(self):
        self.res = []

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return 'X'
        left = self.serialize(root.left)
        right = self.serialize(root.right)
        return str(root.val) + "," + left + "," + right

    def deserialize(self, data):
        """Decodes your encoded data to tree.

        :type data: str
        :rtype: TreeNode
        """

        def consturct(node):
            if not node:
                return None
            n = node.pop(0)
            root = None if n == 'X' else TreeNode(n)
            if not root:
                return root
            root.left = consturct(node)
            root.right = consturct(node)
            return root

        return consturct(data.split(','))
    # Your Codec object will be instantiated and called as such:
    # ser = Codec()
    # deser = Codec()
    # ans = deser.deserialize(ser.serialize(root))
    # leetcode submit region end(Prohibit modification and deletion)
