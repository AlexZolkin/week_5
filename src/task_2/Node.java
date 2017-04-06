package task_2;

/**
 * Created by Алексей on 06.04.2017.
 */
public class Node<K extends Comparable<K>, V>{
    K key;
    V value;
    Node<K, V> left, right;

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
    public V setValue(V value){
        this.value = value;
        return value;
    }
    public void setLeft(K key, V value){
        this.left = new Node<K, V>(key, value);
    }
    public void setRight(K key, V value){
        this.right = new Node<K, V>(key, value);
    }
}
