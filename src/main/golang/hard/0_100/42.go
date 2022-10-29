package hard

func trap(height []int) int {
	min := func(a, b int) int {
		if a <= b {
			return a
		} else {
			return b
		}
	}
	stack := []int{}
	sum := 0
	for i := 0; i < len(height); i++ {
		for len(stack) > 0 && height[i] > height[stack[len(stack)-1]] {
			h := height[stack[len(stack)-1]]
			stack = stack[:len(stack)-1]
			if len(stack) <= 0 {
				break
			}
			dist := i - stack[len(stack)-1] - 1
			minAll := min(height[i], height[stack[len(stack)-1]])
			if minAll > h {
				sum += dist * (minAll - h)
			}

		}
		stack = append(stack, i)
	}
	return sum

}

//func trap(height []int) int {
//	max := func(a, b int) int {
//		if a > b {
//			return a
//		} else {
//			return b
//		}
//	}
//	left, right := 1, len(height)-2
//	sum := 0
//	mleft, mright := 0, 0
//	for i := 1; i < len(height)-1; i++ {
//		if height[left-1] < height[right+1] {
//			mleft = max(mleft, height[left-1])
//			if mleft > height[left] {
//				sum += mleft - height[left]
//			}
//			left++
//		} else {
//			mright = max(mright, height[right+1])
//			if mright > height[right] {
//				sum += mright - height[right]
//			}
//			right--
//		}
//
//	}
//	return sum
//}

//
//func trap(height []int) int {
//	max := func(a, b int) int {
//		if a > b {
//			return a
//		} else {
//			return b
//		}
//	}
//	min := func(a, b int) int {
//		if a <= b {
//			return a
//		} else {
//			return b
//		}
//	}
//	ans := 0
//	for i := 1; i < len(height)-1; i++ {
//		mleft, mright := 0, 0
//		for j := i - 1; j >= 0; j-- {
//			mleft = max(height[j], mleft)
//		}
//		for j := i + 1; j < len(height); j++ {
//			mright = max(height[j], mright)
//		}
//		if height[i] < min(mleft, mright) {
//			ans += min(mleft, mright) - height[i]
//		}
//	}
//	return ans
//}
