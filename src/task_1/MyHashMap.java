package task_1;

import java.util.*;

/**
 * Created by Алексей on 05.04.2017.
 */
public class MyHashMap<K, V> implements Map<K, V> {
    private MyEntry<K, V>[] array;

    public MyHashMap(){
        this.array = new MyEntry[0];
    }

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
        if(array != null)
            return array.length;
        return 0;
    }

    @Override
    public boolean isEmpty() {
        if(array != null)
            return array.length == 0;
        return true;
    }

    @Override
    public boolean containsKey(Object key) {
        for (MyEntry<K, V> entry: array) {
            if(entry.getKey().equals((K) key))
                return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (MyEntry<K, V> entry: array) {
            if(entry != null)
                if(entry.getValue().equals((V) value))
                    return true;
        }
        return false;
    }

    @Override
    public V get(Object key) {
        for(MyEntry<K, V> entry : array){
            if(entry != null)
                if(entry.getKey().equals((K) key))
                    return entry.getValue();
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if(this.array.length != 0)
            for(MyEntry<K, V> entry : array){
                if(entry != null)
                    if(entry.getKey() == (K) key)
                    {
                        entry.setValue(value);
                        return value;
                    }
            }
        MyEntry<K, V>[] array = new MyEntry[this.array.length+1];
        for(int i=0;i<this.array.length;i++)
            array[i] = this.array[i];
        array[array.length - 1] = new MyEntry<K, V>(key, value);
        this.array = array;
        return value;
    }

    @Override
    public V remove(Object key) {
        for(int i=0;i<size();i++){
            if(this.array[i].getKey().equals((K) key)){
                V value = this.array[i].getValue();
                this.array[i] = null;
                resize(this.array);
                return value;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for(Map.Entry entry : m.entrySet()){
            put((K)entry.getKey(), (V)entry.getValue());
        }
    }

    @Override
    public void clear() {
        array = null;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<K>();
        for(MyEntry<K, V> entry : array)
            set.add(entry.getKey());
        return set;
    }

    @Override
    public Collection<V> values() {
        Collection<V> col = new ArrayList<V>();
        for(MyEntry<K, V> entry : array)
            col.add(entry.getValue());
        return col;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for(MyEntry<K, V> entry : array){
            set.add(entry);
        }
        return set;
    }
}
