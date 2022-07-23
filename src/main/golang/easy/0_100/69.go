package easy

func mySqrt(y int) int {

	//var i int64
	//var x2, y float32
	//var threeHalfs float32 = 1.5
	//y = float32(x)
	//x2 = y * 0.5
	//i = int64(y)
	//i = 0x5f3759df - (i >> 1)
	//y = float32(i)
	//y = y * (threeHalfs - (x2 * y * y))
	//return int(y)
	//return int(math.Sqrt(float64(x)))
	//x^2-y=0
	//Xn+1=xn - f(x)/f'(x)
	if y <= 1 {
		return y
	}
	power, xn := float64(y), 1.0
	for i := 0; i < 10; i++ {
		xn = (xn + power/xn) / 2.0
	}
	n := int(xn)
	if n*n > y {
		return n - 1
	} else {
		return n
	}
}
