# 228. Summary Ranges
from typing import List

'''
[0,1,2,4,5,7]
[0,2,3,4,6,8,9]
[]
[21]
[1,2]
[1,2,3]
'''


class _228_Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        ans = []
        if not nums: return ans
        expect = nums[-1] + 1
        for num in nums:
            if num == expect: expect += 1;continue
            if len(ans) != 0 and expect - 1 != int(ans[-1]):
                ans.append(ans.pop() + "->" + str(expect - 1))
            ans.append(str(num))
            expect = num + 1
        if len(ans) != 0 and expect - 1 != int(ans[-1]):
            ans.append(ans.pop() + "->" + str(expect - 1))
        return ans


if __name__ == "__main__":
    instance = _228_Solution()
    assert instance.summaryRanges([0]) == ["0"]
    assert instance.summaryRanges([0, 2, 3, 4, 6, 8, 9]) == ["0", "2->4", "6", "8->9"]
    assert instance.summaryRanges([0, 1, 2, 4, 5, 7]) == ["0->2", "4->5", "7"]
