public class towerofHanoi { // Time Complexity: O(2^n-1) or O(2^n)
    public static void TowerOfHanoi(int n, String Src, String Helper , String Dest) {
        if ( n == 1) {
            System.out.println("Transfer disk " +  n + " From " + Src + " to " + Dest);
            return;
        }
        TowerOfHanoi(n-1,Src,Dest,Helper);
        System.out.println("Transfer disk " + n + " From " + Src + " to " + Dest);
        TowerOfHanoi(n-1,Helper,Src,Dest);
    }
    public static void main(String[] args) {
        int n = 3;
        TowerOfHanoi(n,"S","H","D");
    }
}
