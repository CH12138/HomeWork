package map_demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//hashMap:无序，可以存储null , 键不能重，值可以重复
public class HashMap_demo {
    public static void main(String[] args) {
        /*创建集合对象*/
        Map<String, String> map = new HashMap<String,String>();
        map.put("CSS", "style");
        map.put("HTML", "mark up");
        map.put("Oracle", "database");
        map.put("XML", "data");
        printDetails(map);
        map.clear();
        printDetails(map);
    }

    public static void printDetails(Map<String, String> map) {

        /*获取键值对*/
        Set smap = map.entrySet();
        System.out.println(smap);

        String usage = map.get("CSS");
        System.out.println("Map: " + map);
        System.out.println("Map Size:  " + map.size());
        System.out.println("Map is empty:  " + map.isEmpty());
        System.out.println("Map contains CSS key:   " + map.containsKey("CSS"));
        System.out.println("Usage:  " + usage);
        System.out.println("removed:  " + map.remove("CSS"));


    }
}
