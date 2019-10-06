/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package week40;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author derong.tdr
 * @version WordBreakIIV1.java, v 0.1 2019年10月02日 16:56 tang Exp $
 */
public class WordBreakIIV1 {
    List<String> result;
    int          max, min;
    HashSet<String> dict;
    List<String>[]  map;

    public List<String> wordBreak(String s, List<String> wordDict) {
        result = new ArrayList<>();
        dict = new HashSet<>();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        map = new List[s.length()];
        // trick
        for (String c : wordDict) {
            min = Math.min(min, c.length());
            max = Math.max(max, c.length());
            dict.add(c);
        }

        List<String> li = backTrack(s, 0);
        for (String c : li) {
            result.add(c.substring(0, c.length() - 1));
        }
        return result;

    }

    public List<String> backTrack(String s, int idx) {
        if (idx == s.length()) {
            List<String> li = new ArrayList<>();
            li.add("");
            return li;
        }

        if (map[idx] != null) {
            return map[idx];
        }

        List<String> li = new ArrayList<>();

        for (int j = idx + min; j <= idx + max && j <= s.length(); j++) {
            String c = s.substring(idx, j);
            if (dict.contains(c)) {
                List<String> next = backTrack(s, j);

                for (String d : next) {
                    li.add(c + " " + d);
                }
            }
        }
        map[idx] = li;

        return li;
    }
}