# 223. Rectangle Area
class _223_Solution:
    def computeArea(self, A: int, B: int, C: int, D: int, E: int, F: int, G: int, H: int) -> int:
        def area(bottomX: int, bottomY: int, topX: int, topY: int) -> int:
            if bottomX > topX or bottomY > topY: return 0
            return abs(topX - bottomX) * abs(topY - bottomY)

        x0, y0 = max(A, E), max(B, F)
        x1, y1 = min(C, G), min(D, H)
        return area(A, B, C, D) + area(E, F, G, H) - area(x0, y0, x1, y1)


if __name__ == '__main__':
    instance = _223_Solution
    assert instance.computeArea(instance, 1,1,10,2,0,-1,9,2) == 28
    assert instance.computeArea(instance, -3, 0, 1, 1, 0, -1, 9, 2) == 30
    assert instance.computeArea(instance, -3, 0, 3, 4, 0, -1, 9, 2) == 45
    assert instance.computeArea(instance, 0, -1, 9, 2, -3, 0, 3, 4) == 45
