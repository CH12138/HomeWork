package map_demo;

import java.util.LinkedHashMap;
import java.util.Set;

public class LinkedHashMap_demo {

    public static void main(String[] args) {

        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>(5);

        // add some values in the map
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);


        System.out.println(map);

        /*获取键值对*/
        Set smap = map.entrySet();
        System.out.println(smap);

//        根据键获取值
        System.out.println(map.get("One"));

        // clear the map
        map.clear();


        System.out.println(map);

    }
}
