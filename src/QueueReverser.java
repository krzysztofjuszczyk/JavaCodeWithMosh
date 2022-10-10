import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    public static void main(String[] args) {

        Queue<Integer> myQueue = new ArrayDeque<>();
        myQueue.add(10);
        myQueue.add(20);
        myQueue.add(30);
        myQueue.add(40);

        System.out.print(myQueue);
        reverse(myQueue);
        System.out.println(myQueue);

    }

    public static void reverse(Queue<Integer> queue) {
        //only allowed to use add, remove, isEmpty
        Stack<Integer> integerStack = new Stack<>();

        while (!queue.isEmpty()) {
            integerStack.push(queue.remove());
        }

        while (!integerStack.isEmpty()) {
            queue.add(integerStack.pop());
        }
    }
}
