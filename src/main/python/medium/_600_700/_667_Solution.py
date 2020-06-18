# 667. Beautiful Arrangement II
from typing import List


class _667_Solution:
    def constructArray(self, n: int, k: int) -> List[int]:
        ans = []
        for i in range(k + 1):
            if i % 2 == 0:
                ans.append(1 + i // 2)
            else:
                ans.append(k + 1 - i // 2)
        for i in range(k + 2, n + 1):
            ans.append(i)
        return ans


'''
4
3
4
2
4
1
5
1
5
2
5
3
10
4
10
6
10
7
10
9
'''
if __name__ == '__main__':
    obj = _667_Solution()
    assert obj.constructArray(4, 3) == [1, 4, 2, 3]
    assert obj.constructArray(3, 1) == [1, 2, 3]
    assert obj.constructArray(3, 2) == [2, 1, 3]
