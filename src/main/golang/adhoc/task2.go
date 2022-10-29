package adhoc

import "fmt"

func Solution(X int) string {
	// write your code in Go 1.4
	//unit
	if X == 0 {
		return "0s"
	}
	week, day, hour, minute, second := 7*24*60*60, 24*60*60, 60*60, 60, 1
	w, d, h, m, s := 0, 0, 0, 0, 0
	w = X / week                                          // get week
	d = (X - w*week) / day                                // get day
	h = (X - w*week - d*day) / hour                       // get hour
	m = (X - w*week - d*day - h*hour) / minute            // get minute
	s = (X - w*week - d*day - h*hour - m*minute) / second // get second
	ans, roundUp := "", 0
	if w > 0 {
		ans += fmt.Sprintf("%vw", w)
		roundUp += 1
	}
	if d > 0 {
		roundUp += 1
		if roundUp == 2 {
			if h > 0 || m > 0 || s > 0 {
				return ans + fmt.Sprintf("%vd", d+1)
			}
		} else {
			ans += fmt.Sprintf("%vd", d)
		}
	}
	if h > 0 {
		roundUp += 1
		if roundUp == 2 {
			if m > 0 || s > 0 {
				return ans + fmt.Sprintf("%vh", h+1)
			}
		} else {
			ans += fmt.Sprintf("%vh", h)
		}
	}
	if m > 0 {
		roundUp += 1
		if roundUp == 2 {
			if s > 0 {
				return ans + fmt.Sprintf("%vm", m+1)
			}
		} else {
			ans += fmt.Sprintf("%vm", m)
		}
	}
	if s > 0 {
		ans += fmt.Sprintf("%vs", s)
		roundUp += 1
	}
	return ans
}
