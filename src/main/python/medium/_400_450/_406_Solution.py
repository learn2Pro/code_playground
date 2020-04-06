# 406. Queue Reconstruction by Height
from typing import List

'''
[[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
[[9,0],[7,0],[1,9],[3,0],[2,7],[5,3],[6,0],[3,4],[6,2],[5,2]]
'''
class _406_Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if not people or not people[0]: return []
        ans = []
        lst = sorted(people, key=lambda lst: (-lst[0],lst[1]))
        for curr in lst:
            ans.insert(curr[1],curr)
        return ans


if __name__ == '__main__':
    obj = _406_Solution()
    assert obj.reconstructQueue([[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]]) == [[5, 0], [7, 0], [5, 2], [6, 1],
                                                                                      [4, 4], [7, 1]]
    assert obj.reconstructQueue([]) == []
    assert obj.reconstructQueue([[7, 0]]) == [[7, 0]]
