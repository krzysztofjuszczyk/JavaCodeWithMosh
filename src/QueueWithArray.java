import java.util.Arrays;

public class QueueWithArray {
    private int[] items;
    private int back;
    private int front;
    private int count;

    public static void main(String[] args) {
        QueueWithArray queueWithArray = new QueueWithArray(5);
        System.out.println("isEmpty? "+ queueWithArray.isEmpty());
        System.out.println("isFull? "+ queueWithArray.isFull());
        queueWithArray.enqueue(10);
        queueWithArray.enqueue(20);
        queueWithArray.enqueue(30);
        System.out.println(queueWithArray);

        System.out.println("isFull? "+ queueWithArray.isFull());

        System.out.println(queueWithArray.dequeue());
        System.out.println(queueWithArray.dequeue());
        System.out.println(queueWithArray);

        System.out.println("isEmpty? "+ queueWithArray.isEmpty());
        queueWithArray.enqueue(40);
        queueWithArray.enqueue(50);

        System.out.println(queueWithArray.dequeue());
        System.out.println(queueWithArray);

        queueWithArray.enqueue(60);
        queueWithArray.enqueue(70);

        System.out.println(queueWithArray);
        System.out.println(queueWithArray.dequeue());
        System.out.println(queueWithArray.dequeue());
        System.out.println(queueWithArray);
        System.out.println(queueWithArray.dequeue());
        System.out.println(queueWithArray);
    }


    public QueueWithArray(int size){
        items = new int[size];
    }


   public void enqueue(int item){
        if (isFull()) throw new IllegalStateException();
       if (back == items.length)
           back = items[0];
        items[back++] = item;
        count++;


   }

    public int dequeue(){
        if (isEmpty())throw new IllegalStateException("you can't dequeue an empty queue");
        if (front == back ) throw new IllegalStateException("you can't dequeue an empty queue");
        if (front == items.length) front = 0;

        var temp = items[front];
        items[front]=0;

        front++;
        count--;
        return (temp);
    }

    public int peek(){
        if (front==back) throw new IllegalStateException();
        return items[front];
    }

    public boolean isEmpty(){
        return count==0;
    }

    public boolean isFull(){
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
