package medium

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func Test698(t *testing.T) {
	assert.Equal(t, canPartitionKSubsets([]int{1, 2, 3, 4}, 3), false)
	assert.Equal(t, canPartitionKSubsets([]int{2, 2, 2, 2, 3, 4, 5}, 4), false)
	assert.Equal(t, canPartitionKSubsets([]int{129, 17, 74, 57, 1421, 99, 92, 285, 1276, 218, 1588, 215, 369, 117, 153, 22}, 3), true)
	assert.Equal(t, canPartitionKSubsets([]int{3, 3, 10, 2, 6, 5, 10, 6, 8, 3, 2, 1, 6, 10, 7, 2}, 6), false)
	//assert.Equal(t, canPartitionKSubsets([]int{3522, 181, 521, 515, 304, 123, 2512, 312, 922, 407, 146, 1932, 4037, 2646, 3871, 269}, 5), true)
}
