# 735. Asteroid Collision
from typing import List


class _735_Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        if not asteroids: return asteroids
        stack = []
        for asteroid in asteroids:
            while stack and asteroid < 0 < stack[-1]:
                if abs(asteroid) <= abs(stack[-1]):
                    if abs(stack[-1]) == abs(asteroid): stack.pop()
                    break
                else:
                    stack.pop()
                    continue
            else:
                stack.append(asteroid)
        return stack


if __name__ == '__main__':
    tar = _735_Solution()
    assert tar.asteroidCollision([5, 10, -11])
    assert tar.asteroidCollision([5, 10, -5])
    assert tar.asteroidCollision([-2, -1, 1, 2])
