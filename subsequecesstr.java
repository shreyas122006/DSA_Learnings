public class subsequecesstr { //Time Complexity is O(2^n) or O(2^n+1 - 1)   // where n is characters in string // subsequences are 2^n
    public static void subsequences(String Example, int Index, String NewString) {
        if(Index == Example.length()) {
            System.out.println(NewString);
            return;
        }
        char CurrChar = Example.charAt(Index);
        // If the Current Character Wants to Come in New String

        subsequences(Example,Index+1,NewString+CurrChar);

        // If The Current Character Does Not Want to Come in New String

        subsequences(Example,Index+1,NewString);

    }
    public static void main(String[] args) {
        String Example = "abc";
        subsequences(Example,0,"");
    }
}
