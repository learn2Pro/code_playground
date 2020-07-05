# 621. Task Scheduler
import heapq
from typing import List


class _621_Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        container = [0] * 26
        for task in tasks:
            container[ord(task) - ord('A')] += 1
        container.sort()
        idle = (container[-1] - 1) * n
        for i in range(25):
            if container[i] == 0: continue
            idle -= min(container[i], container[-1] - 1)
        return len(tasks) if idle < 0 else idle + len(tasks)


if __name__ == '__main__':
    obj = _621_Solution()
    assert obj.leastInterval(["A", "A", "A", "B", "B", "B"], 2) == 8
    assert obj.leastInterval(["A", "A", "A", "B", "B", "B"], 0) == 6
    assert obj.leastInterval(["A", "A", "A", "A", "A", "A", "B", "C", "D", "E", "F", "G"], 2) == 16
