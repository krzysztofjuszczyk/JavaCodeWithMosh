import java.util.LinkedList;

public class MyHashTable {
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

    private LinkedList<KeyValuePair>[] entries = new LinkedList[5];

    public void put(int key, String value) {
        var index = hashFunction(key);
        if (entries[index] == null) {
            entries[index] = new LinkedList<>();
        }

        for (var entry :
                entries[index]) {
            if (entry.key == key) {          // there is a key/val pair already
                entry.value = value;        // we update the val
                return;
            }
        }
        // if there is no such k/v pair
        var entry = new KeyValuePair(key, value);
        entries[index].addLast(entry);
    }

    public String get(int key) {
        var entry = getKeyValuePair(key);

        return (entry == null) ? null : entry.value;

//        if (entry == null){
//            return null;
//        }
//        return entry.value;


//        var index = hashFunction(key);
////        if (entries[index] == null) {
////            return null;
////        }
//        if (entries[index]!=null) {
//            for (var entry :
//                    entries[index]) {
//                if (entry.key == key) {
//                    return entry.value;
//                }
//            }
//        }
//        return null;
    }

    public void remove(int key) {
        var entry = getKeyValuePair(key);
        if (entry == null) {
            throw new IllegalStateException();
        }
        getBucket(key).remove(entry);


//        var index = hashFunction(key);
//        if (entries[index] == null) {
//            throw new IllegalStateException();}
//
//            for (var entry :
//                    entries[index]) {
//                if (entry.key == key){
//                    entries[index].remove();
//                    return;
//                }
//            }
//            throw new IllegalStateException();
    }

    private int hashFunction(int key) {
        return key % entries.length;
    }

    private LinkedList<KeyValuePair> getBucket(int key) {
        return entries[hashFunction(key)];
    }


    private KeyValuePair getKeyValuePair(int key) {
        var bucket = getBucket(key);
        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key)
                    return entry;
            }
        }
        return null;
    }


}

