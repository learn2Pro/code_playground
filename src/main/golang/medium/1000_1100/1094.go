package medium

import "sort"

func carPooling(trips [][]int, capacity int) bool {
	diff := make([]int, 1001)
	for _, trip := range trips {
		v, s, e := trip[0], trip[1], trip[2]
		diff[s] += v
		diff[e] -= v
	}
	accum := 0
	for _, v := range diff {
		accum += v
		if accum > capacity {
			return false
		}
	}
	return true
}
func carPooling1(trips [][]int, capacity int) bool {
	var j int
	sort.Slice(trips, func(i, j int) bool {
		return trips[i][1] < trips[j][1]
	})
	tripoff := make(map[int]int)
	for i := 0; j < len(trips) && i <= 1000; i++ {
		if v, ok := tripoff[i]; ok { //tripoff
			capacity += v
			tripoff[i] = 0
		}
		if trips[j][1] < i {
			return false
		}
		for j < len(trips) && trips[j][1] == i {
			if capacity < trips[j][0] {
				return false
			}
			//tripon
			capacity -= trips[j][0]
			if v, ok := tripoff[trips[j][2]]; ok {
				tripoff[trips[j][2]] = v + trips[j][0]
			} else {
				tripoff[trips[j][2]] = trips[j][0]
			}
			j++
		}
	}
	return true
}
