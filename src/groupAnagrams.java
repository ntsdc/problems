import java.util.*;

public class groupAnagrams {
    public static void main(String[] args) {
        new Solution49().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] sort_strs = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            sort_strs[i] = String.valueOf(chars);
        }
        Map<String,Integer> hashmap = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            if(hashmap.containsKey(sort_strs[i])){
                 res.get(hashmap.get(sort_strs[i])).add(strs[i]);
            }else {
                hashmap.put(sort_strs[i], index);
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                res.add(l);
                index++;
            }
        }
        return res;
    }
}