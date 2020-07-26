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


def serializeTree(root: TreeNode):
    stack, ans = [], []
    while root or stack:
        while root:
            stack.append(root)
            ans.append(root.val)
            root = root.left
        ans.append(None)
        root = stack.pop().right
    while ans and not ans[-1]: ans.pop()
    return ans


def deserializeTree(pre: List[int]):
    if not pre: return None
    stack, root = [], TreeNode(pre.pop(0))
    node = root
    while pre:
        while node:
            if stack: stack[-1].left = node
            stack.append(node)
            val = pre.pop(0)
            node = TreeNode(val) if val else None
        val = pre.pop(0)
        node = TreeNode(val) if val else None
        stack.pop().right = node
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


class Dsu:
    def __init__(self, size):
        self.array = [-1] * size

    def find(self, index):
        if self.array[index] < 0:
            return index
        return self.find(self.array[index])

    def union(self, src, dst):
        ancestor0, ancestor1 = self.find(src), self.find(dst)
        if ancestor0 == ancestor1: return False
        s0, s1 = abs(self.array[ancestor0]), abs(self.array[ancestor1])
        if s0 >= s1:
            self.array[ancestor0] -= self.array[ancestor1]
            self.array[ancestor1] = ancestor0
        else:
            self.array[ancestor1] -= self.array[ancestor0]
            self.array[ancestor0] = ancestor1
        return True


class Trie:
    def __init__(self):
        self.lookup = {}

    def add(self, word):
        current = self.lookup
        for c in word:
            if c not in current: current[c] = {}
            current = current[c]
        current['_'] = word

    def prefixCount(self, prefix):
        current = self.lookup
        for c in prefix:
            if c not in current: return -1
            current = current[c]
        ans = 0

        def dfs(lookup):
            nonlocal ans
            if '_' in lookup: ans += 1
            for k, v in lookup.item():
                if k == '_': continue
                dfs(lookup[k])

        dfs(current)
        return ans

    def search(self, word):
        current = self.lookup
        for c in word:
            if c not in current: return -1
            current = current[c]
        return '_' in current


class SegMaxTree:
    def __init__(self, size):
        self.seg = [0] * (size << 2)
        self.size = size

    def updateRange(self, i, j, value):
        if i > j: return

        def update0(index, lo, hi, l, r):
            if l > r: return
            if lo == hi:
                self.seg[index] = value
                return
            mid = (lo + hi) >> 1
            update0(2 * index, lo, mid, l, min(r, mid))
            update0(2 * index + 1, mid + 1, hi, max(l, mid + 1), r)
            self.seg[index] = max(self.seg[2 * index], self.seg[2 * index + 1])

        update0(1, 0, self.size - 1, i, j)

    def update(self, i, value):
        if i < 0 or i >= self.size: return

        def update0(index, lo, hi):
            if lo == hi:
                self.seg[lo] = value
                return
            mid = (lo + hi) >> 1
            if i < mid:
                update0(index * 2, lo, mid)
            else:
                update0(index * 2 + 1, mid + 1, hi)
            self.seg[index] = max(self.seg[2 * index], self.seg[2 * index + 1])

        update0(1, 0, self.size - 1)

    def query(self, i, j):
        if i > j: return -1
        i, j = max(0, i), min(j, self.size - 1)

        def query0(index, lo, hi, l, r):
            if l > r: return 0
            if l == lo and r == hi: return self.seg[index]
            mid = (lo + hi) >> 1
            return max(query0(index * 2, lo, mid, l, min(r, mid)),
                       query0(index * 2 + 1, mid + 1, hi, max(mid + 1, l), r))

        return query0(1, 0, self.size - 1, i, j)


class SegSumTree:
    def __init__(self, size):
        self.seg = [0] * (size << 2)
        self.size = size

    def incrRange(self, i, j, value):
        if i > j: return

        def increment0(index, lo, hi, l, r):
            if l > r: return
            if lo == hi:
                self.seg[index] += value
                return
            mid = (lo + hi) >> 1
            increment0(2 * index, lo, mid, l, min(r, mid))
            increment0(2 * index + 1, mid + 1, hi, max(l, mid + 1), r)
            self.seg[index] = self.seg[2 * index] + self.seg[2 * index + 1]

        increment0(1, 0, self.size - 1, i, j)

    def queryRange(self, i, j):
        if i > j: return 0

        def query0(index, lo, hi, l, r):
            if l > r: return 0
            if l == lo and hi == r: return self.seg[index]
            mid = (lo + hi) >> 1
            return sum(query0(index * 2, lo, mid, l, min(r, mid)),
                       query0(index * 2 + 1, mid + 1, hi, max(l, mid + 1), r))

        return query0(1, 0, self.size - 1, i, j)


if __name__ == '__main__':
    assert serializeTree(deserializeTree([3, 3, 3, None, None, None, 3, None, 3])) \
           == [3, 3, 3, None, None, None, 3, None, 3]
    assert serializeTree(deserializeTree([3, None, 3])) \
           == [3, None, 3]
    assert serializeTree(deserializeTree([3])) \
           == [3]
    assert serializeTree(deserializeTree([3, 1, 3, None, None, None, 2, 5, None, None, 3])) \
           == [3, 1, 3, None, None, None, 2, 5, None, None, 3]
    assert serializeTree(deserializeTree([])) \
           == []
