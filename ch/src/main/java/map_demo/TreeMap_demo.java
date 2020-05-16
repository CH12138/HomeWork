package map_demo;

import java.util.*;

/*TreeMap  :不能存储null(键不能空),
* 有序，自然排序（数字从小到大，英文字母顺序 指的是键的排序）  ，或者自定义排序规则 (指的也是键）
*  */
public class TreeMap_demo {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<Integer,String>();
        map.put(10, "aaa");
        map.put(20, "bbb");
        map.put(15, "ccc");
        map.put(30, "eee");
        map.put(12, "fff");
//		map.put(null, null);
//		map.put(null, "hello");
        map.put(2, null);

        bianliFirst(map);
    }

    public static void bianliFirst(Map<Integer,String> map){
        Set<Integer> keys = map.keySet();
        //遍历键集 ，keys遍历方式可以是foreach,Iterator迭代器
        Iterator<Integer> it = keys.iterator();
        while(it.hasNext()){
            //获取键
            Integer key = it.next();
            //根据键，获取值
            String val = map.get(key);
            System.out.println("key="+key+",val="+val);
        }
    }

}