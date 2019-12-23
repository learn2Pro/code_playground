package category.math._500_600;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * 535. Encode and Decode TinyURL
 */
public class Codec {

    Map<String, String> lookup = new HashMap<>();
    private static final char[] DIGITS_LOWER = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private String encodeHex(byte[] data) {
        int l = data.length;
        char[] out = new char[l << 1];
        int i = 0;

        for (int var5 = 0; i < l; ++i) {
            out[var5++] = DIGITS_LOWER[(240 & data[i]) >>> 4];
            out[var5++] = DIGITS_LOWER[15 & data[i]];
        }

        return new String(out);
    }

    private String md5(String input) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            return encodeHex(md.digest(input.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            return input;
        }
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = md5(longUrl);
        lookup.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return lookup.getOrDefault(shortUrl, shortUrl);
    }
}