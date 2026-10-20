public class arrstrictlyincre { //Time Complexity is O(n) where n is Array Length
    public static boolean isSorted(int arr[] ,int index) {
        if(index == arr.length-1) {
            return true;
        }
        if(arr[index] >= arr[index+1]) {
            return false;
        }
        return isSorted(arr,index+1);
    }
        public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int index = 0;
        boolean ans = isSorted(arr,index);
        System.out.println("Is Strictly Incresing: " + ans);
    }
}
