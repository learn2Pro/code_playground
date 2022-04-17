package main

import "fmt"

func main() {
	fmt.Println("Hello World!")
}

// race detector
// go run -race main.go

// example 1
//func main() {
//	done := make(chan bool)
//	m := make(map[string]string)
//	m["name"] = "world"
//	go func() {
//		m["name"] = "data race"
//		done <- true
//	}()
//	fmt.Println("Hello,", m["name"])
//	<-done
//}
// example 2
//func main() {
//	start := time.Now()
//	var t *time.Timer
//	t = time.AfterFunc(randomDuration(), func() {
//		fmt.Println(time.Now().Sub(start))
//		t.Reset(randomDuration())
//	})
//	time.Sleep(5 * time.Second)
//}
//
//func randomDuration() time.Duration {
//	return time.Duration(rand.Int63n(1e9))
//}
