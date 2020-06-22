from typing import List


class _529_Solution:
    # bfs
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        row = len(board)
        if row == 0: return board
        col = len(board[0])

        def isValid(x: int, y: int) -> bool:
            return x >= 0 and x < row and y >= 0 and y < col

        def mineSize(x: int, y: int) -> int:
            size = 0
            for offset0, offset1 in [(0, 1), (0, -1), (1, 0), (-1, 0), (-1, -1), (-1, 1), (1, -1), (1, 1)]:
                if not isValid(x + offset0, y + offset1): continue
                if board[x + offset0][y + offset1] == 'M': size += 1
            return size

        if not isValid(click[0], click[1]): return board
        queue = [(click[0], click[1])]
        while queue:
            cx, cy = queue.pop(0)
            tmp = mineSize(cx, cy)
            if board[cx][cy] == 'M':
                board[cx][cy] = 'X'
                break
            elif board[cx][cy] == 'E':
                if tmp != 0:
                    board[cx][cy] = str(tmp)
                else:
                    board[cx][cy] = 'B'
                    for offset0, offset1 in [(0, 1), (0, -1), (1, 0), (-1, 0), (-1, -1), (-1, 1), (1, -1), (1, 1)]:
                        if not isValid(cx + offset0, cy + offset1) or board[cx + offset0][cy + offset1] != 'E': continue
                        queue.append((cx + offset0, cy + offset1))

        return board

    # dfs
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        offsets = [(0, 1), (0, -1), (1, 0), (-1, 0), (-1, -1), (-1, 1), (1, -1), (1, 1)]
        row, col = len(board), len(board[0])

        def isValid(x: int, y: int) -> bool:
            return x >= 0 and x < row and y >= 0 and y < col

        def mineSize(x: int, y: int) -> int:
            size = 0
            for offset0, offset1 in offsets:
                if not isValid(x + offset0, y + offset1): continue
                if board[x + offset0][y + offset1] == 'M': size += 1
            return size

        def dfs(x, y):
            if not isValid(x,y):
                return
            if board[x][y] == 'M':
                board[x][y] = 'X'
                return
            elif board[x][y] == 'E':
                tmp = mineSize(x, y)
                if tmp != 0:
                    board[x][y] = str(tmp)
                    return
                else:
                    board[x][y] = 'B'
                    for offset0, offset1 in offsets:
                        dfs(x + offset0, y + offset1)


        dfs(click[0], click[1])
        return board


'''
[["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E","E"],["E","E","E","E","E"]]
[3,0]
[["B", "1", "E", "1", "B"],["B", "1", "M", "1", "B"],["B", "1", "1", "1", "B"],["B", "B", "B", "B", "B"]]
[1,2]
[["E","E","M","E","E"],["E","E","M","E","E"],["E","E","M","E","E"],["E","E","M","E","E"]]
[3,0]
[["E"]]
[0,0]
[["M"]]
[0,0]
[["M"],["E"]]
[1,0]
[["M","E"]]
[0,1]
[['B', '1', 'E', '1', 'B'],['B', '1', 'X', '1', 'B'],['B', '1', '1', '1', 'B'],['B', 'B', 'B', 'B', 'B']]
[["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
[["B","2","M","E","E"],["B","3","M","E","E"],["B","3","M","E","E"],["B","2","M","E","E"]]
'''
if __name__ == '__main__':
    obj = _529_Solution()
    assert obj.updateBoard(
        [["E", "E", "E", "E", "E"], ["E", "E", "M", "E", "E"], ["E", "E", "E", "E", "E"], ["E", "E", "E", "E", "E"]],
        [3, 0]) == [["B", "1", "E", "1", "B"], ["B", "1", "M", "1", "B"], ["B", "1", "1", "1", "B"],
                    ["B", "B", "B", "B", "B"]]
