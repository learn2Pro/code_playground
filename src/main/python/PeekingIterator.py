from typing import Iterator

'''
["PeekingIterator","next","peek","next","hasNext","next","hasNext"]
[[[1,2,3]],[],[],[],[],[],[]]
["PeekingIterator","next","peek","next","hasNext","next","hasNext"]
[[[]],[],[],[],[],[],[]]
["PeekingIterator","next","peek","next","hasNext","next","hasNext"]
[[[1]],[],[],[],[],[],[]]
["PeekingIterator","next","peek","hasNext","next","hasNext","next","hasNext"]
[[[1,2,3]],[],[],[],[],[],[],[]]
'''
class PeekingIterator:
    def __init__(self, iterator):
        """
        Initialize your data structure here.
        :type iterator: Iterator
        """
        self.current = iterator.next() if iterator.hasNext() else None
        self.iter = iterator

    def peek(self):
        """
        Returns the next element in the iteration without advancing the iterator.
        :rtype: int
        """
        return self.current

    def next(self):
        """
        :rtype: int
        """
        tmp = self.current
        if (self.iter.hasNext()):
            self.current = self.iter.next()
        else:
            self.current = None
        return tmp

    def hasNext(self):
        """
        :rtype: bool
        """
        self.iter.hasNext() or not self.current
