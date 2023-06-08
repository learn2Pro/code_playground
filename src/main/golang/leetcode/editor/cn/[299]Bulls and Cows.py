# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        from collections import Counter
        bulls = cows = 0
        s = Counter(secret)
        g = Counter(guess)
        for i in range(len(secret)):
            if secret[i] == guess[i]:
                bulls += 1
                s[secret[i]] -= 1
                g[guess[i]] -= 1
        for k in s:
            cows += min(s[k], g[k])
        return str(bulls) + 'A' + str(cows) + 'B'
# leetcode submit region end(Prohibit modification and deletion)
