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
    }
}
