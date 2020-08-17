# 794. Valid Tic-Tac-Toe State
import collections
from typing import List

'''
["O  ","   ","   "]
["XOX", " X ", "   "]
["XXX", "   ", "OOO"]
["XOX", "O O", "XOX"]
["   ","   ","   "]
["XXX"," O ","O  "]
["XXX"," O ","O  O"]
["XOX","OXO","OXX"]
["OXX","OX ","O  "]
["XXX","   ","XOO"]
["XXX","   ","OOO"]
'''


class _794_Solution:
    def validTicTacToe(self, board: List[str]) -> bool:
        counter = collections.Counter()
        states = [""] * 8
        for i, s in enumerate(board):
            states[i] = s
            states[3] += s[0]
            states[4] += s[1]
            states[5] += s[2]
            states[6] += s[i]
            states[7] += s[2 - i]
            counter += collections.Counter(s)
        for state in states:
            if state == "XXX":
                return counter['X'] - counter['O'] == 1
            elif state == "OOO":
                return counter['X'] == counter['O']
        return 0 <= counter['X'] - counter['O'] <= 1

    def validTicTacToe(self, board):
        b = '|'.join(board)
        x, o = (any(p * 3 in b[s::d] for s in range(9) for d in (1, 3, 4, 5)) for p in 'XO')
        m = b.count('X') - b.count('O')
        return (m == 0 and not x) or (m == 1 and not o)


if __name__ == '__main__':
    tar = _794_Solution()
    assert not tar.validTicTacToe(["XXX", "   ", "XOO"])
    assert not tar.validTicTacToe(["XOX", " X ", "   "])
