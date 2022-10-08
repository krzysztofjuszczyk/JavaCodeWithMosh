import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("starting");

        Array numbers = new Array(3);
        numbers.print();

        System.out.println("dodajemy ");
        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);
        numbers.insert(40);
        numbers.insert(50);

        numbers.print();
        Array numbers2 = new Array(5);
        numbers2.insert(10);
        numbers2.insert(20);
        numbers2.insert(30);
        numbers2.insert(40);
        numbers2.insert(50);
        numbers2.print();
        System.out.println();
        numbers2.removeAt(0);
        numbers2.print();

        System.out.println("remove at 1");
        numbers.removeAt(4);
        System.out.println("After removing item at index 4");
        numbers.print();
        System.out.println(numbers.indexOf(30));
        System.out.println(numbers.indexOf(1));
        System.out.println("Max number in array: " + numbers.max());
        System.out.println("Array after reversing");
        numbers.reverse();
        numbers.print();

        numbers.insertAt(3, 1);
        numbers.print();

        //LINKED LIST EXCERCISES
        var list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        int a = 30;
        System.out.println("index of " + a + " = " + list.indexOf(a));
        System.out.println("contains: " + a + "? " + list.contains(a));
        list.removeFirst();

        System.out.println("Removed first. Contains " + a + "? "+ list.contains(a));
        System.out.println("Add first: 10");
        list.addFirst(10);
        System.out.println("Contains 10? " +list.contains(10));
        System.out.println("Removed last: 30");
        list.removeLast();
        System.out.println("Index of "+ a + ": "+ list.indexOf(a));
        System.out.println("Contains " + a + ": " + list.contains(a));

        System.out.println("Removed last: 20");
        list.removeLast();
        System.out.println("?20: "+ list.contains(20));
        System.out.println(list.size());

        System.out.println("Removed last: 10");
        list.removeLast();
        System.out.println("?10: "+ list.contains(10));
        System.out.println(list.size());

        System.out.println(list.size());
        list.addLast(10);
        System.out.println(list.size());
        list.addFirst(5);
        list.addLast(15);
        list.addLast(20);
        list.addLast(25);
        list.addLast(30 );

        var array2 = list.toArray();
        System.out.println(Arrays.toString(array2));
        System.out.println("middle: ");
        list.printMiddle2();
        list.reverse();
        System.out.println("list reversed");
        var array3 = list.toArray();
        System.out.println(Arrays.toString(array3));
        System.out.println("size of list: " + list.size());


        int k = 3;
        System.out.println("Value of " + k + "-th Node from the end is: " + list.getKthFromTheEnd(k));



    }
}
