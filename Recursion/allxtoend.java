public class allxtoend { //Time Complexity is O(n + count) which is O(2n) constant removed so O(n) where n is String length
    public static void NewString(int index, String Example, int Count,char x) {
        if(index == Example.length()) {
            int i =0;
            while(i<Count) {
            System.out.print("x");
            i++;
        }
            return;
        }
        if(x == Example.charAt(index)) {
            Count++;
        }
        else {
            System.out.print(Example.charAt(index));
        }
        NewString(index+1,Example,Count,x);
    }
    public static void main(String[] args) {
        String Example = "axbcxxdxefgh";
        char x = 'x';
        NewString(0,Example,0,x);
    }
}
