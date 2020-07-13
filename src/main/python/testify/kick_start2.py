from functools import lru_cache
from sys import stdin
from typing import List, Iterator


# T[i][]
def findExpected(step0, step1, graph, size):
    _visited0, _visited1 = [0] * size, [0] * size
    _path, ans = [], 0

    def dfs(index):
        _path.append(index)
        path_size = len(_path)
        for i in range(path_size - 1, -1, -step0):
            _visited0[_path[i]] += 1
        for j in range(path_size - 1, -1, -step1):
            _visited1[_path[j]] += 1
        if index in graph:
            for dst in graph[index]:
                dfs(dst)
        _path.pop()

    dfs(0)

    return sum(map(lambda x: x[0] / size + x[1] / size - x[0] * x[1] / size / size, zip(_visited0, _visited1)))


def echo():
    size = int(stdin.readline())
    for i in range(size):
        parts = stdin.readline().rstrip().split(' ')
        m = int(parts[0])
        if m == 1:
            print("Case #{}: {}".format(i + 1, 1.0))
            stdin.readline()
            continue
        graph = {}
        for src, dst in enumerate(stdin.readline().split(' ')):
            lst = graph.get(int(dst) - 1, [])
            lst.append(src + 1)
            graph[int(dst) - 1] = lst
        ans = findExpected(int(parts[1]), int(parts[2]), graph, m)
        print("Case #{}: {}".format(i + 1, ans))


'''
9
1 1 1

4 1 1
1 1 1
3 2 2
1 1
4 4 4
1 1 1
8 2 3
1 1 3 4 4 3 4
10 3 4
1 1 1 1 1 1 1 1 1
4 3 1
1 2 3
2 1 1
1
3 1 1
1 2
'''
if __name__ == '__main__':
    echo()
