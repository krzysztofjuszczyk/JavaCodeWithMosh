import java.util.Stack;

public class StringReversal {
    public String reverse(String input) {
        Stack<Character> stack = new Stack<>();

        // wersja 1 moja pierwsza
        /*
        for (int i = 0; i < input.length(); i++   ) {
            stack.push(input.charAt(i));
        }
        String stringReversed = "";
        for (int i = 0; i < input.length(); i++) {
            stringReversed += stack.pop();
        }
        return stringReversed;
        //kiepsko, bo za każdym razem tworzy nowy obiekt w pamięci

        */
        if (input == null) {
            throw new IllegalStateException();
        }
        for (char ch : input.toCharArray()
        ) {
            stack.push(ch);
        }
        StringBuffer stringReversed = new StringBuffer();
        while (!stack.empty()) {
            stringReversed.append(stack.pop());
        }
        return stringReversed.toString();
    }
}


