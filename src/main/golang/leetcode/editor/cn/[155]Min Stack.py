
# leetcode submit region begin(Prohibit modification and deletion)
class MinStack:

        def __init__(self):
            """
            initialize your data structure here.
            """
            self.data = []
            self.min = float('inf')

        def push(self, val: int) -> None:
            self.data.append(val)
            self.min = min(self.min, val)

        def pop(self) -> None:
            val = self.data.pop()
            if val == self.min:
                self.min = min(self.data) if self.data else float('inf')

        def top(self) -> int:
            return self.data[-1]

        def getMin(self) -> int:
            return self.min



# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()
# leetcode submit region end(Prohibit modification and deletion)
