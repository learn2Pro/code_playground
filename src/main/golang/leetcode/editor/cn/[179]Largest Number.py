# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        nums.sort(key=lambda x: str(x) * 10, reverse=True)
        return str(int(''.join(map(str, nums))))
# leetcode submit region end(Prohibit modification and deletion)
