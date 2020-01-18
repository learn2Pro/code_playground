package category.hashtable._600_700;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 676. Implement Magic Dictionary
 */
public class _676_MagicDictionary {
    Set<String>          words;
    Map<String, Integer> count;

    public _676_MagicDictionary() {
        words = new HashSet();
        count = new HashMap();
    }

    private ArrayList<String> generalizedNeighbors(String word) {
        ArrayList<String> ans = new ArrayList();
        char[] ca = word.toCharArray();
        for (int i = 0; i < word.length(); ++i) {
            char letter = ca[i];
            ca[i] = '*';
            String magic = new String(ca);
            ans.add(magic);
            ca[i] = letter;
        }
        return ans;
    }

    public void buildDict(String[] words) {
        for (String word : words) {
            this.words.add(word);
            for (String nei : generalizedNeighbors(word)) {
                count.put(nei, count.getOrDefault(nei, 0) + 1);
            }
        }
    }

    public boolean search(String word) {
        for (String nei : generalizedNeighbors(word)) {
            int c = count.getOrDefault(nei, 0);
            if (c > 1 || c == 1 && !words.contains(word)) { return true; }
        }
        return false;
    }
}
//class _676_MagicDictionary {
//
//    Map<Integer, List<String>> dictHolder;
//
//    /**
//     * Initialize your data structure here.
//     */
//    public _676_MagicDictionary() {
//        dictHolder = new HashMap<>();
//    }
//
//    /**
//     * Build a dictionary through a list of words
//     */
//    public void buildDict(String[] dict) {
//        dictHolder.clear();
//        for (String word : dict) {
//            List<String> lst = dictHolder.getOrDefault(word.length(), new ArrayList<>());
//            lst.add(word);
//            dictHolder.put(word.length(), lst);
//        }
//    }
//
//    /**
//     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
//     */
//    public boolean search(String word) {
//        if (dictHolder == null || (dictHolder != null && !dictHolder.containsKey(word.length()))) { return false; }
//        List<String> inners = dictHolder.get(word.length());
//        for (String inner : inners) {
//            int N = word.length();
//            int diff = 0;
//            for (int i = 0; i < N; i++) {
//                if (word.charAt(i) != inner.charAt(i)) { diff++; }
//            }
//            if (diff == 1) { return true; }
//        }
//        return false;
//    }
//}