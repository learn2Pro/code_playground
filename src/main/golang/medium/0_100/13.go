package medium

type Pair struct {
	Key   string
	Value int
}

func romanToInt(s string) int {
	Min := func(x, y int) int {
		if x < y {
			return x
		}
		return y
	}

	var mapping = []Pair{
		{"M", 1000},
		{"CM", 900},
		{"D", 500},
		{"C", 100},
		{"XC", 90},
		{"L", 50},
		{"X", 10},
		{"IX", 9},
		{"V", 5},
		{"IV", 4},
		{"I", 1},
	}
	var ans int
	i, n := 0, len(s)
	for i < n {
		for _, pair := range mapping {
			size := len(pair.Key)
			prefix := s[i:Min(i+size, n)]
			if prefix == pair.Key {
				ans += pair.Value
				i += size
				break
			}
		}
	}
	return ans

}
