
# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def computeArea(self, ax1: int, ay1: int, ax2: int, ay2: int, bx1: int, by1: int, bx2: int, by2: int) -> int:

            def area(x1, y1, x2, y2):
                return (x2 - x1) * (y2 - y1)

            area1 = area(ax1, ay1, ax2, ay2)
            area2 = area(bx1, by1, bx2, by2)

            overlap = area(max(ax1, bx1), max(ay1, by1), min(ax2, bx2), min(ay2, by2)) if ax1 < bx2 and ax2 > bx1 and ay1 < by2 and ay2 > by1 else 0

            return area1 + area2 - overlap
# leetcode submit region end(Prohibit modification and deletion)
