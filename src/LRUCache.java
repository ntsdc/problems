import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;


/*leetcode不过 15/22 输入太多没法debug*/
class LRUCache {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    List<Integer> index = new LinkedList<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }
        index.removeIf(Predicate.isEqual(key));
        index.add(key);
        return hashMap.get(key);
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            hashMap.replace(key, value);
            index.remove(0);
            index.add(key);
        } else {
            if (hashMap.size() == capacity) {
                hashMap.remove(index.get(0));
                index.remove(0);
            }
            hashMap.put(key, value);
            index.add(key);
        }
    }
}

class Solution146 {
    public static void main(String[] args) {

        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }
//    public void test(String[] Ops, String[] nums){
//        LRUCache lruCache;
//        for (int i = 0; i < Ops.length; i++) {
//            if(Ops[i].equals("LRUCache")){
//                lruCache = new LRUCache(Integer.parseInt(nums[0]));
//            }
//            if(Ops[i].equals("get")){
//                lruCache.get
//            }
//        }
//    }
}