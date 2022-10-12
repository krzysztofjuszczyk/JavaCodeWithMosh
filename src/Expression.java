import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

    private final List<Character> leftBrackets = Arrays.asList('(','<','[', '{');
    private final List<Character> rightBrackets = Arrays.asList(')', '>', ']', '}');

    public boolean isValid(String input){
        Stack<Character> stack = new Stack<>();
        for (char ch:input.toCharArray()) {
            if (isLeftBracket(ch)) {
                stack.push(ch);
            }
            if (isRightBracket(ch)){
                if (stack.isEmpty()) return false;

                var top = stack.pop();
                if (!bracketsMatch(top, ch)) return false;
            }

//  //moja 1 wersja
//            else if (ch == ')'){
//                if (characterStack.pop() != '(') return false;
//            }
        }
        return stack.isEmpty();
    }

    private boolean isLeftBracket (char ch){
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket (char ch){
        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatch(char left, char right){
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

    public boolean isBalanced (String input){

        Stack <Character> stack = new Stack<>();

        for (char ch: input.toCharArray()) {
            if (isLeftBracket(ch)) {
                stack.push(ch);
            }

            if (isRightBracket(ch)){
                if (stack.isEmpty()) return false;

                //check if brackets match
                if (!bracketsMatch(stack.peek(), ch)) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }


}
