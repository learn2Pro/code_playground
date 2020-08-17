# 792. Number of Matching Subsequences
import collections
from typing import List

'''
"abcde"
["a","bb","acd","ace"]
"aaaaa"
["aaa","a","aa","aaaaa","aaaa"]
"aabcbde"
["bd","bde","ae","a","aa"]
"a"
["a","b"]
"ewqadqoueqolassknclakaca"
["k","a","efw"]
"bbbaaa"
["ab","b","baa"]
'''


class _792_Solution:
    def numMatchingSubseq(self, S: str, words: List[str]) -> int:
        mapping = collections.defaultdict(list)
        for i, c in enumerate(S):
            mapping[c].append(i)
        ans = 0
        word_cnt = collections.Counter(words)
        for word in word_cnt:
            index, found = -1, True
            for w in word:
                previous = index
                for i in mapping[w]:
                    if i > index:
                        index = i
                        break
                if previous == index:
                    found = False
                    break
            if found: ans += word_cnt[word]
        return ans

    # use find
    def numMatchingSubseq(self, S: str, words: List[str]) -> int:
        def isSubSeq(word) -> bool:
            i = 0
            for c in word:
                i = S.find(c, i) + 1
                if not i: return False
            return True

        word_cnt, ans = collections.Counter(words), 0
        for word in word_cnt:
            if isSubSeq(word): ans += word_cnt[word]
        return ans

    # use queue
    def numMatchingSubseq(self, S: str, words: List[str]) -> int:
        queue = [[] for _ in range(26)]
        for word in words:
            queue[ord(word[0]) - ord('a')].append(word[1:])
        ans = 0
        for c in S:
            inner = queue[ord(c) - ord('a')]
            size = len(inner)
            for i in range(size):
                current = inner.pop(0)
                if not current:
                    ans += 1
                else:
                    queue[ord(current[0]) - ord('a')].append(current[1:])
        return ans

    # use queue and iter
    def numMatchingSubseq(self, S: str, words: List[str]) -> int:
        waiting = collections.defaultdict(list)
        for word in words:
            waiting[word[0]].append(iter(word[1:]))
        for c in S:
            for it in waiting.pop(c, ()):
                waiting[next(it, None)].append(it)
        return len(waiting[None])


if __name__ == '__main__':
    tar = _792_Solution()
    assert tar.numMatchingSubseq("abcde", ["a", "bb", "acd", "ace"]) == 3
