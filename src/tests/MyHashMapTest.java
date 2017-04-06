package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import task_1.MyEntry;
import task_1.MyHashMap;

import java.util.*;

/**
 * Created by Алексей on 06.04.2017.
 */
public class MyHashMapTest {
    MyHashMap<String, Integer> hashMap;
    @Before
    public void init(){
        hashMap = new MyHashMap<>();
        for(int i=0, j=15;i<15 && j > 0;i++, j--){
            hashMap.put(Integer.toString(j), i);
        }
    }
    @Test
    public void testSize(){
        Assert.assertEquals(15, hashMap.size());
    }
    @Test
    public void testIsEmpty(){
        Assert.assertEquals(false, hashMap.isEmpty());
    }
    @Test
    public void testContainsKey(){
        Assert.assertEquals(true, hashMap.containsKey("10"));
    }
    @Test
    public void testContainsValue(){
        Assert.assertEquals(true, hashMap.containsValue(10));
    }
    @Test
    public void testGet(){
        Assert.assertEquals(0, (int)hashMap.get("15"));
    }
    @Test
    public void testRemove(){
        hashMap.remove("15");
        Assert.assertEquals(false, hashMap.containsKey("15"));
    }
    @Test
    public void testPutAll(){
        HashMap<String, Integer> testMap = new HashMap<>();
        for(int i = 20;i<25;i++){
            testMap.put(Integer.toString(i), i);
        }
        hashMap.putAll(testMap);
        Assert.assertEquals(true, hashMap.containsValue(22));
    }
    @Test
    public void testClear(){
        hashMap.clear();
        Assert.assertEquals(true, hashMap.isEmpty());
    }
    @Test
    public void testKeySet(){
        Set<String> set = new HashSet<>();
        for(int i = 15; i > 0; i--)
            set.add(Integer.toString(i));
        Assert.assertEquals(set, hashMap.keySet());
    }
    @Test
    public void testValues(){
        Collection<Integer> col = new ArrayList<>();
        for(int i=0;i<15;i++)
            col.add(i);
        Assert.assertEquals(col, hashMap.values());
    }
    @Test
    public void testEntrySet(){
        boolean flag = true;
        Set<Map.Entry<String, Integer>> set = new HashSet<>();
        for(int i=0, j=15;i<15 && j > 0;i++, j--){
            set.add(new MyEntry<String, Integer>(Integer.toString(j), i));
        }
        Iterator<Map.Entry<String, Integer>> iter = set.iterator();
        for(;iter.hasNext();){
            Map.Entry<String, Integer> cur = iter.next();
            if(!(hashMap.containsKey(cur.getKey())
                    && hashMap.containsValue(cur.getValue()))){
                flag = false;
            }
        }
        Assert.assertEquals(true, flag);
    }
}
