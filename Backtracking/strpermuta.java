public class strpermuta { // Time Complexity is O(n!) 
    public static void PrintPermutation(String str, String permutation) {
        if(str.length() == 0) {
            System.out.println(permutation);
            return;
        }
        for(int i = 0; i<str.length(); i++) {
            char CurrChar = str.charAt(i);
            // "abc" -> "ab"
            String newstr = str.substring(0,i) + str.substring(i+1);
            PrintPermutation(newstr, permutation+CurrChar);
        }
    }
    public static void main(String[] args) {
        String str = "abc";
        PrintPermutation(str, "");
    }
}
