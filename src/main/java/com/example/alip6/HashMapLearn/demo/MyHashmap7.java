package com.example.alip6.HashMapLearn.demo;


/**  简化版的基于java7实现的HashMap
 * @param <K>
 * @param <V>
 */
public class MyHashmap7 <K,V> {
    /**
     *初始化数组，hashMap底层默认是设置的是16，这一块还有需要了解其的扩容机制
     */
    private Entry[] entries = new Entry[1000];

    public void put(K k,V v){
        // 1.7建议版解决哈希冲突的方式
        int index = k==null?0:k.hashCode() % entries.length;

        Entry oldEntry = entries[index];
        if (oldEntry == null){
            // 无值直接在数组中添加元素
            entries[index] =new Entry(k,v);
        }else {
            // 有值在链表中添加元素
            oldEntry.next = new Entry(k,v);
        }

    }

    public V get(K k){
        // 先获取Key 经过解决Hash冲突后算法后的值
        int index = k  ==null ? 0 : k.hashCode() % entries.length;
        for (Entry entry =  entries[index];entry != null ; entry = entry.next){
            // 需要做K存空的时候的处理
            if ((k == null && entry.k == null) || entry.k.equals(k)) {
                return (V) entry.v;
            }
        }
        return null;
    }

    class Entry <K,V>{
        K k;
        V v;
        Entry next;

        public Entry(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }
    public static void main(String[] args) {
        MyHashmap7<Object,Object> map = new MyHashmap7();
        map.put("a","a");
        map.put(97,97);
        map.put(null,"this is null");
        System.out.println(map.get("a"));
        System.out.println(map.get(97));
        System.out.println(map.get(null));
    }
}
