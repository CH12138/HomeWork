package queue_demo;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedList_demo {
    public static void main(String[] args) {
        Deque<String> queue = new LinkedList<String>();
        queue.add("Java");
        // offer() will work the same as add()
        queue.offer("SQL");
        queue.offer("CSS");
        queue.offer("XML");

        System.out.println("Queue: " + queue);

        // Let's remove elements until the queue is empty
        while (queue.peek() != null) {
            System.out.println("Head  Element: " + queue.peek());
            queue.remove();
            System.out.println("Removed one  element from  Queue");
            System.out.println("Queue: " + queue);
        }
        System.out.println("queue.isEmpty(): " + queue.isEmpty());
        /*检索但不删除此列表的头（第一个元素）*/
        System.out.println("queue.peek(): " + queue.peek());

        /*检索并删除此列表的头（第一个元素）。 */
        System.out.println("queue.poll(): " + queue.poll());
        try {
            /*检索但不删除此列表的头（第一个元素）*/
            String str = queue.element();
            System.out.println("queue.element(): " + str);
            str = queue.remove();
            System.out.println("queue.remove(): " + str);
        } catch (NoSuchElementException e) {
            System.out.println("queue.remove(): Queue is  empty.");
        }
    }
}