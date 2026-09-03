import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class listEx {
  public static void swap(ArrayList<Integer> list, int idx1, int idx2) {
    int temp = list.get(idx1);
    list.set(idx1, list.get(idx2));
    list.set(idx2, temp); 
  }
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Boolean> boolist = new ArrayList<>();
    ArrayList<Character> Charlist = new ArrayList<>();
    
    list.add(1); // add element O(1)
    list.add(2); // get element O(1);
    list.add(3); // remove element O(n);
    list.add(4); // set element at index O(n);
    list.add(5); // contains element O(n);
    int element = list.get(2);
    System.out.println(element);
    list.remove(2);
    System.out.println(list);
    list.set(2,10);
    System.out.println(list);
    System.out.println(list.contains(2));
    System.out.println(list.size());

    int idx1= 1, idx2 = 3;
    System.out.println(list);
    swap(list,idx1,idx2);
    System.out.println(list);
    Collections.sort(list);
    System.out.println(list);
    Collections.sort(list, Collections.reverseOrder());
    System.out.println(list);

    ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
    ArrayList<Integer> List = new ArrayList<>();
    ArrayList<Integer> List1 = new ArrayList<>();
    List.add(1);
    List.add(2);
    List1.add(3);
    List1.add(4);
    mainList.add(List);
    mainList.add(List1);
    System.out.println(mainList);
    ArrayList<Integer> S1 = new ArrayList<>();
    ArrayList<Integer> S2 = new ArrayList<>();
    ArrayList<Integer> S3 = new ArrayList<>();
    for(int i=1; i<=5; i++) {
      S1.add(i*1);
      S2.add(i*2);
      S3.add(i*3);
    }
    System.out.println(S1 + " " + S2 + " " + S3);
    mainList.add(S1);
    mainList.add(S2);
    mainList.add(S3);
    System.out.println(mainList);
    for(int i=0; i<mainList.size(); i++) {
      ArrayList<Integer> currList = mainList.get(i);
      for(int j=0; j<currList.size(); j++) {
        System.out.print(currList.get(j)+" ");
      }
      System.out.println();
    }
  }
}