from sys import stdin
from typing import List, Iterator


# T[i][]
def findMinimal(lst: List[int]):
    t_i0 = t_i1 = t_i2 = t_i3 = 0
    last = -1
    for i, item in enumerate(lst):
        if i == 0 or item == last:
            last = item
            continue
        elif item > last:
            t_i0, t_i1, t_i2, t_i3 = min(t_i0 + 1, t_i1 + 1, t_i2 + 1, t_i3 + 1), \
                                     min(t_i0, t_i1 + 1, t_i2 + 1, t_i3 + 1), \
                                     min(t_i0, t_i1, t_i2 + 1, t_i3 + 1), \
                                     min(t_i0, t_i1, t_i2, t_i3 + 1)
        else:
            t_i0, t_i1, t_i2, t_i3 = min(t_i0 + 1, t_i1, t_i2, t_i3), \
                                     min(t_i0 + 1, t_i1 + 1, t_i2, t_i3), \
                                     min(t_i0 + 1, t_i1 + 1, t_i2 + 1, t_i3), \
                                     min(t_i0 + 1, t_i1 + 1, t_i2 + 1, t_i3 + 1)
        last = item
    return min(t_i0, t_i1, t_i2, t_i3)


def echo():
    size = int(stdin.readline())
    for i in range(size):
        s0 = int(stdin.readline())
        splits = [num for num in map(lambda x: int(x), stdin.readline().split(' '))]
        ans = findMinimal(splits)
        print("Case #{}: {}".format(i + 1, ans))


if __name__ == '__main__':
    echo()
