import java.util.*;
public class recursionfact {

    public static int Factorial(int n) {
        if(n==0 || n ==1) {
            return 1;
        }
        return n*Factorial(n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Any Number: ");
        int n = sc.nextInt();
        System.out.println("The Factorial is : " + Factorial(n));
        sc.close();
    }
}
