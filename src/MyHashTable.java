import java.util.LinkedList;
import java.util.Map;

public class MyHashTable   {
    //create your own
    // put (k,v) ,
    // get (k):v
    // remove (k)
    // k: int; v: string
    // collisions: chaining
    // LinkedList<KeyValuePair>

    private class KeyValuePair {
        private int key;
        private String value;

        public KeyValuePair(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList <KeyValuePair>[] entries = new LinkedList[10];

    public void put(int key, String value){
        var index = hashFunction(key);
        if (entries[index]== null){
            entries[index] = new LinkedList<>();
        }

        for (var entry :
                entries[index]) {
            if (entry.key == key){          // there is a key/val pair already
                entry.value = value;        // we update the val
                return;
            }
        }
        // if there is no such k/v pair
        var entry = new KeyValuePair (key, value);
        entries[index].addLast(entry);
    }

    public String get(int key) {
        var index = hashFunction(key);
        if (entries[index] == null) {
            return null;
        }

        for (var entry:
            entries[index]) {
            if (entry.key == key){
                return entry.value;}
        }
        return null;
    }

    private int hashFunction (int key){
        return key% entries.length;
    }

}

