package list_demo;

import java.util.LinkedList;

//LinkedList在删除插入方面效率高，  ArrayList查询快，增删慢。。
public class LinkedLIst_demo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();

        //添加元素
        list.add("g");
        list.add("t");
        list.add("e");
        list.add(null);
        list.add("c");

        System.out.println("集合中元素的个数："+list.size()+",对应的元素："+list);

        //获取首个元素,末尾元素
        String firstEle = list.getFirst();
//		String firstEle = list.get(0);
        String lastEle = list.getLast();
//		String lastEle = list.get(list.size()-1);
        System.out.println("首个元素："+firstEle+",末尾元素："+lastEle);

        //添加首个元素，末尾元素
        list.addFirst("aaa");
//		list.add(0, "aaa");
        list.addLast("ccc");
//		list.add(list.size(), "ccc");
        System.out.println("集合中元素的个数："+list.size()+",对应的元素："+list);

        //删除首个，末尾元素
        String firstEle2=list.removeFirst();
//		String firstEle2=list.remove(0);
        String lastEle2 = list.removeLast();
//		String lastEle2 = list.remove(list.size()-1);
        System.out.println("删除的首个元素："+firstEle2+",删除的末尾元素："+lastEle2);
        System.out.println("集合中元素的个数："+list.size()+",对应的元素："+list);
    }
}
