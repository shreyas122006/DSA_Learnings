public class recursion1to5 {
    public static void Print1To5(int n) {
        if(n==6) {
            return;
        }
        System.out.println(n);
        Print1To5(n+1);
    }
    public static void main(String[] args) {
        int n =1;
        Print1To5(n);
    }
}