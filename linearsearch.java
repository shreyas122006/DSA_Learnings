public class linearsearch {

    //search in the array: return the index if item found
    //otherwise if not found return -1
    public static int ReturnValue() {
        int arr[] = {18,12,9,14,77,50};
        for(int i =0; i<arr.length; i++) {
            if(arr[i] == 20) {
                System.out.println("Index: " + i);
                return 0;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(ReturnValue());
    }
}