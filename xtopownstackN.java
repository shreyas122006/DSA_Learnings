public class xtopownstackN {
    public static int PrintXton(int x,int n) {
        if(n == 0) {
            return 1;
        }
        if(x == 0) {
            return 0;
        }
        int xpownm1 = PrintXton(x,n-1);
        int xpown = x * xpownm1;
        return xpown;
    }
    public static void main(String[] args) {
        int n = 3;
        int x = 5;
        int ans = PrintXton(x,n);
        System.out.println(ans);
    }
}