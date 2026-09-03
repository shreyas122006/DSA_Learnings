import java.util.*;
public class fibonaccitilln {
    public static void Fibonacci(int a, int b, int n) {
        int c = a+b;
        System.out.println(c);
        if(n == 0) {
            return;
        }
        Fibonacci(b,c,n-1);
    }
    public static void main (String[] args) {
        int a = 0;
        int b = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Nth Term of Fibonacci Series: ");
        int n = sc.nextInt();
        System.out.println(a);
        System.out.println(b);
        Fibonacci(a,b,n-2);
        sc.close();
    }

}
