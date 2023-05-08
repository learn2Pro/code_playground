# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def __init__(self):
        self.search = [
            (1000, "M"),
            (900, "CM"),
            (500, "D"),
            (400, "CD"),
            (100, "C"),
            (90, "XC"),
            (50, "L"),
            (40, "XL"),
            (10, "X"),
            (9, "IX"),
            (5, "V"),
            (4, "IV"),
            (1, "I")
        ]

    def intToRoman(self, num: int) -> str:
        res = ""
        for key, value in self.search:
            while num >= key:
                res += value
                num -= key
            if num == 0:
                break
        return res
# leetcode submit region end(Prohibit modification and deletion)
