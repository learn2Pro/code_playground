package adhoc

//package solution

// you can also use imports, for example:
// import "fmt"
// import "os"

// you can write to stdout for debugging purposes, e.g.
// fmt.Println("this is a debug message")

//func Solution(X int, B []int, Z int) int {
//	// write your code in Go 1.4
//	size := min(Z, len(B))
//	all := sum(B, 0, len(B))
//	rate := customDivide(sum(B, max(0, len(B)-size), len(B)), size)
//	if X <= all { //already succeed
//		return 0
//	} else if rate <= 0 { //no rate
//		return -1
//	} else {
//		return ceilDivide(X-all, rate)
//	}
//}
//
////array,[start,end)
//func sum(B []int, s, e int) int {
//	sum := 0
//	for i := s; i < e; i++ {
//		sum += B[i]
//	}
//	return sum
//}
//
//func min(a, b int) int {
//	if a <= b {
//		return a
//	} else {
//		return b
//	}
//}
//func max(a, b int) int {
//	if a > b {
//		return a
//	} else {
//		return b
//	}
//}
//func customDivide(a, b int) int {
//	if b == 0 {
//		return 0
//	} else {
//		return a / b
//	}
//}
//func ceilDivide(a, b int) int {
//	if a%b > 0 {
//		return a/b + 1
//	} else {
//		return a / b
//	}
//}
