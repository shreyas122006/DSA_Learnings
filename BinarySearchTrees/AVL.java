public class AVL {
  static class Node {
    int data,height;
    Node left,right;
    Node (int data) {
      this.data = data;
      height = 1;
    }
  }
  public static Node root;
  public static int height(Node root) {
    if(root == null) {
      return 0;
    }
    return root.height;
  }
  static int max(int a, int b) {
    return a>b?a:b;
  }
  // Right rotate subtree rooted with y
  public static Node rightRotate(Node y) {
    Node x=y.left;
    Node T2=x.right;
    // rotation using 3 nodes
     x.right=y;
     y.left=T2;
     // update heights
     y.height=Math.max(height(y.left),height(y.right))+1;
     x.height=Math.max(height(x.left),height(x.right))+1;
    // x is new root
     return x;
    }
  // Left rotate subtree rooted with x
  public static Node leftRotate(Node x) {
    Node y=x.right;
    Node T2=y.left;
    // rotation using 3 nodes
     y.left=x;
     x.right=T2;
    // // update heights
     x.height=Math.max(height(x.left),height(x.right))+1;
     y.height=Math.max(height(y.left),height(y.right))+1;
    // y is new root
     return y;
    }
  public static int getBalance(Node root) {
    if(root==null)
      return 0;
    return height(root.left) -height(root.right);
  }
  public static Node insert(Node root, int key) {
    if(root == null) {
      
      return new Node(key);
    }
    if(root.data>key) {
      //left subtree 
      root.left = insert(root.left,key);
    }
    else if(root.data<key) {
      //right subtree
      root.right = insert(root.right,key);
    } else {
    return root; // duplicate keys not allowed
    }
    //Update root height
    root.height = 1+Math.max(height(root.left),height(root.right));
    //Get roots balance factor
    int bf = getBalance(root);
    // Left Left Case
    if(bf > 1 && key < root.left.data) {
      return rightRotate(root);
    }
    // Right Right Case
    if(bf < -1 && key > root.right.data) {
      return leftRotate(root);
    }
    // Left Right Case
     if(bf > 1 && key > root.left.data)  {
      root.left = leftRotate(root.left);
      return rightRotate(root);
     }
    // Right Left Case
    if(bf < -1 && key < root.right.data) {
    root.right = rightRotate(root.right);
    return leftRotate(root);
    }
    return root; // returned if AVL Balanced
  }
  public static void preorder(Node root) {
    if(root==null) {
      return;
    }
    System.out.print(root.data+" ");
    preorder(root.left);
    preorder(root.right);
  }

public static void main(String[] args) {
    // AVL balance factor = -1,0,+1;
    // lh-rh <2
    //total BST = n!
    //Rotations are on 3 nodes
    // LL LR RR RL
    // 1)Balance Factor unbalanced
    // 2)Case
    // 3)Rotation
    // LL -> Right Rotation
    // LR -> Left Rotation and Right Rotation // shortcut direct replace
    // RR -> Left Rotation
    // RL -> Right Rotation and Left Rotation // shortcut direct replace
    // if big case appears then consider first 2 RLL -> RL
    root = insert(root,10);
    root = insert(root,20);
    root = insert(root,30);
    root = insert(root,40);
    root = insert(root,50);
    root = insert(root,25);
    /* 
              AVL Tree
                 30
               /   \
              20     40
             / \      \
            10  25    50
          
    */
   preorder(root);
  }
  }
  

