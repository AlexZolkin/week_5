package task_2;

/**
 * Created by Алексей on 06.04.2017.
 */
public class Node<K extends Comparable<K>, V>{
    private K key;
    private V value;
    private Node<K, V> left, right;

    public Node(K key, V value){
        this.key = key;
        this.value = value;
    }
    public Node(){
        this.key = null;
        this.value = null;
    }
    public Node<K, V> getLeft(){
        return this.left;
    }
    public Node<K, V> getRight(){
        return this.right;
    }
    public K getKey(){
        return this.key;
    }
    public V getValue(){
        return this.value;
    }
    public K setKey(K key){
        this.key = key;
        return key;
    }
    public V setValue(V value){
        this.value = value;
        return value;
    }
    public void setLeft(K key, V value){
        if(key == null || value == null){
            this.left = null;
            return;
        }
        this.left = new Node<K, V>(key, value);
    }
    public void setRight(K key, V value){
        if(key == null || value == null){
            this.right = null;
            return;
        }
        this.right = new Node<K, V>(key, value);
    }
    public void setLeft(Node<K, V> left){
        this.left = left;
    }
    public void setRight(Node<K, V> right){
        this.right = right;
    }
}
