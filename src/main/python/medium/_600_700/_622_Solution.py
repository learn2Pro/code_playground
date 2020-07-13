from collections import deque


class Node:
    def __init__(self, v: int, successor=None):
        self.value = v
        self.next = successor


# class MyCircularQueue:
#
#     def __init__(self, k: int):
#         """
#         Initialize your data structure here. Set the size of the queue to be k.
#         """
#         self.limit = k
#         self.size = 0
#         self.head = None
#         self.front = None
#         self.end = None
#
#     def enQueue(self, value: int) -> bool:
#         """
#         Insert an element into the circular queue. Return true if the operation is successful.
#         """
#         if self.size < self.limit:
#             if self.end and self.end.next:
#                 self.end.next.value = value
#                 self.end = self.end.next
#             else:
#                 n = Node(value)
#                 if self.front == self.end == None:
#                     self.front = self.end = self.head = n
#                 else:
#                     self.end.next = n
#                     self.end = n
#                     if not self.front: self.front = self.end
#             self.size += 1
#             if self.size == self.limit:
#                 self.end.next = self.head
#             return True
#         else:
#             return False
#
#     def deQueue(self) -> bool:
#         """
#         Delete an element from the circular queue. Return true if the operation is successful.
#         """
#         if self.size <= 0:
#             return False
#         self.front = self.front.next
#         self.size -= 1
#         return True
#
#     def Front(self) -> int:
#         """
#         Get the front item from the queue.
#         """
#         if self.size <= 0:
#             return -1
#         return self.front.value
#
#     def Rear(self) -> int:
#         """
#         Get the last item from the queue.
#         """
#         if self.size <= 0:
#             return -1
#         return self.end.value
#
#     def isEmpty(self) -> bool:
#         """
#         Checks whether the circular queue is empty or not.
#         """
#         return self.size == 0
#
#     def isFull(self) -> bool:
#         """
#         Checks whether the circular queue is full or not.
#         """
#         return self.size == self.limit
class MyCircularQueue:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the queue to be k.
        """
        self.capacity = k
        self.size = 0
        self.array = [-1] * k
        self.front = self.rear = -1

    def enQueue(self, value: int) -> bool:
        """
        Insert an element into the circular queue. Return true if the operation is successful.
        """
        if self.isFull(): return False
        if self.front == self.rear == -1:
            self.front = self.rear = 0
        else:
            self.rear = (self.rear + 1) % self.capacity
        self.array[self.rear] = value
        self.size += 1
        return True

    def deQueue(self) -> bool:
        """
        Delete an element from the circular queue. Return true if the operation is successful.
        """
        if self.isEmpty(): return False
        if self.size == 1:
            self.front = self.rear = -1
        else:
            self.front = (self.front + 1) % self.capacity
        self.size -= 1
        return True

    def Front(self) -> int:
        """
        Get the front item from the queue.
        """
        if self.isEmpty(): return -1
        return self.array[self.front]

    def Rear(self) -> int:
        """
        Get the last item from the queue.
        """
        if self.isEmpty(): return -1
        return self.array[self.rear]

    def isEmpty(self) -> bool:
        """
        Checks whether the circular queue is empty or not.
        """
        return self.size == 0

    def isFull(self) -> bool:
        """
        Checks whether the circular queue is full or not.
        """
        return self.size == self.capacity


class MyCircularQueue:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the queue to be k.
        """
        self.que = deque()
        self.size = k

    def enQueue(self, value: int) -> bool:
        """
        Insert an element into the circular queue. Return true if the operation is successful.
        """
        if self.isFull():
            return False
        else:
            self.que.append(value)
            return True

    def deQueue(self) -> bool:
        """
        Delete an element from the circular queue. Return true if the operation is successful.
        """
        if self.isEmpty():
            return False
        else:
            self.que.popleft()
            return True

    def Front(self) -> int:
        """
        Get the front item from the queue.
        """
        if self.isEmpty():
            return -1
        else:
            return self.que[0]

    def Rear(self) -> int:
        """
        Get the last item from the queue.
        """
        if self.isEmpty():
            return -1
        else:
            return self.que[-1]

    def isEmpty(self) -> bool:
        """
        Checks whether the circular queue is empty or not.
        """
        if len(self.que) == 0:
            return True
        else:
            return False

    def isFull(self) -> bool:
        """
        Checks whether the circular queue is full or not.
        """
        if len(self.que) == self.size:
            return True
        else:
            return False

# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue(k)
# param_1 = obj.enQueue(value)
# param_2 = obj.deQueue()
# param_3 = obj.Front()
# param_4 = obj.Rear()
# param_5 = obj.isEmpty()
# param_6 = obj.isFull()

# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue(k)
# param_1 = obj.enQueue(value)
# param_2 = obj.deQueue()
# param_3 = obj.Front()
# param_4 = obj.Rear()
# param_5 = obj.isEmpty()
# param_6 = obj.isFull()
