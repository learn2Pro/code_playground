package adhoc

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestQuickSort(t *testing.T) {
	input := []int{3, 4, 2, 1}
	quickSort(input)
	assert.True(t, assertSorted(input))
}
func TestQuickSort0(t *testing.T) {
	input := []int{}
	QuickSort(input)
	assert.True(t, assertSorted(input))
}
func TestQuickSort1(t *testing.T) {
	input := []int{4}
	QuickSort(input)
	assert.True(t, assertSorted(input))
}

func TestMergeSort(t *testing.T) {
	input := []int{3, 4, 2, 1}
	input = MergeSort(input)
	assert.True(t, assertSorted(input))
}

func TestBubbleSort(t *testing.T) {
	input := []int{3, 4, 2, 1}
	BubbleSort(input)
	assert.True(t, assertSorted(input))
}

func assertSorted(input []int) bool {
	if len(input) > 1 {
		for i, j := 0, 1; j < len(input); j++ {
			if input[j] < input[i] {
				return false
			}
			i = j
		}
	}
	return true
}
