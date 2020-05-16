package set_demo;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 *  TreeSet
 *  有序的，不能存储null
 *       自然排序（英文字母的顺序，数字从小到大顺序....)
 *   	 也可以自定义比较规则排序 (存储对象)
 */
public class TreeSet_demo {
    public static void main(String[] args) {
        SortedSet<String> set = new TreeSet<String>();

        set.add("jack");
        set.add("tom");
        set.add("helen");
        set.add("alen");
        set.add("张三");
        set.add("张三小");
        set.add("张小三");
        set.add("kiki");
//		set.add(null);

        System.out.println("---------------foreach增强for遍历-------------------------");
        for(String temp:set){
            System.out.println(temp);
        }

    }

}