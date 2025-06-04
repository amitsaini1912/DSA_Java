import java.util.*;
public class HashMap_Implementation {
    static class HashMap<K,V>{//Generic
        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n; //size
        private int N;
        private LinkedList<Node> Buckets[]; //N

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.Buckets = new LinkedList[4];
            for(int i=0; i<4; i++){
                this.Buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }

        private int SearchInLL(K key, int bi){
            LinkedList<Node> ll = Buckets[bi];
            int di = 0;

            for(int i=0; i<ll.size(); i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }

        private void rehash(){
            LinkedList<Node> oldBuck[] = Buckets;
            Buckets = new LinkedList[N*2];
            N = N*2;
            for (int i=0; i<Buckets.length; i++){
                Buckets[i] = new LinkedList<>();
            }

            //nodes -> add in Bucket
            for(int i=0; i<oldBuck.length; i++){
                LinkedList<Node> ll = oldBuck[i];
                for(int j=0; j<ll.size(); j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }
        public void put(K key, V value){ //O(lambda) -> O(1)
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if(di != -1){
                Node node = Buckets[bi].get(di);
                node.value = value;
            }else{
                Buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n/N;
            if(lambda > 2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){ //O(1)
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if(di != -1){
                return true;
            }else{
                return false;
            }
        }

        public V remove(K key){ //O(1)
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if(di != -1){
                Node node = Buckets[bi].remove(di);
                n--;
                return node.value;
            }else{
               return null;
            }
        }

        public V get(K key){ //O(1)
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if(di != -1){
                Node node = Buckets[bi].get(di);
                return node.value;
            }else{
                return null;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for (int i = 0; i < Buckets.length ; i++) {
                LinkedList<Node> ll = Buckets[i];
                for(Node node: ll){
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty(){
            return n==0;
        }

    }

    public static void main(String args[]){
         HashMap<String, Integer> hm = new HashMap<>();
         hm.put("India", 100);
         hm.put("Chine", 150);
         hm.put("US", 50);
         hm.put("Nepal", 5);

         ArrayList<String> keys = hm.keySet();
         for (String key : keys){
             System.out.println(key);
         }

        System.out.println(hm.get("India"));
        System.out.println(hm.remove("India"));
        System.out.println(hm.get("India"));

        System.out.println(hm.containsKey("India"));
    }
}
