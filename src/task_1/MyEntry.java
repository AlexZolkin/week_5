package task_1;

import java.util.Map;

/**
 * Created by Алексей on 05.04.2017.
 */
public class MyEntry<K, V> implements Map.Entry<K, V> {
    private final K key;
    private V value;
    public MyEntry(K key, V value){
        this.key = key;
        this.value = value;
    }
    public K getKey(){
        return this.key;
    }
    public V getValue(){
        return this.value;
    }
    public V setValue(V value){
        this.value = value;
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if(((Map.Entry<K, V>) o).getKey() == this.key &&
                ((Map.Entry<K, V>) o).getValue() == this.value){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.key.hashCode() * 256;
    }

}
