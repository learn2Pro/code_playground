# rolling-hash
# hash(text[s+1:s+m+1]) = d(hash(text[s:m]) - text(s)*h+text[s+m+1]) mod q
# d: number in the text = 256
# q: a prime number = 11
# h: d^(m-1)
def rkAlgorithm(pattern, text):
    M, N = len(pattern), len(text)
    q, d = 11, 256
    h = (d ** (M - 1)) % q
    # p: hash value for pattern
    # t: hash value for text
    p, t = 0, 0
    for i in range(M):
        p = (d * p + ord(pattern[i])) % q
        t = (d * t + ord(text[i])) % q

# def kmp(pattern,text):
