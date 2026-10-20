import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class hashsetex {
  public static void main(String[] args) {
    //Hashset is implemented using hashmap internally
    //no duplicates(unique)
    //unordered
    //NULL is allowed
    // HashSet -> HashMap
    // LinkedHashSet -> LinkedHashMap Order is Maintained // performance is slight less due to extra operations to maintain order than normal hashset /map
    // TreeSet -> TreeMap // sorted in ascending order NULL values are NOT allowed implemented in the form of treemap help of red black tree (self balancing) operations are in O(logn)
    HashSet<Integer> set = new HashSet<>();
    //add(key) O(1);
    //contains(key) O(1);
    //remove(key) O(1);
    set.add(1);
    set.add(2);
    set.add(4);
    set.add(2);
    set.add(1);
    System.out.println(set);
    Iterator it = set.iterator(); // iterator for traversing points to null/ garbage value at first
    while(it.hasNext()) { 
      System.out.println(it.next());
    }
    //enhanced for loop
    for(Integer i : set) {
      System.out.println(i);
    }
    set.remove(2);
    if(set.contains(2)) {
      System.out.println("set contains 2");
    }
    if(set.contains(3)) {
      System.out.println("set contains 3");
    }
    set.clear();
    System.out.println(set.size());
    System.out.println(set.isEmpty());
    LinkedHashSet<String> lhs = new LinkedHashSet<>();
    lhs.add("Delhi");
    lhs.add("Mumbai");
    lhs.add("Noida");
    lhs.add("Bengaluru");
    System.out.println(lhs);
    TreeSet<String> ts = new TreeSet<>();
    ts.add("Delhi");
    ts.add("Mumbai");
    ts.add("Noida");
    ts.add("Bengaluru");
    System.out.println(ts);
}
}