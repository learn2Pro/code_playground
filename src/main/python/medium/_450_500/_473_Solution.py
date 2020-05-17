from typing import List


class _473_Solution:
    def makesquare(self, nums: List[int]) -> bool:
        if not nums: return False
        nums.sort(reverse=True)
        acc, n = sum(nums), len(nums)
        if acc % 4 != 0: return False
        square = acc // 4

        def backtrack(remain: int, curr: int) -> bool:
            if remain == 0: return True
            if curr == 0:
                return backtrack(remain - 1, square)
            elif curr < 0:
                return False
            for i in range(n):
                if nums[i] < 0: continue
                nums[i] *= -1
                ans = backtrack(remain, curr + nums[i])
                nums[i] *= -1
                if ans: return True
            return False

        return backtrack(4, square)

    def makesquare(self, nums: List[int]) -> bool:
        if not nums: return False
        nums.sort(reverse=True)
        acc, n = sum(nums), len(nums)
        if acc % 4 != 0: return False
        square = [acc // 4] * 4

        def backtrack(index: int) -> bool:
            if index >= n: return all(sq == 0 for sq in square)
            for i in range(4):
                if nums[index] <= square[i]:
                    square[i] -= nums[index]
                    ans = backtrack(index + 1)
                    square[i] += nums[index]
                    if ans: return True
            return False

        return backtrack(0)

    def makesquare(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """

        # If there are no matchsticks, then we can't form any square.
        if not nums:
            return False

        # Number of matchsticks
        L = len(nums)

        # Possible perimeter of our square
        perimeter = sum(nums)

        # Possible side of our square from the given matchsticks
        possible_side = perimeter // 4

        # If the perimeter isn't equally divisible among 4 sides, return False.
        if possible_side * 4 != perimeter:
            return False

        # Memoization cache for the dynamic programming solution.
        memo = {}

        # mask and the sides_done define the state of our recursion.
        def recurse(mask, sides_done):

            # This will calculate the total sum of matchsticks used till now using the bits of the mask.
            total = 0
            for i in range(L - 1, -1, -1):
                if not (mask & (1 << i)):
                    total += nums[L - 1 - i]

            # If some of the matchsticks have been used and the sum is divisible by our square's side, then we increment the number of sides completed.
            if total > 0 and total % possible_side == 0:
                sides_done += 1

            # If we were successfully able to form 3 sides, return True
            if sides_done == 3:
                return True

            # If this recursion state has already been calculated, just return the stored value.
            if (mask, sides_done) in memo:
                return memo[(mask, sides_done)]

            # Common variable to store answer from all possible further recursions from this step.
            ans = False

            # rem stores available space in the current side (incomplete).
            c = int(total / possible_side)
            rem = possible_side * (c + 1) - total

            # Iterate over all the matchsticks
            for i in range(L - 1, -1, -1):

                # If the current one can fit in the remaining space of the side and it hasn't already been taken, then try it out
                if nums[L - 1 - i] <= rem and mask & (1 << i):

                    # If the recursion after considering this matchstick gives a True result, just break. No need to look any further.
                    # mask ^ (1 << i) makes the i^th from the right, 0 making it unavailable in future recursions.
                    if recurse(mask ^ (1 << i), sides_done):
                        ans = True
                        break
            # cache the result for the current recursion state.
            memo[(mask, sides_done)] = ans
            return ans

        # recurse with the initial mask with all matchsticks available.
        return recurse((1 << L) - 1, 0)


'''
[1,1,2,2,2]
[]
[3,3,3,3,4]
[3,3,3,3]
[11,11,11,11,11,11,11,11,11,11,11,11]
[1,2,3,4,5,6,7,8,9,10,11]
[15,14,13,11,10,9,8,7,6,5,4,3,2,1]
[15,14,13,11,10,9,8,7,6,5,4,3,2,2]
[15,14,13,11,10,9,8,7,6,5,4,3,2,4]
[1569462,2402351,9513693,2220521,7730020,7930469,1040519,5767807,876240,350944,4674663,4809943,8379742,3517287,8034755]
[5,5,5,5,4,4,4,4,3,3,3,3]
[5,5,5,5,16,4,4,4,4,4,3,3,3,3,4]
'''
if __name__ == '__main__':
    obj = _473_Solution()
    assert not obj.makesquare([5, 5, 5, 5, 16, 4, 4, 4, 4, 4, 3, 3, 3, 3, 4])
    assert obj.makesquare([5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3])
    assert not obj.makesquare(
        [1569462, 2402351, 9513693, 2220521, 7730020, 7930469, 1040519, 5767807, 876240, 350944, 4674663, 4809943,
         8379742, 3517287, 8034755])
    assert obj.makesquare([15, 14, 13, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1])
    assert obj.makesquare([1, 1, 2, 2, 2])
    assert not obj.makesquare([3, 3, 3, 3, 4])
