package lc

import "math"

//leetcode submit region begin(Prohibit modification and deletion)
type Point struct {
	x int
	y int
}

func isRectangleCover(rectangles [][]int) bool {
	Min := func(x, y int) int {
		if x > y {
			return y
		}
		return x
	}
	Max := func(x, y int) int {
		if x > y {
			return x
		}
		return y
	}
	points := make(map[Point]bool)
	l0, l1, r0, r1 := math.MaxInt32, math.MaxInt32, -math.MaxInt32, -math.MaxInt32
	var actualArea int
	for _, lst := range rectangles {
		x1, y1, x2, y2 := lst[0], lst[1], lst[2], lst[3]
		l0, l1 = Min(l0, x1), Min(l1, y1)
		r0, r1 = Max(r0, x2), Max(r1, y2)
		actualArea += (x2 - x1) * (y2 - y1)
		p0, p1, p2, p3 := Point{x1, y1}, Point{x1, y2}, Point{x2, y1}, Point{x2, y2}
		for _, p := range []Point{p0, p1, p2, p3} {
			if _, ok := points[p]; !ok {
				points[p] = true
			} else {
				delete(points, p)
			}
		}
	}
	var expectedArea = (r0 - l0) * (r1 - l1)
	if actualArea != expectedArea {
		return false
	}
	if len(points) != 4 {
		return false
	}
	p0, p1, p2, p3 := Point{l0, l1}, Point{l0, r1}, Point{r0, l1}, Point{r0, r1}
	for _, p := range []Point{p0, p1, p2, p3} {
		if _, ok := points[p]; !ok {
			return false
		}
	}
	return true

}

//leetcode submit region end(Prohibit modification and deletion)
