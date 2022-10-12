import java.util.NoSuchElementException;

public class LinkedList {


    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first; // head
    private Node last; // tail
    private int sizeOfList;

    public void addFirst(int item) {
        var node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        sizeOfList++;
    }

    public void addLast(int item) {
        var node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        sizeOfList++;
    }

    private boolean isEmpty() {
        return first == null;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        //  niepotrzebnie dodałem wariant z 1 elementem
//        if (first == last){
//            first = last = null;
//            sizeOfList--;
//            return;
//        }

        var second = first.next;
        first.next = null;
        first = second;
        sizeOfList--;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (first == last) {
            first = last = null;
        } else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        sizeOfList--;


        // 1st version
//        var currentNode = first.next;     // co jeśli null?
//        var previousNode = first;
//        while (currentNode.next != null){
//            previousNode = currentNode;
//            currentNode = currentNode.next;
//        }
//        last = previousNode;
//        last.next = null;

    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
//        var currentNode = first;
//        while (currentNode != null){
//            if (currentNode.value == item) return true;
//            else
//            {
//                currentNode = currentNode.next;
//            }
//
//        }
//        return false;
    }

    public int indexOf(int item) {
        int index = 0;
        var currentNode = first;
        while (currentNode != null) {
            if (currentNode.value == item) return index;
            else {
                index++;
                currentNode = currentNode.next;
            }
        }
        return -1;
    }

    public int size() {
        return sizeOfList;

        // 1st version
//        if (isEmpty()) return 0;
//        var current = first;
//        int counter = 1;
//        while (current.next != null) {
//            counter++;
//            current = current.next;
//        }
//        return counter;
    }

    public int[] toArray() {
        int[] array = new int[sizeOfList];
        var current = first;
        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }

    public int findKthNode(int k) { // MY 1st VERSION

        if (k <= 0 || k > sizeOfList) {
            throw new IllegalArgumentException();
        } else if (k == 1) {
            return last.value;
        }

        var pointer1 = first.next;
        var pointer2 = first;
        int distance = 1;

        // ustalamy dystans
        while (distance < k - 1) {
            pointer1 = pointer1.next;
            distance++;
        }
        // przesuwamy pointer w prawo az do konca
        while (pointer1 != last) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer2.value;
    }

    public int getKthFromTheEnd(int k) {
        if (isEmpty()) throw new IllegalStateException();
        var p1 = first;
        var p2 = first;

        for (int i = 0; i < k - 1; i++) {
            p1 = p1.next;
            if (p1 == null) {
                throw new IllegalArgumentException();
            }
        }

        while (p1 != last) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2.value;
    }

    public void printMiddleMOJA() {
        // brzydkie rozwiązanie
        if (isEmpty()) throw new IllegalArgumentException();

        var p1 = first;
        var p2 = first;
        int howManyPasses = 0;

        while (p1 != last) {
            p1 = p1.next;
            howManyPasses++;
        }
        if (howManyPasses % 2 == 0) {
            for (int i = 0; i < (howManyPasses / 2); i++) {
                p2 = p2.next;
            }
            System.out.println(p2.value);
        }

        //nieparzysta
        else {
            for (int i = 0; i < (howManyPasses / 2); i++) {
                p2 = p2.next;
            }
            System.out.println(p2.value + " " + p2.next.value);
        }
    }

    public void printMiddle2(){
        var p1 = first;
        var p2 = first;

        while (p1.next != last && p1 != last){
            p1 = p1.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == last){
            System.out.println(p2.value);
        }
        else {
            System.out.println(p2.value);
            System.out.println(p2.next.value);
        }

    }

    public void printMiddle() {
        var p1 = first;
        var p2 = first;

        while (p2 != last && p2.next != last) {
            p1 = p1.next;
            p2 = p2.next;
            p2 = p2.next;
        }
        if (p2 == last) {
            System.out.println(p1.value);
        } else
            System.out.println(p1.value + " " + p1.next.value);
    }

    public void reverse() {
        if (isEmpty()) {
            return;
        }

        var previous = first;
        var current = first.next;

        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;

//    //        var tempLast = first;
//    var p = first;
//    var c = first.next;
//
//        while (c!=null){
//                var n = c.next;
//                c.next = p;
//                p = c;
//                c = n;
//
//                }
//
//                first = last;
////        last = tempLast;
//                last = p;
//                last.next = null;

    }


    public void reverse3() {
//        if (sizeOfList==1) return;
//        else if (sizeOfList==2){
//            var no1 = first;
//            first = last;
//            first.next = last = no1;
//            last.next = null;
//        }
//        else {
        if (isEmpty()) return;

        var previous = first;
        var current = first.next;
        while (current != null) {
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;

//        // moja wersja z tworzeniem dodatkowej tablicy, działa tylko przy int
//        var current = first;
//        int[] array = new int[sizeOfList];
//
//        // pętla przypisująca wartości do tablicy
//        for (int i = array.length-1; i >= 0; i--){
//
//          array[i] = current.value;
//          current = current.next;
//          removeFirst();
//        }
//        for (int i=0; i< array.length; i++){
//            addLast(array[i]);
    }

    public void reverse2() {             // MOJA WERSJA BRZYDSZA
        if (sizeOfList <= 0) {                   // powinno być isEmpty? return
            throw new IllegalStateException();
        }
        if (sizeOfList == 1) {                     //niepotrzebne
            return;
        }

        var prev = first;
        var curr = first.next;

        var next = curr.next;           // to powinno być w pętli poniżj, zdublowany kod
        last = first;
        last.next = null;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            if (next != null) {
                curr = next;
            } else break;
            next = curr.next;
        }
        first = curr;
    }
    public boolean hasLoop() {


        var slow = first;
        var fast = first;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;

    }

    public static LinkedList createWithLoop() {
        var list2 = new LinkedList();
        list2.addLast(10);
        list2.addLast(20);
        list2.addLast(30);

        // Get a reference to 30
        var node = list2.last;

        list2.addLast(40);
        list2.addLast(50);

        // Create the loop
        list2.last.next = node;

        return list2;
    }


}


