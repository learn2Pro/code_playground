package easy

//27. Remove Element
func removeElement(nums []int, val int) int {
	if len(nums) < 0 {
		return 0
	}
	curr, eq := 0, 0
	for ; curr < len(nums); curr++ {
		if nums[curr] != val {
			swap27(nums, curr, eq)
			eq++
		}
	}
	return eq
}

func swap27(input []int, from int, to int) int {
	tmp := input[from]
	input[from] = input[to]
	input[to] = tmp
	return from
}
