from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class NumArray:

    def __init__(self, nums: List[int]):
        self.nums = nums
        self.tree = [0] * (len(nums) + 1)
        for i, num in enumerate(nums, 1):
            self.add(i, num)

    def add(self, index: int, val: int):
        while index < len(self.tree):
            self.tree[index] += val
            index += index & (-index)

    def prefixSum(self, index: int) -> int:
        res = 0
        while index > 0:
            res += self.tree[index]
            index -= index & (-index)
        return res

    def update(self, index: int, val: int) -> None:
        self.add(index + 1, val - self.nums[index])
        self.nums[index] = val

    def sumRange(self, left: int, right: int) -> int:
        return self.prefixSum(right + 1) - self.prefixSum(left)

    # def __init__(self, nums: List[int]):
    #     self.nums = nums
    #     self.tree = [0] * (4 * len(nums))
    #     self.build_tree(nums, self.tree, 0, 0, len(nums) - 1)
    #
    # # kd tree
    # def build_tree(self, nums, tree, node, start, end):
    #     if start == end:
    #         tree[node] = nums[start]
    #     else:
    #         mid = (start + end) // 2
    #         self.build_tree(nums, tree, 2 * node + 1, start, mid)
    #         self.build_tree(nums, tree, 2 * node + 2, mid + 1, end)
    #         tree[node] = tree[2 * node + 1] + tree[2 * node + 2]
    #
    # def update_tree(self, nums, tree, node, start, end, index, val):
    #     if start == end:
    #         nums[index] = val
    #         tree[node] = val
    #     else:
    #         mid = (start + end) // 2
    #         if start <= index <= mid:
    #             self.update_tree(nums, tree, 2 * node + 1, start, mid, index, val)
    #         else:
    #             self.update_tree(nums, tree, 2 * node + 2, mid + 1, end, index, val)
    #         tree[node] = tree[2 * node + 1] + tree[2 * node + 2]
    #
    # def query_tree(self, tree, node, start, end, left, right):
    #     if right < start or end < left:
    #         return 0
    #     if left <= start and end <= right:
    #         return tree[node]
    #     mid = (start + end) // 2
    #     return self.query_tree(tree, 2 * node + 1, start, mid, left, right) + \
    #            self.query_tree(tree, 2 * node + 2, mid + 1, end, left, right)
    #
    # def update(self, index: int, val: int) -> None:
    #     self.update_tree(self.nums, self.tree, 0, 0, len(self.nums) - 1, index, val)
    #
    # def sumRange(self, left: int, right: int) -> int:
    #     return self.query_tree(self.tree, 0, 0, len(self.nums) - 1, left, right)

# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(index,val)
# param_2 = obj.sumRange(left,right)
# leetcode submit region end(Prohibit modification and deletion)
