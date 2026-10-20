
public class recurreversestr { // Time complexity O(n) where n is String Length
    public static void ReverseString(int index, String Name) {
        if(index < 0 ) {
            return;
        }
        System.out.print(Name.charAt(index));
        ReverseString(index-1,Name);
    }
    public static void main(String[] args) {
        String Name= "Shreyash";
        int index = Name.length();
        ReverseString(index-1,Name);
    }
}
