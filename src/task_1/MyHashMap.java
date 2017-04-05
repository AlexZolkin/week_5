package task_1;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by Алексей on 05.04.2017.
 */
public class MyHashMap<K, V> implements Map<K, V> {
    private MyEntry<K, V>[] array;

    private void resize(MyEntry<K, V>[] array){
        int size = array.length;
        for(int i=0;i<size;i++){
            if(array[i] == null){
                for(int j = i;j<size - 1;j++){
                    array[j] = array[j+1];
                }
                size--;
                i--;
            }
        }
    }


    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        for (MyEntry<K, V> entry: array) {
            if(entry.getKey() == (K) key)
                return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (MyEntry<K, V> entry: array) {
            if(entry.getValue() == (V) value)
                return true;
        }
        return false;
    }

    @Override
    public V get(Object key) {
        for(MyEntry<K, V> entry : array){
            if(entry.getKey() == (K) key)
                return entry.getValue();
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        for(MyEntry<K, V> entry : array){
            if(entry.getKey() == (K) key)
            {
                entry.setValue(value);
                return value;
            }
        }
        MyEntry<K, V>[] array = new MyEntry[this.array.length+1];
        for(int i=0;i<this.array.length;i++)
            array[i] = this.array[i];
        this.array = array;
        return value;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
