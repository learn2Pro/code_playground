# 307. Range Sum Query - Mutable
from typing import List


class NumArray:

    def __init__(self, nums: List[int]):
        self.size = len(nums)
        self.BIT = [0] * (self.size + 1)
        self.origin = nums
        for i in range(self.size):
            self.build(i, nums[i])

    def build(self, index: int, val: int):
        index += 1
        while index <= self.size:
            self.BIT[index] += val
            index += (index & -index)

    def update(self, i: int, val: int) -> None:
        delta = val - self.origin[i]
        self.origin[i] = val
        self.build(i, delta)

    def getSum(self, index: int) -> int:
        index += 1
        ans = 0
        while index > 0:
            ans += self.BIT[index]
            index -= (index & -index)
        return ans

    def sumRange(self, i: int, j: int) -> int:
        return self.getSum(j) - self.getSum(i - 1)


# class NumArray:
#
#     def __init__(self, nums: List[int]):
#         self.size = len(nums)
#         self.seg = [0] * (self.size << 2)
#
#         def build(i: int, j: int, index: int) -> None:
#             if i > j: return
#             if i == j: self.seg[index] = nums[i];return
#             mid = (i + j) >> 1
#             build(i, mid, index * 2)
#             build(mid + 1, j, index * 2 + 1)
#             self.seg[index] = self.seg[index * 2] + self.seg[index * 2 + 1]
#
#         build(0, len(nums) - 1, 1)
#
#     def update(self, i: int, val: int) -> None:
#         def updateRange(s: int, e: int, index: int) -> None:
#             if s > e: return
#             if s == e: self.seg[index] = val;return
#             mid = (s + e) >> 1
#             if i <= mid:
#                 updateRange(s, mid, index * 2)
#             else:
#                 updateRange(mid + 1, e, index * 2 + 1)
#             self.seg[index] = self.seg[index * 2] + self.seg[index * 2 + 1]
#
#         updateRange(0, self.size - 1, 1)
#
#     def sumRange(self, i: int, j: int) -> int:
#         def query(s: int, e: int, l: int, r: int, index: int) -> int:
#             if l > r: return 0
#             if s == l and r == e: return self.seg[index]
#             mid = (s + e) >> 1
#             return query(s, mid, l, min(r, mid), index * 2) + query(mid + 1, e, max(mid + 1, l), r, index * 2 + 1)
#
#         return query(0, self.size - 1, i, j, 1)


'''
["NumArray","sumRange","update","sumRange"]
[[[1,3,5]],[0,2],[1,2],[0,2]]
["NumArray","sumRange","update","sumRange","sumRange","sumRange"]
[[[1,3,5,7]],[0,2],[1,2],[0,2],[0,0],[1,1]]
["NumArray","sumRange","update","sumRange","sumRange","update","update","sumRange","sumRange","update","update"]
[[[-28,-39,53,65,11,-56,-65,-39,-43,97]],[5,6],[9,27],[2,3],[6,7],[1,-82],[3,-72],[3,7],[1,8],[5,13],[4,-67]]
'''
if __name__ == '__main__':
    instance = NumArray([1, 3, 5])
    assert instance.sumRange(0, 2) == 9
    instance.update(1, 2)
    assert instance.sumRange(0, 2) == 8
    instance = NumArray([1, 3, 5, 7])
    assert instance.sumRange(0, 2) == 9
    instance.update(1, 2)
    assert instance.sumRange(0, 2) == 8
    assert instance.sumRange(0, 0) == 1
    assert instance.sumRange(1, 1) == 2
    instance = NumArray([-28, -39, 53, 65, 11, -56, -65, -39, -43, 97])
