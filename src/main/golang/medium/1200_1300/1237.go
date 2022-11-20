package medium

/**
 * This is the declaration of customFunction API.
 * @param  x    int
 * @param  x    int
 * @return 	    Returns f(x, y) for any given positive integers x and y.
 *			    Note that f(x, y) is increasing with respect to both x and y.
 *              i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 */

func findSolution(customFunction func(int, int) int, z int) [][]int {
	var ans [][]int
	x, y := 1, 1000
	for x <= 1000 && y >= 1 {
		if customFunction(x, y) == z {
			ans = append(ans, []int{x, y})
			x++
			y--
		} else if customFunction(x, y) < z {
			x++
		} else if customFunction(x, y) > z {
			y--
		}
	}
	return ans
}

func findSolution1(customFunction func(int, int) int, z int) [][]int {
	var ans [][]int
	for x := 1; x <= 1000; x++ {
		l, r := 1, 1000
		for l <= r {
			y := l + (r-l)/2
			if customFunction(x, y) == z {
				ans = append(ans, []int{x, y})
				break
			} else if customFunction(x, y) > z {
				r = y - 1
			} else if customFunction(x, y) < z {
				l = y + 1
			}
		}
	}
	return ans
}
