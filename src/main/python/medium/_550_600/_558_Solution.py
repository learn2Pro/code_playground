# 558. Logical OR of Two Binary Grids Represented as Quad-Trees
from quad.Node import Node


class _558_Solution:
    def intersect(self, quadTree1: 'Node', quadTree2: 'Node') -> 'Node':
        def dfs(left: 'Node', right: 'Node') -> None:
            if left.isLeaf and right.isLeaf:
                left.val |= right.val
                return
            if left.isLeaf:
                left.isLeaf = False
                left.bottomLeft = Node(left.val, True, None, None, None, None)
                left.bottomRight = Node(left.val, True, None, None, None, None)
                left.topLeft = Node(left.val, True, None, None, None, None)
                left.topRight = Node(left.val, True, None, None, None, None)
            if right.isLeaf:
                right.isLeaf = False
                right.bottomLeft = Node(right.val, True, None, None, None, None)
                right.bottomRight = Node(right.val, True, None, None, None, None)
                right.topLeft = Node(right.val, True, None, None, None, None)
                right.topRight = Node(right.val, True, None, None, None, None)
            dfs(left.topLeft, right.topLeft)
            dfs(left.topRight, right.topRight)
            dfs(left.bottomLeft, right.bottomLeft)
            dfs(left.bottomRight, right.bottomRight)

        def merge(root: 'Node') -> None:
            if not root:
                return
            if not root.isLeaf and root.topLeft.isLeaf and root.topRight.isLeaf and root.bottomLeft.isLeaf and root.bottomRight.isLeaf \
                    and root.topLeft.val == root.topRight.val == root.bottomLeft.val == root.bottomRight.val:
                root.val = root.topLeft.val
                root.isLeaf = True
                root.topLeft = root.topRight = root.bottomLeft = root.bottomRight = None
                return
            merge(root.topLeft)
            merge(root.topRight)
            merge(root.bottomLeft)
            merge(root.bottomRight)

        dfs(quadTree1, quadTree2)
        merge(quadTree1)
        return quadTree1

    def intersect(self, quadTree1: 'Node', quadTree2: 'Node') -> 'Node':
        if quadTree1.isLeaf:
            return quadTree1 if quadTree1.val else quadTree2
        elif quadTree2.isLeaf:
            return quadTree2 if quadTree2.val else quadTree1
        tl = self.intersect(quadTree1.topLeft, quadTree2.topLeft)
        tr = self.intersect(quadTree1.topRight, quadTree2.topRight)
        bl = self.intersect(quadTree1.bottomLeft, quadTree2.bottomLeft)
        br = self.intersect(quadTree1.bottomRight, quadTree2.bottomRight)
        if tl.isLeaf and tr.isLeaf and bl.isLeaf and br.isLeaf and tl.val == tr.val == bl.val == br.val:
            return Node(tl.val, True, None, None, None, None)
        else:
            return Node(False, False, tl, tr, bl, br)

'''
[[0,1],[1,1],[1,1],[1,0],[1,0]]
[[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]
[[0,0],[1,1],[0,0],[0,0],[0,0],null,null,null,null,[0,0],[0,0],[0,0],[1,1],[1,0],[0,0],[0,0],[0,0],[1,1],[1,0],[0,0],[0,0],[1,1],[1,0],[1,1],[1,0],[1,1],[1,0],[1,0],[1,1],[1,1],[1,0],[1,0],[1,0],null,null,null,null,null,null,null,null,[1,0],[1,1],[1,1],[1,0],[1,1],[1,0],[1,0],[1,0],[1,0],[1,0],[1,1],[1,0],null,null,null,null,null,null,null,null,[1,1],[1,0],[1,1],[1,0],[1,0],[1,1],[1,1],[1,0]]
[[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[0,0],[1,1],[0,0],[0,0],[0,0],[1,1],[0,0],[0,0],[0,0],[1,1],[0,0],[1,0],[1,0],[1,1],[1,0],[1,1],[1,0],[1,1],[1,0],[1,1],[1,1],[1,0],[1,1],[1,1],[1,1],[1,1],[1,0],[1,1],[1,0],[1,0],[1,1],[1,1],[1,0],[1,0],[1,0],null,null,null,null,[1,1],[1,1],[1,0],[1,0],[1,0],[1,0],[1,1],[1,1],[1,1],[1,1],[1,0],[1,0],null,null,null,null,[1,0],[1,1],[1,0],[1,0],[1,1],[1,0],[1,1],[1,1],[1,0],[1,1],[1,1],[1,0],null,null,null,null,[1,0],[1,1],[1,1],[1,1]]
'''
if __name__ == '__main__':
    obj = _558_Solution()
    n0 = Node(True, True, None, None, None, None)
    n1 = Node(True, True, None, None, None, None)
    n2 = Node(False, True, None, None, None, None)
    n3 = Node(False, True, None, None, None, None)
    tree0 = Node(True, False, n0, n1, n2, n3)
    n10 = Node(False, True, None, None, None, None)
    n11 = Node(False, True, None, None, None, None)
    n12 = Node(True, True, None, None, None, None)
    n13 = Node(True, True, None, None, None, None)
    _n0 = Node(True, True, None, None, None, None)
    _n1 = Node(True, False, n10, n11, n12, n13)
    _n2 = Node(True, True, None, None, None, None)
    _n3 = Node(False, True, None, None, None, None)
    tree1 = Node(True, False, _n0, _n1, _n2, _n3)
    node = obj.intersect(tree0, tree1)
    assert node
