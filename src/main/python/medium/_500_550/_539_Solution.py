from typing import List


class _539_Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:
        def parse(s):
            fst, snd = s.split(":"), s.split(":")
            return int(fst[0]) * 60 + int(fst[1])
        def diff(ts0, ts1):
            return min(abs(ts0 - ts1), abs(ts0 - ts1 + 24 * 60), abs(ts0 - ts1 - 24 * 60))
        lst = list(map(parse,timePoints))
        minimal = 0x7fffffff
        lst.sort()
        for i in range(len(lst)):
            j = (i + 1) % len(lst)
            minimal = min(minimal, diff(lst[i], lst[j]))
        return minimal


'''
["23:59","00:00"]
["23:58","23:59"]
["21:00","01:00"]
["00:00","2:05","8:00","21:00","23:59","23:00","13:00","2:00","2:03"]
'''
if __name__ == '__main__':
    obj = _539_Solution()
    assert obj.findMinDifference(["00:00", "2:05", "8:00", "21:00", "23:59", "23:00", "13:00", "2:00", "2:03"]) == 1
