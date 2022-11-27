package lc

//leetcode submit region begin(Prohibit modification and deletion)
type NumMatrix struct {
	prefix [][]int
}

func Constructor(matrix [][]int) NumMatrix {
	m, n := len(matrix), len(matrix[0])
	p := make([][]int, m+1)
	p[0] = make([]int, n+1)
	for i := 1; i <= m; i++ {
		p[i] = make([]int, n+1)
		for j := 1; j <= n; j++ {
			p[i][j] = p[i-1][j] + p[i][j-1] + matrix[i-1][j-1] - p[i-1][j-1]
		}
	}
	return NumMatrix{prefix: p}
}

func (this *NumMatrix) SumRegion(row1 int, col1 int, row2 int, col2 int) int {
	return this.prefix[row2+1][col2+1] - this.prefix[row1][col2+1] - this.prefix[row2+1][col1] + this.prefix[row1][col1]
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * obj := Constructor(matrix);
 * param_1 := obj.SumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)
