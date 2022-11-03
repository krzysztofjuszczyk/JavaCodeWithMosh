import java.util.HashMap;

public class HashTableEx {
    public static void main(String[] args) {
        int[] input = {1,2,2,3,3,3,4};
        System.out.println(mostFrequentElement(input));

        int[] input2 ={1,7,5,9,2,12,3};
        int k =2;
        System.out.println("number of pairs with difference " + k + ": " + countPairsWithDifference(input2, k));

    }

    public static int mostFrequentElement (int[] array){

        HashMap <Integer, Integer> results = new HashMap();
        // tworzymy tablicę wartość, ile razy występuje
        for (int key :
                array) {
            if (results.containsKey(key)){
                int value = results.get(key);
                results.put(key, ++value);
            }
            else results.put(key, 1);
        }


        //określamy który int jest najczęstszy
        int maxValue = 0; // jak ominąć?
        int result = 0;

        for (var entry:
             results.entrySet()) {
            if (entry.getValue()>maxValue){
                maxValue = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }

    public static int countPairsWithDifference(int[] array,int difference){
        // dwie pętle O(n2), do poprawy przez HashSet
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length ; j++) {
                if (array[i]+ difference== array[j]) {
                    result++;
                }
            }
        }
        return result;
    }


}
