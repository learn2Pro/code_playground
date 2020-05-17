# The rand7() API is already defined for you.
def rand7():
    pass


class _470_Solution:
    def rand10(self):
        """
        :rtype: int
        """
        threshold = 40
        while threshold >= 40: threshold = 7 * (rand7() - 1) + (rand7() - 1)
        return threshold % 10 + 1
