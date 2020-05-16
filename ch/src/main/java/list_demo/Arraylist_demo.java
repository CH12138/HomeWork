package list_demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// ArrayList: 有序的，可重复，不唯一，线程不安全的，效率高
public class Arraylist_demo {
    public static void main(String[] args) {
//        创建集合对象
        ArrayList<String> list = new ArrayList<String>();
//        添加元素
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("d");
        list.add("c");
        System.out.println("集合元素个数："+list.size());
        System.out.println("集合元素："+list);
        //在指定位置添加
        list.add(2, "kate");
        System.out.println("集合元素："+list);

        System.out.println("--------------2---------------------");
        List<String> list2 = new ArrayList<String>();
        list2.add("aaa");
        list2.add("bbb");

        //在末尾处添加一个集合
        list.addAll(list2);
        System.out.println("集合元素："+list);

        System.out.println("--------------3---------------------");
        //在指定位置处，添加1个集合
        list.addAll(1, list2);
        System.out.println("集合元素："+list);


        System.out.println("--------------4---------------------");
        //获取元素
        System.out.println("下标为3的元素："+list.get(3));


        System.out.println("--------------5---------------------");
        //按下标删除，会将要删除的元素返回
//		Object obj1=list.remove(3);
        String obj1=list.remove(3);
        System.out.println("要删除的元素为："+obj1);
        System.out.println("删完后集合元素："+list);

        System.out.println("--------------6---------------------");
        //按元素本身删除，返回的boolean，标明是否删除成功
        boolean flag = list.remove("jack");   //默认删除第1个”jack"
        System.out.println("元素\"jack\"是否删除成功："+flag);
        System.out.println("删完后集合元素："+list);

        System.out.println("--------------7-----------------");

        list.remove("aaa");
        System.out.println("删完后集合元素："+list);

        list.add("aaa");
        System.out.println("添加后集合元素："+list);
        System.out.println("--------------8---------------------");
        //删除某个集合
        boolean flag2=list.removeAll(list2); //只要是属于list2中的元素，都会被删掉
        System.out.println("删除集合list2是否删除成功："+flag2);
        System.out.println("删完后集合元素："+list);


        System.out.println("--------------9---------------------");
        //是否包含 返回值也是 boolean
        boolean flag3 = list.contains("kate");
        System.out.println("是否包含某个元素："+flag3);

        System.out.println("--------------10---------------------");
        //查找某个元素的下标位置  ,找不到返回-1 ，找到[0, size-1]
        int index = list.indexOf("ccc");
        System.out.println("某个元素的下标位置："+index);

        System.out.println("--------------11---------------------");
        //设置某个下标的元素的值
        list.set(1, "jackaaa");
        System.out.println("设置后集合元素："+list);


        System.out.println("--------------12---------------------");
        list.add("kate");
        System.out.println("添加后集合元素："+list);

        int index2 = list.lastIndexOf("kate");
        System.out.println("\"kate\"最后一次出现的下标位置："+index2);
        //清空
        list.clear();
        System.out.println("清空后集合元素个数："+list.size());
        boolean flag4= list.isEmpty();
        System.out.println("集合是否为空："+flag4);
//       第一种遍历方法,使用for-each遍历list
        for(String i :list){
            System.out.println(i);
        }
//        第二种遍历方法，把链表变为数组相关的内容进行遍历
        Integer[] a = new Integer[list.size()];
        list.toArray(a);
        for(int i : a){
            System.out.println(a[i]);
        }
//        第三种遍历方法 使用迭代器进行遍历
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext())//判断写一个元素之后是否有值
        {
            System.out.println(iterator.next());
        }
    }
}
