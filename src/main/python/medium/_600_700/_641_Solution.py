'''
["MyCircularDeque","insertLast","insertLast","insertFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]
[[3],[1],[2],[3],[4],[],[],[],[4],[]]
["MyCircularDeque","insertFront","insertLast","insertLast","deleteFront","insertFront","deleteLast","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]
[[3],[1],[1],[2],[],[3],[],[4],[],[],[],[4],[]]
["MyCircularDeque","insertLast","insertLast","deleteFront","deleteFront","deleteLast","insertFront","deleteLast","getFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]
[[3],[1],[1],[],[],[],[3],[],[],[4],[],[],[],[4],[]]
'''
class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.container = [-1] * k
        self.size = 0
        self.capacity = k
        self.head = self.tail = -1

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if self.isFull():
            return False
        if self.head == self.tail == -1:
            self.head = self.tail = 0
            self.container[self.head] = value
        else:
            self.head = (self.head - 1 + self.capacity) % self.capacity
            self.container[self.head] = value
        self.size += 1
        return True

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if self.isFull():
            return False
        if self.head == self.tail == -1:
            self.head = self.tail = 0
            self.container[self.head] = value
        else:
            self.tail = (self.tail + 1) % self.capacity
            self.container[self.tail] = value
        self.size += 1
        return True

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if self.isEmpty(): return False
        self.head = (self.head + 1) % self.capacity
        self.size -= 1
        if self.size == 0:
            self.head = self.tail = -1
        return True

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if self.isEmpty(): return False
        self.tail = (self.tail - 1 + self.capacity) % self.capacity
        self.size -= 1
        if self.size == 0:
            self.head = self.tail = -1
        return True

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        if self.isEmpty(): return -1
        return self.container[self.head]

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        if self.isEmpty(): return -1
        return self.container[self.tail]

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return self.size == 0

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return self.size == self.capacity

# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque(k)
# param_1 = obj.insertFront(value)
# param_2 = obj.insertLast(value)
# param_3 = obj.deleteFront()
# param_4 = obj.deleteLast()
# param_5 = obj.getFront()
# param_6 = obj.getRear()
# param_7 = obj.isEmpty()
# param_8 = obj.isFull()
