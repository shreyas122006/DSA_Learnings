import java.util.*;
public class recursionsumton {
    public static void PrintSum(int n,int sum) {
        sum = sum + n;
        if(n==0) {
            System.out.println("The Sum is: " +sum);
            return;
        }
        PrintSum(n-1,sum);
    }
    public static void main(String[] args) {
        int sum =0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Any Number: ");
        int n = sc.nextInt();
        PrintSum(n,sum);
        sc.close();
    }
}