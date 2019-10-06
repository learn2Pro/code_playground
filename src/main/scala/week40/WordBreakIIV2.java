/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package week40;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author derong.tdr
 * @version WordBreakIIV1.java, v 0.1 2019年10月02日 16:56 tang Exp $
 */
public class WordBreakIIV2 {

    Set<String>  dict      = new java.util.HashSet<>();
    Set<Integer> lengthSet = new java.util.HashSet<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        // trick
        for (String c : wordDict) {
            dict.add(c);
            lengthSet.add(c.length());
        }

        List<String> li = new ArrayList<>();
        for (String c : li) {
            result.add(c.substring(0, c.length() - 1));
        }
        return result;

    }
}