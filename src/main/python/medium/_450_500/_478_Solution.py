# 478. Generate Random Point in a Circle
import math
from random import Random
from typing import List


class _478_Solution:

    def __init__(self, radius: float, x_center: float, y_center: float):
        self.radius = radius
        self.x = x_center
        self.y = y_center
        self.rnd = Random()

    # reject sampling
    def randPoint(self) -> List[float]:
        while True:
            rnd_x = self.rnd.uniform(self.x - self.radius, self.x + self.radius)
            rnd_y = self.rnd.uniform(self.y - self.radius, self.y + self.radius)
            if (rnd_x - self.x) ** 2 + (rnd_y - self.y) ** 2 <= self.radius ** 2:
                return [rnd_x, rnd_y]

    def randPoint(self) -> List[float]:
        rnd_radius = math.sqrt(self.rnd.random()) * self.radius
        rnd_angle = self.rnd.uniform(0, 2 * math.pi)
        return [self.x + rnd_radius * math.sin(rnd_angle), self.y + rnd_radius * math.cos(rnd_angle)]


if __name__ == '__main__':
    obj = _478_Solution(1.0, 0.0, 0.0)
    assert obj.randPoint()
