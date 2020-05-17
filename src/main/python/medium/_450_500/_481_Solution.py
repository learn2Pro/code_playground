# 481. Magical String
arr = [1, 2, 2]
for i in range(2, 66700):
    arr += [arr[-1] ^ 3] * arr[i]


class _481_Solution:

    def magicalString(self, n: int) -> int:
        return arr[:n].count(1)


if __name__ == '__main__':
    obj = _481_Solution()
    assert obj.magicalString(6) == 3
