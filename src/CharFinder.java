import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    public char findFirstChar2(String str) {
        Map<Character, Integer> map = new HashMap<>();
        var chars = str.toCharArray();
        for (var ch : chars
        ) {
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

//            if (map.containsKey(ch)) {
//                var count = map.get(ch);
//                map.put(ch, count + 1);
//            } else
//                map.put(ch, 1);


        System.out.println(map.toString());

        for (var ch : chars
        ) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return ' ';
    }


    public char findFirstRepeatable(String str) {
        // wersja 1 z HashSet
        Set<Character> characterSet = new HashSet<>();
        var charArray = str.toCharArray();
        for (var ch : charArray
        ) {
            characterSet.add(ch);

            // MOJA WERSJA - pierwszy ktory bedzie miał 2 wystąpienie
            //            if (characterSet.contains(ch)) {
//                return ch;
//            } else {
//                characterSet.add(ch);
//            }

        }
        System.out.println(characterSet);
        for (var ch : charArray
                ) {
            if (characterSet.contains(ch)) {
                return ch;
            }

        }


//      WERSJA 2 Z HASHMAP
//         Map <Character, Integer> map = new HashMap<>();
//
//        char [] str2 = str.toCharArray();
//        for (var ch: str2
//             ) {
//            var countChars = map.containsKey(ch) ? map.get(ch) : 0;
//            map.put(ch, countChars+1);
//
//        }
//        for (var ch: str2
//             ) {
//            if (map.get(ch) == 2){
//                return ch;
//            }
//        }
     return Character.MIN_VALUE;


    }
}

