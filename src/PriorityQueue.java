import java.util.Arrays;

public class PriorityQueue {
    public static void main(String[]args){
        PriorityQueue queue = new PriorityQueue();
        queue.add(5);
        queue.add(7);

        queue.add(6);
        queue.add(99);
        queue.add(2);


        System.out.println(queue);
        System.out.println(queue.count);
    }

    private int[] items = new int[5];
    private int count;

    public void add (int item){
        if (count == items.length)throw new IllegalStateException();  //pełna

        // moje brzydkie
        // shifting items
        int i;
        if (count == 0) {
            items[0] = item;
            count++;
            return;
        }
        for (i = count-1; i >=0  ; i--) {
            if (items[i] > item){
                items[i+1] = items[i];
            }
            else {
                items[i+1]=item;
                break;};
        }
        count++;
    }
//            for (i = count-1; i >=0  ; i--) {
//        if (items[i] > item){
//            items[i+1] = items[i];
//        }
//        else break;
//    }
//
//    items[i+1]=item;
//    count++;
//}
    public int remove(){
        if (isEmpty()) throw new IllegalStateException();
        return items[--count];
    }

    public boolean isEmpty(){
        return count==0;
    }


    public String toString(){
        return Arrays.toString(items);
    }
}
