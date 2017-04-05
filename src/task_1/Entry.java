package task_1;

/**
 * Created by Алексей on 05.04.2017.
 */
public class Entry<K, V> {
    private final K key;
    private V value;
    public Entry(K key, V value){
        this.key = key;
        this.value = value;
    }
    public K getKey(){
        return this.key;
    }
    public V getValue(){
        return this.value;
    }
}
