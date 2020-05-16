package queue_demo;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDeque_demo {
    public static void main(String[] args) {
        // Create a Deque and use it as stack
        Deque<String> deque = new ArrayDeque<String>();
        deque.push("Oracle");
        deque.push("HTML");
        deque.push("CSS");
        deque.push("XML");

        System.out.println("Stack: " + deque);

        // remove all elements from the Deque
        while (deque.peek() != null) {
//            检索但不删除由此deque表示的队列的头部，如果此deque为空，则返回 null 。
            System.out.println("Element at  top:  " + deque.peek());
            /*从这个deque表示的堆栈中弹出一个元素。 */
            System.out.println("Popped: " + deque.pop());
            System.out.println("Stack: " + deque);
        }

        System.out.println("Stack is  empty:  " + deque.isEmpty());
    }
}
