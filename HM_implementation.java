import java.util.*;
public class HM_implementation {
    static class HashMap<K,V>{ //generics
        private class Node{
            K key;
            V value;

            Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        
        private int n; //no. of nodes in a LL of bi
        private LinkedList<Node> buckets[]; //private int arr[] -> when we initialise any array
        private int N; //buckets.length-1
        
        @SuppressWarnings("unchecked")
        public HashMap(){
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % N; 
        }

        private int SearchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            for(int i=0; i<ll.size(); i++){
                Node node = ll.get(i);
                if(node.key == key){ //key found
                    return i;
                }
            }
            return -1; // key not found
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[N*2];
            N=N*2;
            for(int i=0; i<buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }

            for(int i=0; i<oldBuck.length; i++){
                LinkedList<Node> ll = oldBuck[i];
                for(int j=0; j<ll.size(); j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if(di != -1){ //value update
                Node node = buckets[bi].get(di);
                node.value = value;
            }
            else{
                buckets[bi].add(new Node(key, value));
                n++;
            }

           double lambda = (double)n/N;
           if(lambda > 2.0){
                rehash();
           }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if(di != -1){
                return true;
            }
            return false;
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if(di != -1){
               Node node = buckets[bi].remove(di);
               n--;
               return node.value;  
            }
            else{
                return null;
            }
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = SearchInLL(key, bi);

            if(di != -1){
                return buckets[bi].get(di).value;
            }
            else{
                return null;
            }
        }

        public int size(){
            return n;
        }  

        public boolean isEmpty(){
            if(n==0){
                return true;
            }
            return false;
        }

        public ArrayList<K> keySet(){
            ArrayList<K> al = new ArrayList<>();
            for(int i=0; i<N; i++){
                LinkedList<Node> ll =  buckets[i];
                for(int j=i; j<ll.size(); j++){
                    Node node = ll.get(j);
                    al.add(node.key);
                }
            }
            return al;
        }
        
    }

    public static void main(String args[]){
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("Nepal", 70);
        hm.put("Japan", 100);

        ArrayList<String> keys = hm.keySet();
        // System.out.print(keys + " ");

        for(String k: keys){
            System.out.println(k);

        }

        // System.out.println(hm.get("India"));
        // System.out.println(hm.get("USA"));

        // System.out.println(hm.containsKey("USA"));
        // System.out.println(hm.containsKey("Japan"));

        // System.out.println(hm.remove("China"));

        // System.out.println(hm.size());

        // System.out.println(hm.isEmpty());
      

       

    }
}
