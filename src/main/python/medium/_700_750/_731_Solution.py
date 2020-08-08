# 731. My Calendar II
import collections
from sortedcontainers import SortedDict

class MyCalendarTwo:

    # double list
    def __init__(self):
        self.calendar = []
        self.overlaps = []

    def book(self, start: int, end: int) -> bool:
        for s, e in self.overlaps:
            if start < e and end > s:
                return False
        for s, e in self.calendar:
            if start < e and end > s:
                self.overlaps.append((max(s, start), min(end, e)))
        self.calendar.append((start, end))
        return True

    # use boundary count
    def __init__(self):
        self.calendar = SortedDict()

    def book(self, start: int, end: int) -> bool:
        self.calendar[start] = self.calendar.get(start, 0) + 1
        self.calendar[end] = self.calendar.get(end, 0) - 1
        active = 0
        for v in self.calendar.values():
            active += v
            if active >= 3:
                self.calendar[start] = self.calendar.pop(start, 0) - 1
                self.calendar[end] = self.calendar.pop(end, 0) + 1
                if self.calendar[start] == 0:
                    del self.calendar[start]
                return False
        return True


if __name__ == '__main__':
    tar = MyCalendarTwo()
    assert tar.book(10, 20)
    assert tar.book(50, 60)
    assert tar.book(10, 40)
    assert not tar.book(5, 15)
