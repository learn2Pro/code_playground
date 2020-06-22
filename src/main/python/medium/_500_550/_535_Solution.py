class Codec:
    mapping0, mapping1 = {}, {}
    atomicInc = -1

    def encode(self, longUrl: str) -> str:
        """Encodes a URL to a shortened URL.
        """
        if longUrl not in self.mapping0:
            self.mapping0[longUrl] = str(self.atomicInc + 1)
            self.mapping1[str(self.atomicInc + 1)] = longUrl
            self.atomicInc += 1
        return self.mapping0[longUrl]

    def decode(self, shortUrl: str) -> str:
        """Decodes a shortened URL to its original URL.
        """
        return self.mapping1[shortUrl]
