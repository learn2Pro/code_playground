from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        # ans = []
        # m, n = len(matrix), len(matrix[0])
        # u, d, l, r = 0, m - 1, 0, n - 1
        # while 1:
        #     for i in range(l, r + 1): ans.append(matrix[u][i])
        #     u+=1
        #     if u > d: break
        #     for i in range(u, d + 1): ans.append(matrix[i][r])
        #     r-=1
        #     if r < l: break
        #     for i in reversed(range(l, r + 1)): ans.append(matrix[d][i])
        #     d-=1
        #     if d < u: break
        #     for i in reversed(range(u, d + 1)): ans.append(matrix[i][l])
        #     l+=1
        #     if l > r: break
        # return ans
        direction = 0  # 0|-> 1|↓ 2|<- 3|↑
        x = y = 0
        ans = []
        m, n = len(matrix), len(matrix[0])
        u_boundary, d_boundary, l_boundary, r_boundary = 0, m - 1, 0, n - 1
        while len(ans) < m * n:
            if direction == 0:
                if y > r_boundary:
                    direction = (direction + 1) % 4
                    y, x = r_boundary, x + 1
                    u_boundary += 1
                    continue
                ans.append(matrix[x][y])
                y += 1
            elif direction == 1:
                if x > d_boundary:
                    direction = (direction + 1) % 4
                    r_boundary -= 1
                    x, y = d_boundary, y - 1
                    continue
                ans.append(matrix[x][y])
                x += 1
            elif direction == 2:
                if y < l_boundary:
                    direction = (direction + 1) % 4
                    d_boundary -= 1
                    y, x = l_boundary, x - 1
                    continue
                ans.append(matrix[x][y])
                y -= 1
            else:
                if x < u_boundary:
                    direction = (direction + 1) % 4
                    l_boundary += 1
                    x, y = u_boundary, y + 1
                    continue
                ans.append(matrix[x][y])
                x -= 1
        return ans
# leetcode submit region end(Prohibit modification and deletion)
