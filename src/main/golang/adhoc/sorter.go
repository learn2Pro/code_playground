package adhoc

//=======================>Quick Sort=======================>
func QuickSort(input []int) {
	if len(input) <= 1 { //fast return
		return
	}
	quick0(input, 0, len(input)-1)
}

func quick0(input []int, start int, end int) {
	if start >= end {
		return
	}
	cur, bigger, pivot := start, start, start
	swap(input, pivot, end)
	for ; cur < end; cur++ {
		if input[cur] < input[end] {
			swap(input, cur, bigger)
			bigger++
		}
	}
	pivot = swap(input, bigger, end)
	quick0(input, start, pivot-1)
	quick0(input, pivot+1, end)
}

//=======================>Merge Sort=======================>
func MergeSort(input []int) []int {
	if len(input) <= 1 {
		return input
	}
	mid := len(input) / 2
	fst := MergeSort(input[:mid])
	snd := MergeSort(input[mid:])
	i, p0, p1, res := 0, 0, 0, make([]int, len(fst)+len(snd))
	for ; p0 < len(fst) && p1 < len(snd); i++ {
		if fst[p0] < snd[p1] {
			res[i] = fst[p0]
			p0++
		} else {
			res[i] = snd[p1]
			p1++
		}
	}
	for ; p0 < len(fst); i++ {
		res[i] = fst[p0]
		p0++
	}
	for ; p1 < len(snd); i++ {
		res[i] = snd[p1]
		p1++
	}
	return res
}

//=======================>Merge Sort=======================>
func BubbleSort(input []int) {
	if len(input) <= 1 {
		return
	}
	for i := 0; i < len(input); i++ {
		for j := i + 1; j < len(input); j++ {
			if input[j] < input[i] {
				swap(input, i, j)
			}
		}
	}
}

func swap(input []int, from int, to int) int {
	tmp := input[from]
	input[from] = input[to]
	input[to] = tmp
	return from
}
