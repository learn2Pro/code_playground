# 593. Valid Square
from typing import List


class _593_Solution:
    def validSquare(self, p1: List[int], p2: List[int], p3: List[int], p4: List[int]) -> bool:
        def distance(src: List[int], dst: List[int]) -> int:
            return abs(src[0]-dst[0])**2+abs(src[1]-dst[1])**2
        arr = [p1, p2, p3, p4]
        for i in range(4):
            dis = []
            for j in range(4):
                if i == j:
                    continue
                dis.append(distance(arr[i], arr[j]))
            dis.sort()
            if dis[0] != dis[1] or dis[0]+dis[1] != dis[2] or dis[0] == 0 or dis[1] == 0 or dis[2] == 0:
                return False
        return True
    # use sort

    def validSquare(self, p1: List[int], p2: List[int], p3: List[int], p4: List[int]) -> bool:
        def distance(src: List[int], dst: List[int]) -> int:
            return abs(src[0]-dst[0])**2+abs(src[1]-dst[1])**2
        arr = [distance(p1, p2), distance(p1, p3), distance(
            p1, p4), distance(p2, p3), distance(p2, p4), distance(p3, p4)]
        arr.sort()
        if arr[0] == 0 or not arr[0] == arr[1] == arr[2] == arr[3] or not arr[4] == arr[5] or not arr[0]*2 == arr[4]:
            return False
        return True


'''
[0,0]
[1,1]
[1,0]
[0,1]
[1,1]
[1,1]
[2,2]
[2,2]
[1,1]
[1,1]
[1,1]
[100,100]
[1,1]
[1,1]
[1,1]
[1,1]
[2,3]
[3,2]
[4,8]
[8,4]
[0,0]
[5,0]
[5,4]
[0,4]
'''
if __name__ == "__main__":
    obj = _593_Solution()
    assert obj.validSquare([0, 0], [1, 1], [1, 0], [0, 1])
