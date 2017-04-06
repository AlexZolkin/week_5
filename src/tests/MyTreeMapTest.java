package tests;

import org.junit.Before;
import org.junit.Test;
import task_2.MyTreeMap;
import task_2.Node;

/**
 * Created by Алексей on 06.04.2017.
 */
public class MyTreeMapTest {
    MyTreeMap<Integer, String> tree;
    @Before
    public void init(){
        tree = new MyTreeMap<>();
    }
    @Test
    public void test(){
        tree.insert(1, "1");
        tree.insert(0, "0");
        tree.insert(10, "10");
        tree.insert(11, "11");
        tree.insert(6, "6");
        tree.insert(13, "13");
        tree.insert(7, "7");
        tree.insert(12, "12");
        tree.insert(2, "2");
        Node<Integer, String> node = tree.find(13);
        node = tree.find(130);
    }
}
