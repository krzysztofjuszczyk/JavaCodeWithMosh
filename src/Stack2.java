import java.util.Arrays;

public class Stack2 {

    private int[] items = new int[5];
    private int count;

    public void push (int item){
//        if (items ==null){
//            items = new int[]{item};
//        }
//        int[] stack2 = new int[items.length+1];
//        for (int i = 0; i < items.length; i++) {
//            stack2[i] = items[i];
//        }
//        stack2[count++]=item;
//        items = stack2;
        if (count==items.length){
            throw new StackOverflowError();
        }
        items[count++] = item;
    }

    public int pop (){
        if (count==0) throw new IllegalStateException();
        return items[--count];
    }

    public int peek (){
        if (count==0){
            throw new IllegalStateException();
        }
        return items[count-1];
    }

    public boolean isEmpty(){
        return count==0;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
        }


    // push, pop, peek, isEmpty
}
