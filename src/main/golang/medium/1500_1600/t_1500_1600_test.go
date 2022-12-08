package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

//5
//[[1,4],[2,4],[0,4],[0,3],[0,2],[2,3]]
//[0.37,0.17,0.93,0.23,0.39,0.04]
//3
//4
func Test1631(t *testing.T) {
	//{{1, 4}, {2, 4}, {0, 4}, {0, 3}, {0, 2}, {2, 3}}
	assert.Equal(t, 0.21390, maxProbability(
		5,
		[][]int{{1, 4}, {2, 4}, {0, 4}, {0, 3}, {0, 2}, {2, 3}},
		[]float64{0.37, 0.17, 0.93, 0.23, 0.39, 0.04},
		3,
		4,
	))
}
