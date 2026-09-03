public class xtopownstacklogN {
    public static int PrintXpowlogN(int n, int x) {
        if(x == 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }
        if(n % 2 == 0) {
            return PrintXpowlogN(n/2,x) * PrintXpowlogN(n/2,x);
        }
        else {
            return PrintXpowlogN(n/2,x) * PrintXpowlogN(n/2,x) *x;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int x = 5;
        int FinalValue = PrintXpowlogN(n,x);
        System.out.println(" XpowLogN is : "+ FinalValue);
    }
}
