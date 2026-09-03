import java.util.*;
public class hashMapex {
  public static void main(String[] args) {
    //Create
    HashMap<String,Integer> hm = new HashMap<>();
    //Insert -> O(1)
    hm.put("India", 100);
    hm.put("China", 150);
    hm.put("US", 50);
    System.out.println(hm); // unordered
    //Get ->O(1)
    int population = hm.get("India");
    System.out.println(population);
    System.out.println(hm.get("Indonesia"));
    //ContainsKey - O(1)
    System.out.println(hm.containsKey("India"));
    System.out.println(hm.containsKey("Indonesia"));
    //Remove 
    System.out.println(hm.remove("China"));
    //Is Empty
    System.out.println(hm.isEmpty());
    //Iterate
    Set<String> keys = hm.keySet(); // O(1)
    System.out.println(keys);
    for(String k : keys) {
      System.out.println("key "+k+" value= "+hm.get(k));
    }
    LinkedHashMap<String,Integer> hm1 = new LinkedHashMap<>(); // keys are insertion ordered //Doubly LL used
    hm1.put("India", 100);
    hm1.put("China", 150);
    hm1.put("US", 50);
    System.out.println(hm1);
    TreeMap<String,Integer> hm2 = new TreeMap<>();// put,get,remove are O(logn)
    hm2.put("India", 100);  // keys are sorted
    hm2.put("China", 150); // Internal implementation is Red black trees
    hm2.put("US", 50);
    System.out.println(hm2);
  }
}
