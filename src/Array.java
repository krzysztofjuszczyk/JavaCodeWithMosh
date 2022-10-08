public class Array {

    private int[] items;
    private int count;

    Array(int length) {
        items = new int[length];
    }


    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }


    public void insert(int item) {
        if (needsResizing()) {
            int[] items2 = new int[count * 2];
            for (int i = 0; i < count; i++) {
                items2[i] = items[i];
            }
            items = items2;
        }
        items[count++] = item;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        for (int i = index; i < count - 1; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    private boolean needsResizing() {
        return items.length == count;
    }

    public void reverse() {
        int[] newItems = new int[count];
        for (int i = 0; i < count; i++) {
            newItems[i] = items[count - 1 - i];
        }
        items = newItems;
    }

    public int max () {
        int max = items[0];
        for (int i=1; i<count; i++){
            if (items[i]>max ){
                max = items[i];
            }
        }
        return max;
    }

    public void insertAt (int item, int index){
        //validate index
        if (index<0 || index >= count){
            throw new IllegalArgumentException();
        }
        //resize
        int[] newItems = new int[count * 2];

        count++;
        for (int i=0; i<index; i++){
            newItems[i]=items[i];
        }
        for (int i=count-1; i>index; i--){
            newItems[i]= items[i-1];
        }
        newItems[index]= item;
        items = newItems;
    }

}