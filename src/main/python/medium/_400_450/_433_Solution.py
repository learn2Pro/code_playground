# 433. Minimum Genetic Mutation
from collections import deque
from typing import List


class _433_Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        bankSet = set(bank)
        queue, step, visited = deque([start]), 0, {start}
        while queue:
            size = len(queue)
            for _ in range(size):
                curr = queue.popleft()
                if curr == end: return step
                for i in range(8):
                    for c in ['A', 'C', 'G', 'T']:
                        mutate = curr[:i] + c + curr[i + 1:]
                        if mutate == curr or mutate not in bankSet or mutate in visited: continue
                        queue.append(mutate)
                        visited.add(mutate)
            step += 1
        return -1


if __name__ == '__main__':
    target = _433_Solution()
    assert target.minMutation("AAAAACCC", "AACCCCCC", ["AAAACCCC", "AAACCCCC", "AACCCCCC"]) == 3
