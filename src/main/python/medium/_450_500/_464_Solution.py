# 464. Can I Win
class _464_Solution:
    def canIWin(self, maxChoosableInteger: int, desiredTotal: int) -> bool:
        def backTrack(curr: int, k) -> bool:
            if memo[k] != 0: return memo[k] > 0
            if curr <= 0: return False
            for i in range(maxChoosableInteger):
                if not (k & 1 << i) and not backTrack(curr - i - 1, k | (1 << i)):
                    memo[k] = 1
                    return True
            memo[k] = -1
            return False

        memo = [0] * (1 << 20)
        acc = (1 + maxChoosableInteger) * maxChoosableInteger // 2
        if desiredTotal < 2: return True
        if acc < desiredTotal:
            return False
        elif acc == desiredTotal:
            return maxChoosableInteger % 2 == 1
        return backTrack(desiredTotal, 0)


if __name__ == '__main__':
    obj = _464_Solution()
    assert obj.canIWin(20, 210) == False
    assert obj.canIWin(10, 0) == True
    assert obj.canIWin(1, 2) == False
    assert obj.canIWin(10, 11) == False
    assert obj.canIWin(20, 15) == True
    assert obj.canIWin(20, 11) == True
