package medium

type MaxQueue struct {
	mqueue []int
	queue  []int
}

func Constructor() MaxQueue {
	return MaxQueue{}
}

func (this *MaxQueue) Max_value() int {
	if len(this.mqueue) > 0 {
		return this.mqueue[0]
	} else {
		return -1
	}
}

func (this *MaxQueue) Push_back(value int) {
	for len(this.mqueue) > 0 && this.mqueue[len(this.mqueue)-1] < value {
		this.mqueue = this.mqueue[:len(this.mqueue)-1]
	}
	this.mqueue = append(this.mqueue, value)
	this.queue = append(this.queue, value)
}

func (this *MaxQueue) Pop_front() int {
	if len(this.queue) > 0 {
		head := this.queue[0]
		this.queue = this.queue[1:]
		if head == this.mqueue[0] {
			this.mqueue = this.mqueue[1:]
		}
		return head
	} else {
		return -1
	}
}
