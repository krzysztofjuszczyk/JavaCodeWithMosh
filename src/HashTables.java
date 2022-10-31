
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashTables {
    public static void main(String[] args) {
        // ex.1 find first non-repeatable character

        String test = "a green apple";
        System.out.println(firstNonRepeatable(test));
        System.out.println(firstRepeated(test));

    }

    public static char firstNonRepeatable (String input){
        Map<Character, Integer> hashMap = new HashMap<>();
        input = input.replaceAll(" ", "");

        //rozw. 1 tworzymy mapę char / ilość wystąpień
        // można poprawić wywołaniem raz toCharArray i operatorem trójarg.
        for (var i: input.toCharArray()
             ) {
            if (hashMap.containsKey(i)){
                int value = hashMap.get(i);
                hashMap.put(i, ++value);
            }
            else {
                hashMap.put(i, 1);
            }
        }
        // iterujemy jeszcze raz i zwracamy pierwsze wystąpienie
        for (var i :
                input.toCharArray()) {
            if (hashMap.get(i)==1) return i;
        }
        throw new IllegalStateException(); // albo coś innego
    }

    //ex. 2 first Repeated - SET
    public static char firstRepeated (String input){
        Set<Character> characterSet = new HashSet<>();
        for (var i  :input.toCharArray()
             ) {
            if (characterSet.contains(i)) return i;
            characterSet.add(i);
        }
        throw new IllegalStateException(); // albo coś innego

    }


}
