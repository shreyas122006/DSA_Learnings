public class firstandlastocc { //Time Complexity O(n) where n is String Length
    public static void FirstLastOccur(int index, String Example, char First, int first, int last) {
        if(index < 0 ) {
            System.out.println("First Occurence: " + first);
            return;
        }
        if(First == Example.charAt(index)) {
            if(last == -1) {
                last = index;
                System.out.println("Last Ocuurence: " + last);
            }
            else {
                first = index;
            }
        }
        FirstLastOccur(index-1,Example,First,first,last);
    }
    public static void main(String[] args) {
        String Example = "abaacdaefah";
        char First= 'a';
        int Length = Example.length();
        int first= -1;
        int last = -1;
        FirstLastOccur(Length-1,Example,First,first,last);
    }
}
