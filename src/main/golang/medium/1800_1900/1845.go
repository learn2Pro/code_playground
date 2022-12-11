package medium

type MinHp []int

func (t *MinHp) up(x int) {
	for x > 1 {
		a, p := *t, x/2
		if a[p] > a[x] {
			a[p], a[x] = a[x], a[p]
			x = p
		} else {
			break
		}
	}
}
func (t *MinHp) down(x int) {
	n := len(*t) - 1
	for x*2 <= n {
		a, l, r := *t, x*2, x*2+1
		min, i := a[l], l
		if r <= n && a[r] < min {
			min, i = a[r], r
		}
		if min < a[x] {
			a[x], a[i] = a[i], a[x]
			x = i
		} else {
			break
		}
	}
}
func (t *MinHp) insert(num int) {
	*t = append(*t, num)
	n := len(*t) - 1
	t.up(n)
}
func (t *MinHp) pop() int {
	a, n := *t, len(*t)-1
	min := a[1]
	a[1], a[n] = a[n], a[1]
	*t = a[:n]
	t.down(1)
	return min
}

type SeatManager struct {
	t MinHp
}

func Constructor(n int) SeatManager {
	s := SeatManager{
		t: []int{0},
	}
	for i := 1; i <= n; i++ {
		s.t = append(s.t, i)
	}
	return s
}

func (this *SeatManager) Reserve() int {
	return this.t.pop()
}

func (this *SeatManager) Unreserve(seatNumber int) {
	this.t.insert(seatNumber)
}
