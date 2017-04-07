package task_2;

/**
 * Created by Алексей on 06.04.2017.
 */
public class MyTreeMap<K extends Comparable<K>, V> {
    private Node<K, V> root;

    public  MyTreeMap(){
        root = null;
    }
    public MyTreeMap(Node<K, V> root){
        this.root = root;
    }
    public MyTreeMap(K key, V value){
        root = new Node<K, V>(key, value);
    }
    public Node<K, V> insert(K key, V value){
        Node<K, V> x = this.root, y = x;
        while (x != null){
            int cmp = x.getKey().compareTo(key);
            if(cmp == 0) {
                x.setValue(value);
                return x;
            }
            y = x;
            if(cmp > 0){
                x = x.getLeft();
            }else{
                x = x.getRight();
            }
        }
        if(y != null){
            if(y.getKey().compareTo(key) > 0)
                y.setLeft(key, value);
            else
                y.setRight(key, value);
        }else{
            this.root = new Node<K, V>(key, value);
        }
        return y;
    }
    public Node<K, V> find(K key){
        Node<K, V> x = this.root;
        while (x != null){
            int cmp = x.getKey().compareTo(key);
            if(cmp == 0)
                return x;
            if(cmp > 0)
                x = x.getLeft();
            else
                x = x.getRight();
        }
        return null;
    }
    public Node<K, V> remove(K key){
        Node<K, V> x = this.root, y = null;
        while (x != null){
            int cmp = x.getKey().compareTo(key);
            if(cmp == 0)
                break;
            y = x;
            if(cmp < 0)
                x = x.getLeft();
            else
                x = x.getRight();
        }
        if(x == null)
            return null;
        if(x.getRight() == null){
            if(y == null)
                this.root = x.getLeft();
            else {
                if(x == y.getLeft())
                    y.setLeft(x.getLeft());
                else
                    y.setRight(x.getLeft());
            }
        }else{
            Node<K, V> tmp = x.getRight();
            y = null;
            while (tmp.getLeft() != null){
                y = tmp;
                tmp = tmp.getLeft();
            }
            if(y == null){
                x.setRight(tmp.getRight());
            }else
                y.setLeft(tmp.getRight());
            x.setKey(tmp.getKey());
            x.setValue(tmp.getValue());
        }
        return x;
    }
}
