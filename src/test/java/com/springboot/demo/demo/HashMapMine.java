package com.springboot.demo.demo;

public class HashMapMine{
    public static void main(String[] args) {
        HashMap<String,String> test =new HashMap<>();
        test.put("vishal","12");
        test.put("sachin","30");
        test.put("vaibhav","40");
        test.put("AaAaBB1","40");
        test.put("AaAaAa1","10");
        test.put("vishal1","12");
        test.put("sachin1","30");
        test.put("vaibhav1","40");
        test.put("AaAaBB2","400");
        test.put("AaAaAa2","10");
        test.put("vishal2","12");
        test.put("sachin2","30");
        test.put("vaibhav2","40");
        test.put("AaAaBB3","40");
        test.put("AaAaAa3","10");
        System.out.println(test.get("AaAaBB2"));
        System.out.println(test.get("AaAaAa2"));
        System.out.println(test);
    }

        }

class   HashMap<K,V> {
    private static int defaultSize = 16;
    private double FORM_FACTOR = .75;
    private int bucketSize = (int) (16 * FORM_FACTOR);

   HashNode bucketList [] = new HashNode[defaultSize];

    public void put(K k, V v) {
        int index = k.hashCode() & (defaultSize - 1);
        HashNode node = new HashNode();
        if (bucketList[index] == null) {

            node.hash = k.hashCode();
            node.key = k;
            node.value = v;
            node.next = null;
            bucketList[index] =node;
        }else{
             node= bucketList[index];
            if(node.key.equals(k))
                return;
            while (node.next!=null){
                if(node.key.equals(k))
                    return;
                node=node.next;
            }
           HashNode nodeNew = new HashNode();
            nodeNew.hash = k.hashCode();
            nodeNew.key = k;
            nodeNew.value = v;
            nodeNew.next = null;
            node.next=nodeNew;

        }


    }

    public V get(K k){
        int index = k.hashCode() & (defaultSize - 1);
        HashNode node = bucketList[index];
        if(node==null) return null;
        if(node.key.equals(k))
            return (V) node.value;
        while (node.next!=null){
            if(node.key.equals(k))
                return (V) node.value;
            node=node.next;
        }
        if(node.key.equals(k))
            return (V) node.value;

        return null;

    }






}
class HashNode<K,V>{
    int hash;
    K key;
    V value;
    HashNode<K,V> next;

}
