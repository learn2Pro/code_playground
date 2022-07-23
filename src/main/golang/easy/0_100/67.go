package easy

//67. 二进制求和
func addBinary(a string, b string) string {
	s, e := len(a)-1, len(b)-1
	res := ""
	var carry byte = '0'
	for s >= 0 && e >= 0 {
		cur0, c0 := plus(a[s], b[e])
		cur1, c1 := plus(c0, carry)
		carry = Max67(cur0, cur1)
		res = string(c1) + res
		s--
		e--
	}
	for s >= 0 {
		var c byte
		carry, c = plus(carry, a[s])
		res = string(c) + res
		s--
	}
	for e >= 0 {
		var c byte
		carry, c = plus(carry, b[e])
		res = string(c) + res
		e--
	}
	if carry != '0' {
		res = "1" + res
	}
	return res
}

func plus(a, b byte) (byte, byte) {
	if a == '1' && b == '1' {
		return '1', '0'
	} else if a == '1' && b == '0' {
		return '0', '1'
	} else if a == '0' && b == '1' {
		return '0', '1'
	} else {
		return '0', '0'
	}
}
func Max67(a, b byte) byte {
	if a >= b {
		return a
	} else {
		return b
	}
}
