# 752. Open the Lock
import collections
from typing import List


class _752_Solution:

    def openLock(self, deadends: List[str], target: str) -> int:
        dp = [[[[0x7fffffff] * 10 for _ in range(10)] for _ in range(10)] for _ in range(10)]
        dict = set(deadends)
        if '0000' in dict: return -1
        dp[0][0][0][0] = 0

        def update(i0, i1, i2, i3):
            dp[i0][i1][i2][i3] = min(dp[i0][i1][i2][i3], min(dp[i0 - 1][i1][i2][i3], dp[(i0 + 1) % 10][i1][i2][i3],
                                                             dp[i0][i1 - 1][i2][i3],
                                                             dp[i0][(i1 + 1) % 10][i2][i3], dp[i0][i1][i2 - 1][i3],
                                                             dp[i0][i1][(i2 + 1) % 10][i3],
                                                             dp[i0][i1][i2][i3 - 1],
                                                             dp[i0][i1][i2][(i3 + 1) % 10]) + 1)

        for i0 in range(10):
            for i1 in range(10):
                for i2 in range(10):
                    for i3 in range(10):
                        if str(i0) + str(i1) + str(i2) + str(i3) in dict: continue
                        update(i0, i1, i2, i3)
        for i0 in reversed(range(10)):
            for i1 in reversed(range(10)):
                for i2 in reversed(range(10)):
                    for i3 in reversed(range(10)):
                        if str(i0) + str(i1) + str(i2) + str(i3) in dict: continue
                        update(i0, i1, i2, i3)
        for i0 in range(10):
            for i1 in range(10):
                for i2 in range(10):
                    for i3 in range(10):
                        if str(i0) + str(i1) + str(i2) + str(i3) in dict: continue
                        update(i0, i1, i2, i3)
        num = dp[int(target[0])][int(target[1])][int(target[2])][int(target[3])]
        return -1 if num == 0x7fffffff else num

    # use bfs/one end
    def openLock(self, deadends: List[str], target: str) -> int:
        deads = set(deadends)
        queue, level = ['0000'], 0
        if '0000' in deads: return -1
        while queue:
            size = len(queue)
            for i in range(size):
                current = queue.pop(0)
                if current == target: return level
                for j in range(4):
                    incr = current[:j] + str((int(current[j]) + 9) % 10) + current[j + 1:]
                    decr = current[:j] + str((int(current[j]) + 1) % 10) + current[j + 1:]
                    if incr not in deads:
                        queue.append(incr)
                        deads.add(incr)
                    if decr not in deads:
                        queue.append(decr)
                        deads.add(decr)
            level += 1
        return -1

    # use bfs/two end/0
    def openLock(self, deadends: List[str], target: str) -> int:
        deads = set(deadends)
        begin, end, level = {'0000'}, {target}, 0
        if '0000' in deads: return -1
        next_d = {}
        for d in range(10):
            next_d[str(d)] = (str((d - 1 + 10) % 10), str((d + 1 + 10) % 10))

        while begin and end:
            if len(begin) > len(end):
                begin, end = end, begin
            tmp = set()
            for current in begin:
                if current in end: return level
                if current in deads: continue
                deads.add(current)
                for j in range(4):
                    incr = current[:j] + next_d[current[j]][0] + current[j + 1:]
                    decr = current[:j] + next_d[current[j]][1] + current[j + 1:]
                    if incr not in deads:
                        tmp.add(incr)
                    if decr not in deads:
                        tmp.add(decr)
            level += 1
            begin = tmp
        return -1

    # use bfs/two end/1
    def openLock(self, deadends: List[str], target: str) -> int:
        deads = set(deadends)
        begin, end, level = {'0000'}, {target}, 0
        if '0000' in deads: return -1
        next_d = {}
        for d in range(10):
            next_d[str(d)] = (str((d - 1 + 10) % 10), str((d + 1 + 10) % 10))

        while begin and end:
            tmp = set()
            for current in begin:
                if current in end: return level
                deads.add(current)
                for j in range(4):
                    incr = current[:j] + next_d[current[j]][0] + current[j + 1:]
                    decr = current[:j] + next_d[current[j]][1] + current[j + 1:]
                    if incr not in deads:
                        tmp.add(incr)
                        deads.add(incr)
                    if decr not in deads:
                        tmp.add(decr)
                        deads.add(decr)
            level += 1
            begin = tmp
        return -1


'''
["0201","0101","0102","1212","2002"]
"0202"
["8888"]
"0009"
["8887","8889","8878","8898","8788","8988","7888","9888"]
"8888"
["0000"]
"8888"
["0001"]
"2222"
["0001"]
"9999"
["0001","0010","0100","1000"]
"2222"
["0001","0010","0100","1000"]
"9999"
["0001","0010","0100","1000"]
"8998"
'''
if __name__ == '__main__':
    tar = _752_Solution()
    assert tar.openLock(["0001", "0010", "0100", "1000"], "2222") == 10
    assert tar.openLock(["0000"], "8888") == -1
    assert tar.openLock(["0001"], "9999") == 4
    assert tar.openLock(["0201", "0101", "0102", "1212", "2002"], "0202") == 6
