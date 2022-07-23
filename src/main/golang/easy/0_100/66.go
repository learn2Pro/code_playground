package easy

//66. 加一
func plusOne(digits []int) []int {
	if len(digits) <= 0 {
		return digits
	}
	res := make([]int, len(digits)+1)
	digits[len(digits)-1] += 1
	for i := len(digits) - 1; i >= 0; i-- {
		sum := digits[i] + res[i+1]
		if sum/10 == 1 {
			res[i] += 1
		}
		res[i+1] = sum % 10
	}
	if res[0] == 0 {
		return res[1:]
	} else {
		return res
	}
}
