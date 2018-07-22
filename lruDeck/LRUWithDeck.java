package lruDeck;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Ajay Wadhara on 12/2/2016.
 *
 * This class contains implementation for Least Recently used caching principle using
 *  1. HashMap (for thread safety use ConcurrentHashMap)
 *  2. LinkedList implementation for Dequeue (for thread safety use ConcurrentLinkedQueue)
 */
public class LRUWithDeck {

    int capacity;
    HashMap<Integer, Integer> cache = new HashMap<>();
    Deque<Integer> list = new LinkedList<>();

    public LRUWithDeck(int capacity){
        this.capacity = capacity;
    }

    public int get(int key){
        if(cache.containsKey(key)){
            Integer value = cache.get(key);
            list.remove(key);
            list.addFirst(key);
            return value;
        }
        return -1;
    }
    public void put(Integer key, Integer val){
        if(cache.containsKey(key)){
            list.remove(key);
            list.addFirst(key);
            //we have to update map, if same key with different value comes
            cache.put(key, val);
        }else{
            if(cache.size() >= capacity){
                cache.remove(list.removeLast());
                list.addFirst(key);
            }else{
                list.addFirst(key);
            }
            cache.put(key, val);
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
