# 636. Exclusive Time of Functions
from typing import List


class _636_Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        exclusive, stack, gaps = [0] * n, [], []
        for log in logs:
            splits = log.split(":")
            id, offset = int(splits[0]), int(splits[2])
            if splits[1] == 'start':
                gaps.append(0)
                stack.append(offset)
            else:
                start = stack.pop()
                gap = gaps.pop()
                exclusive[id] += (offset - start + 1 - gap)
                if gaps: gaps.append(gaps.pop() + offset - start + 1)
        return exclusive

    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        if not logs: return []
        exclusive = [0] * n
        splits = logs[0].split(":")
        stack, time = [int(splits[0])], int(splits[2])
        for i in range(1, len(logs)):
            curr = logs[i].split(":")
            gap = (int(curr[2]) - time)
            exclusive[stack[-1]] += gap
            time += gap
            if curr[1] == "start":
                stack.append(int(curr[0]))
            else:
                exclusive[stack[-1]] += 1
                time += 1
                stack.pop()
        return exclusive

    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        # Stack
        res, stack = [0] * n, []
        for log in logs:
            log_split = log.split(":")
            id, status, timestamp = int(log_split[0]), log_split[1], int(log_split[2])
            if status == "start":
                if stack:
                    res[stack[-1]] += timestamp - last_timestamp
                stack.append(id)
            else:
                timestamp += 1
                res[stack.pop()] += timestamp - last_timestamp
            last_timestamp = timestamp
        return res


'''
2
["0:start:0","1:start:2","1:end:5","0:end:6"]
1
["0:start:0","0:end:3"]
3
["0:start:0", "1:start:2", "2:start:4", "2:end:7", "1:end:10", "0:end:13"]
5
["0:start:0","1:start:1","2:start:2","3:start:3","3:end:4","2:end:5","1:end:6","4:start:7","4:end:8","0:end:9"]
1
["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
8
["0:start:0","1:start:5","2:start:6","3:start:9","4:start:11","5:start:12","6:start:14","7:start:15","1:start:24","1:end:29","7:end:34","6:end:37","5:end:39","4:end:40","3:end:45","0:start:49","0:end:54","5:start:55","5:end:59","4:start:63","4:end:66","2:start:69","2:end:70","2:start:74","6:start:78","0:start:79","0:end:80","6:end:85","1:start:89","1:end:93","2:end:96","2:end:100","1:end:102","2:start:105","2:end:109","0:end:114"]
'''
if __name__ == '__main__':
    obj = _636_Solution()
    assert obj.exclusiveTime(3, ["0:start:0", "1:start:2", "2:start:4", "2:end:7", "1:end:10", "0:end:13"]) == [5, 5, 4]
    assert obj.exclusiveTime(2, ["0:start:0", "1:start:2", "1:end:5", "0:end:6"]) == [3, 4]
