import java.util.*;
public class sumofNodes {
  static class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
      this.data = data;
      this.left = null;
      this.right = null;
    }
  }
  static class Info {
    int diam;
    int ht;
    public Info(int diam, int ht) {
      this.diam = diam;
      this.ht = ht;
    }
  }
  public static Info diameter2(Node root) { // O(n)
    if(root == null) {
      return new Info(0,0);
    }
    Info leftInfo = diameter2(root.left);
    Info rightInfo = diameter2(root.right);

    int diam = Math.max(Math.max(leftInfo.diam,rightInfo.diam), leftInfo.ht + rightInfo.ht +1);
    int ht = Math.max(leftInfo.ht,rightInfo.ht) +1;

    return new Info(diam,ht);
  }
  public static int sum(Node root) {
    if(root == null) {
      return 0;
    }
    int leftSum = sum(root.left);
    int rightSum = sum(root.right);
    return leftSum + rightSum + root.data;

  }
  public static int height(Node root) {
    if(root == null) {
      return 0;
    }
    int lh = height(root.left);
    int rh = height(root.right);
    return Math.max(lh,rh) + 1;
  }
  public static int diameter(Node root) { // O(n^2)
    if(root == null) {
      return 0;
    }
    int leftDiam = diameter(root.left);
    int rightDiam = diameter(root.right);
    int lh = height(root.left);
    int rh = height(root.right);
    int selfDiam = lh + rh + 1;
    return Math.max(leftDiam,Math.max(rightDiam,selfDiam));
  }
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);
    System.out.println(sum(root));
    System.out.println(diameter(root));
    System.out.println(diameter2(root).diam);
  }
}
