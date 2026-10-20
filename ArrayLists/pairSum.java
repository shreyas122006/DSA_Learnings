import java.util.ArrayList;

public class pathSum {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(11);
    list.add(15);
    list.add(6);
    list.add(8);
    list.add(9);
    list.add(10);
    int target = 16;
    System.out.println(list);
    int left,right = 0;
    int x = -1;
    int n = list.size();
    for(int i=0; i<list.size(); i++) {
      if(list.get(i)>list.get(i+1)) {
        x = i;
        break;
      }
    }
    left = x+1;
    right = x;
    while(left!=right) {
      if(list.get(left)+list.get(right)==target) {
        return;
      }
      if(list.get(left) + list.get(right)<target) {
        left = (left+1)%n;
      } else {
         right = (n+right-1)%n;
      }
    }
    System.out.println(list);
}
}