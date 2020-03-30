# 386. Lexicographical Numbers
from typing import List


class _386_Solution:
    # use dfs
    def lexicalOrder(self, n: int) -> List[int]:
        ans = []

        def dfs(curr: int) -> None:
            if curr > n: return
            ans.append(curr)
            for i in range(10):
                if curr * 10 + i <= n:
                    dfs(curr * 10 + i)

        for i in range(1, 10):
            dfs(i)
        return ans

    # use sort
    # def lexicalOrder(self, n: int) -> List[int]:
    #     return sorted([i for i in range(1, n + 1)], key=lambda num: str(num))


if __name__ == '__main__':
    obj = _386_Solution()
    assert obj.lexicalOrder(13) == [1,10,11,12,13,2,3,4,5,6,7,8,9]
