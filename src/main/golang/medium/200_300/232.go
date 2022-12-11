package medium

type MyQueue struct {
	s1 []int
	s2 []int
}

func Constructor1() MyQueue {
	return MyQueue{}
}

func (this *MyQueue) Push(x int) {
	this.s2 = append(this.s2, x)
}

func (this *MyQueue) Pop() int {
	num := this.Peek()
	this.s1 = this.s1[:len(this.s1)-1]
	return num
}

func (this *MyQueue) Peek() int {
	if len(this.s1) == 0 {
		for len(this.s2) > 0 {
			curr := this.s2[len(this.s2)-1]
			this.s2 = this.s2[:len(this.s2)-1]
			this.s1 = append(this.s1, curr)
		}
	}
	return this.s1[len(this.s1)-1]
}

func (this *MyQueue) Empty() bool {
	return len(this.s1) == 0 && len(this.s2) == 0
}
