import java.util.HashSet;
public class unisubseqstr {
    public static void subsequences(String Example, int Index, String NewString, HashSet<String> set) {
        if(Index == Example.length()) {
            if(set.contains(NewString)) {
            return;
            }
           else {
            System.out.println(NewString);
            set.add(NewString);
            return;
        }
    }
        char CurrChar = Example.charAt(Index);

        // if the char does not wants to come 
        
        subsequences(Example,Index+1,NewString,set);
        
        
        // if the char wants to come 
        
        subsequences(Example,Index+1,NewString+CurrChar,set);
        
    }
    public static void main(String[] args) {
        String Example = "aaa"; 
        HashSet<String> set = new HashSet<>();
        subsequences(Example,0,"",set);
    }
}
