package lc

//leetcode submit region begin(Prohibit modification and deletion)
type ProductOfNumbers struct {
	prefixProduct []int
}

func Constructor1() ProductOfNumbers {
	return ProductOfNumbers{prefixProduct: []int{1}}
}

func (this *ProductOfNumbers) Add(num int) {
	if num == 0 {
		this.prefixProduct = []int{1}
	} else {
		last := this.prefixProduct[len(this.prefixProduct)-1]
		this.prefixProduct = append(this.prefixProduct, last*num)
	}
}

func (this *ProductOfNumbers) GetProduct(k int) int {
	n := len(this.prefixProduct)
	if k >= n {
		return 0
	}
	return this.prefixProduct[n-1] / this.prefixProduct[n-k-1]
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Add(num);
 * param_2 := obj.GetProduct(k);
 */
//leetcode submit region end(Prohibit modification and deletion)
