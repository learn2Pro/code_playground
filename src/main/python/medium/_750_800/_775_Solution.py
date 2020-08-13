# 775. Global and Local Inversions
from typing import List


class _775_Solution:
    def isIdealPermutation(self, A: List[int]) -> bool:
        for i, item in enumerate(A):
            if abs(item - i) > 1: return False
        return True


'''
[1,0,2]
[1,2,0]
[2,1,0]
[2,0,1]
[1,2,3,4,5,6,7,0,8]
[4,3,2,1,0]
[1,0,2,3,4]
[2,1,0,4,3]
[0]
[0,1,2,3,4,5]
[5,3,1,0,2,4]
[4,3,2,1,0,5]
[1,4,3,6,0,7,8,2,5]
[6,7,0,1,2,3,4,5,8]
[5,3,2,0,4,1,7,6,8]
[1,0]
'''
if __name__ == '__main__':
    tar = _775_Solution()
    assert tar.isIdealPermutation([2, 0, 1])
    assert tar.isIdealPermutation([1, 0])
    assert not tar.isIdealPermutation([2, 1, 0, 4, 3])
    assert not tar.isIdealPermutation([1, 2, 0])
    assert tar.isIdealPermutation([1, 0, 2])
