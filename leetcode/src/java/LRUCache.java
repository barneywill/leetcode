import java.util.*;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache instance = new LRUCache(2);
//        instance.put(1, 1);
//        instance.put(2, 2);
//        System.out.println(instance.get(1));
//        instance.put(3, 3);
//        System.out.println(instance.get(2));
//        instance.put(4, 4);
//        System.out.println(instance.get(1));
//        System.out.println(instance.get(3));
//        System.out.println(instance.get(4));
        instance.put(2, 1);
        instance.put(2, 2);
        System.out.println(instance.get(2));
        instance.put(1, 1);
        instance.put(4, 1);
        System.out.println(instance.get(2));
    }
    Map<Integer, Integer> map = new HashMap<>();
    List<String> lruList = new LinkedList<>();
    private int capacity = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer result = map.get(key);
        if (result != null) {
            lruList.remove(String.valueOf(key));
            lruList.add(0, String.valueOf(key));
        }
        return result == null ? -1 : result;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            if (map.get(key) != value) {
                map.put(key, value);
            }
            if (!lruList.get(0).equals(String.valueOf(key))) {
                lruList.remove(String.valueOf(key));
                lruList.add(0, String.valueOf(key));
            }
        }
        else {
            if (lruList.size() >= capacity) {
                String removeKey = lruList.remove(lruList.size() - 1);
                map.remove(Integer.parseInt(removeKey));
            }
            map.put(key, value);
            lruList.add(0, String.valueOf(key));
        }
    }
}

/*
class LRUCache {

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<Integer>();
        this.map = new ConcurrentHashMap<Integer, Integer>(capacity);
    }

    public int get(int key) {
        // System.out.println("=== get : " + key);
        this.lru(key, false);
        Integer value = this.map.get(key);
        return value == null ? -1 : value.intValue();
    }

    public void put(int key, int value) {
        // System.out.println("=== put : " + key + ", " + value);
        this.lru(key, true);
        this.map.put(key, value);
    }

    private int capacity = 0;
    private LinkedList<Integer> queue = null;
    private Map<Integer, Integer> map = null;

    private void lru(int key, boolean isNecessary) {
        int foundIndex = -1;
        for (int i = 0; i < this.queue.size(); i++) {
            if (this.queue.get(i) == key) {
                foundIndex = i;
                break;
                // System.out.println("remove : " + key);
            }
        }
        if (isNecessary || foundIndex != -1) {
            synchronized (this) {
                if (foundIndex != -1) {
                    this.queue.remove(foundIndex);
                }
                if (isNecessary && this.queue.size() >= this.capacity) {
                    Integer removedKey = this.queue.removeLast();
                    // System.out.println("remove last : " + removedKey);
                    this.map.remove(removedKey);
                }

                // System.out.println("add first : " + key);
                this.queue.addFirst(key);
            }
        }


        // for (Integer k : this.queue) {
        //     System.out.print(k + ",");
        // }
        // System.out.println();
    }

}
*/
