# leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder:

    def __init__(self):
        self.small, self.large = [], []

    def addNum(self, num):
        import heapq
        heapq.heappush(self.small, -heapq.heappushpop(self.large, num))
        if len(self.large) < len(self.small):
            heapq.heappush(self.large, -heapq.heappop(self.small))

    def findMedian(self):
        if len(self.large) > len(self.small):
            return self.large[0]
        return (self.large[0] - self.small[0]) / 2.0

# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
# leetcode submit region end(Prohibit modification and deletion)
