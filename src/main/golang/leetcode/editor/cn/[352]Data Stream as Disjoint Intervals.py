from typing import List
# leetcode submit region begin(Prohibit modification and deletion)
from sortedcontainers import SortedDict

class SummaryRanges:

    def __init__(self):
        self.intervals = SortedDict()

    def addNum(self, val: int) -> None:
        intervals_ = self.intervals
        keys_ = self.intervals.keys()
        values_ = self.intervals.values()

        # 找到 l1 最小的且满足 l1 > val 的区间 interval1 = [l1, r1]
        # 如果不存在这样的区间，interval1 为 len(intervals)
        interval1 = intervals_.bisect_right(val)
        # 找到 l0 最大的且满足 l0 <= val 的区间 interval0 = [l0, r0]
        # 在有序集合中，interval0 就是 interval1 的前一个区间
        # 如果不存在这样的区间，interval0 为尾迭代器
        interval0 = (len(intervals_) if interval1 == 0 else interval1 - 1)

        if interval0 != len(intervals_) and keys_[interval0] <= val <= values_[interval0]:
            # 情况一
            return
        else:
            left_aside = (interval0 != len(intervals_) and values_[interval0] + 1 == val)
            right_aside = (interval1 != len(intervals_) and keys_[interval1] - 1 == val)
            if left_aside and right_aside:
                # 情况四
                left, right = keys_[interval0], values_[interval1]
                intervals_.popitem(interval1)
                intervals_.popitem(interval0)
                intervals_[left] = right
            elif left_aside:
                # 情况二
                intervals_[keys_[interval0]] += 1
            elif right_aside:
                # 情况三
                right = values_[interval1]
                intervals_.popitem(interval1)
                intervals_[val] = right
            else:
                # 情况五
                intervals_[val] = val

    def getIntervals(self) -> List[List[int]]:
        # 这里实际上返回的是 List[Tuple[int, int]] 类型
        # 但 Python 的类型提示不是强制的，因此也可以通过
        return list(self.intervals.items())


# Your SummaryRanges object will be instantiated and called as such:
# obj = SummaryRanges()
# obj.addNum(value)
# param_2 = obj.getIntervals()
# leetcode submit region end(Prohibit modification and deletion)
