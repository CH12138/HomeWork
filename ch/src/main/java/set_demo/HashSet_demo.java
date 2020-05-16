package set_demo;

import java.util.*;

/*
* 用法
* hashSet无序（不能用索引） ，唯一，不能重复，可以存储null
*  1.hashcode值不同，可以确定是2个不同的对象。
*  2.如果是2个相同的对象（认为是同一个对象），hashcode值一定相同。
*  3.不同的对象，有可能会生成相同的hashcode值。
* */
public class HashSet_demo {
    public static void main(String[] args) {

        HashSet<String> set = new HashSet<String>();

        String s1="jack",s2="jack";
        System.out.println(s1.hashCode() +"\t"+s2.hashCode());
        //添加元素
        set.add("jack");
        set.add("tom");
        set.add(null);
        set.add("jack"); //没有加进去
        set.add("kate");
        set.add("bob");
        set.add("helen");
        System.out.println("元素个数："+set.size());

        boolean flag=set.contains("jack");
        System.out.println("set中是否包含元素\"jack\":"+flag);


        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        //set中添加一整个集合元素
        set.addAll(list);


        List<String> list2 = new ArrayList<String>();
        list2.add("aaa");
        list2.add("eee");

        //判断是否包含某个集合中的所有元素 如果此 set 包含指定 collection 的所有元素，则返回 true。
        boolean flag2=set.containsAll(list2);
        System.out.println("是否包含list:"+flag2);

        System.out.println("---------------foreach增强for遍历-------------------------");
        for(String temp:set){
            System.out.println(temp);
        }

        System.out.println("---------------Iterator迭代器遍历-------------------------");
        //获取迭代器对象
        Iterator<String> it = set.iterator();
        //hasNext():判断是否有下一个可供迭代的元素，next()获取下一个元素
        while(it.hasNext()){
            System.out.println(it.next());
        }

        //清空
        set.clear();
        System.out.println("清空后元素个数："+set.size());

        boolean flag3 = set.isEmpty();
        System.out.println("集合是否为空（元素个数是否为0）："+flag3);
    }
}