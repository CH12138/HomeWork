package queue_demo;
import java.util.PriorityQueue;

public class PriorityQueue_demo{
    public static void main(String args[]) {

        PriorityQueue<Integer>   prq = new PriorityQueue<Integer>();

        for ( int i = 3; i < 10; i++ ){
            prq.add(i) ;
        }

        System.out.println(prq);

        // 检索但不删除此队列的头，如果此队列为空，则返回 null 。
        Integer head = prq.peek();

        prq.remove();
//        检索并删除此队列的头，如果此队列为空，则返回 null
        prq.poll();
        System.out.println("Head of the queue is: "+ head);

        /*返回一个包含此队列中所有元素的数组。 */
        Object[] array = prq.toArray();
        for(Object a :array){
            System.out.print(a);
        }

    }
}