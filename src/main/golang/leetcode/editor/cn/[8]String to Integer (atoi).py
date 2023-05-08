# leetcode submit region begin(Prohibit modification and deletion)
class Automation:
    def __init__(self):
        self.state = "start"
        self.sign = 1
        self.ans = 0
        self.table = {
            "start": ["start", "signed", "in_number", "end"],
            "signed": ["end", "end", "in_number", "end"],
            "in_number": ["end", "end", "in_number", "end"],
            "end": ["end", "end", "end", "end"],
        }

    def getCol(self, c: str) -> int:
        if c.isspace():
            return 0
        elif c == '+' or c == '-':
            return 1
        elif c.isdigit():
            return 2
        else:
            return 3

    def forward(self, c: str):
        self.state = self.table[self.state][self.getCol(c)]
        if self.state == "in_number":
            self.ans = self.ans * 10 + int(c)
            self.ans = min(self.ans, 2 ** 31 - 1) if self.sign == 1 else min(self.ans, 2 ** 31)
        elif self.state == "signed":
            self.sign = 1 if c == '+' else -1


class Solution:
    def myAtoi(self, s: str) -> int:
        au = Automation()
        for c in s:
            au.forward(c)
        return au.sign * au.ans

# leetcode submit region end(Prohibit modification and deletion)
