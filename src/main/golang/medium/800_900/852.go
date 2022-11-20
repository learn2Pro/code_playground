package medium

func peakIndexInMountainArray(arr []int) int {
	l, r := 0, len(arr)-1
	for l < r {
		mid := l + (r-l)/2
		if arr[mid] > arr[mid+1] {
			r = mid
		} else {
			l = mid + 1
		}
	}
	return l
}

func peakIndexInMountainArray3(arr []int) int {
	l, r := 1, len(arr)
	for l < r {
		mid := l + (r-l+1)/2
		if arr[mid-1] < arr[mid] {
			l = mid
		} else {
			r = mid - 1
		}
	}
	return l
}

func peakIndexInMountainArray2(arr []int) (ret int) {
	l, r := 1, len(arr)-2
	for l <= r {
		mid := l + (r-l)/2
		if arr[mid] > arr[mid+1] {
			ret = mid
			r = mid - 1
		} else {
			l = mid + 1
		}
	}
	return
}

func peakIndexInMountainArray1(arr []int) int {
	n := len(arr)
	l, r := 0, n-1
	for l <= r {
		mid := l + (r-l)/2
		if mid > 0 && mid < n-1 && arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1] {
			return mid
		} else if arr[r] > arr[mid] {
			l = mid + 1
		} else if arr[l] > arr[mid] {
			r = mid - 1
		} else if arr[l] < arr[mid] && arr[mid] > arr[r] {
			if arr[r] > arr[l] {
				l = mid + 1
			} else {
				r = mid - 1
			}
		}
	}
	return -1
}
