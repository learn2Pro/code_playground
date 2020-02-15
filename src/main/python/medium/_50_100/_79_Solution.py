# 79. Word Search
from typing import List

'''
[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
"ABCCED"
[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
"ABCD"
[]
"A"
[[]]
"A"
[["A"]]
"A"
[["A"]]
"B"
[["a","a"]]
"aaa"
[["C","A","A"],["A","A","A"],["B","C","D"]]
"AAB"
'''


class _79_Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        visited = set()
        m = len(board)
        if m == 0: return False
        n = len(board[0])
        if n == 0: return False

        def dfs(i: int, j: int, word_index: int) -> bool:
            if word_index == len(word): return True
            if i < 0 or i >= m or j < 0 or j >= n: return False
            if (board[i][j] == word[word_index]):
                visited.add((i, j))
                if (i + 1, j) not in visited:
                    finded = dfs(i + 1, j, word_index + 1)
                    if (i + 1, j) in visited: visited.remove((i + 1, j))
                    if (finded): return True
                if (i - 1, j) not in visited:
                    finded = dfs(i - 1, j, word_index + 1)
                    if (i - 1, j) in visited: visited.remove((i - 1, j))
                    if (finded): return True
                if (i, j - 1) not in visited:
                    finded = dfs(i, j - 1, word_index + 1)
                    if (i, j - 1) in visited: visited.remove((i, j - 1))
                    if (finded): return True
                if (i, j + 1) not in visited:
                    finded = dfs(i, j + 1, word_index + 1)
                    if (i, j + 1) in visited: visited.remove((i, j + 1))
                    if (finded): return True
                return False
            else:
                return False

        for r in range(m):
            for c in range(n):
                if board[r][c] != word[0]: continue
                if (dfs(r, c, 0)): return True
                visited.clear()
        return False


if __name__ == '__main__':
    instance = _79_Solution
    assert instance.exist(instance, [["C", "A", "A"], ["A", "A", "A"], ["B", "C", "D"]], "AAB")
    assert not instance.exist(instance, [['a', 'a']], "aaa")
    assert instance.exist(instance, [['A', 'B', 'C', 'E'], ['S', 'F', 'C', 'S'], ['A', 'D', 'E', 'E']], "ABCCED")
    assert instance.exist(instance, [['A', 'B', 'C', 'E'], ['S', 'F', 'C', 'S'], ['A', 'D', 'E', 'E']], "SEE")
    assert not instance.exist(instance, [['A', 'B', 'C', 'E'], ['S', 'F', 'C', 'S'], ['A', 'D', 'E', 'E']], "ABCB")
