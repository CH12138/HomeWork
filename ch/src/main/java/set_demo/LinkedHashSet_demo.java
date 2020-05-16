package set_demo;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSet_demo {
    public static void main(String[] args) {

        Set<String> s1 = new LinkedHashSet<String>();
        s1.add("A");
        s1.add("C");
        s1.add("B");
        s1.add("D");
        System.out.println("LinkedHashSet: " + s1);
        /*删除某一元素*/
        s1.remove("B");
        System.out.println("LinkedHashSet: " + s1);

        /*删除全部元素*/
        s1.clear();
        System.out.println("LinkedHashSet: " + s1);


    }
}