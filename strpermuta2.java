public class strpermuta2 {
    public static void printPermutations(String str, String Permutations, int index) {
        if(str.length() == 0) {
            System.out.println(Permutations);
            return;
        }

        for(int i=0; i<str.length(); i++) {
            char CurrChar = str.charAt(i);
            String newStr = str.substring(0,i) + str.substring(i+1);
            printPermutations(newStr,Permutations+CurrChar,index+1);
        }
    }
    public static void main(String[] args) {
        String str = "ABC";
        printPermutations(str,"",0);
    }
}
