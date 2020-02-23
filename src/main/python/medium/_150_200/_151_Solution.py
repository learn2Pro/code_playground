# 151. Reverse Words in a String
class _151_Solution:
    def reverseWords(self, s: str) -> str:
        words = s.split()
        return " ".join(words[::-1])


if __name__ == '__main__':
    instance = _151_Solution
    assert instance.reverseWords(instance, "  hello world!  ") == "world! hello"
    assert instance.reverseWords(instance, "the sky is blue") == "blue is sky the"
    assert instance.reverseWords(instance, "a good   example") == "example good a"
