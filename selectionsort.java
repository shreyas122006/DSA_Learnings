public class selectionsort {
    // Time Complexity: O(n^2)
    public static void main(String[] args) {
        int arr[] = {7,8,3,1,2};
        for(int i =0; i<arr.length-1; i++) {
            int smallest =i;
            for(int j =i+1; j<arr.length; j++) {
                // Find The Smallest Element From the Array
                if(arr[smallest] > arr[j]) {
                    smallest =j;
                }
            }
            // Swap the Smallest Element In the Front
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;
        }
        for(int  i =0; i<arr.length; i++) {
        System.out.print(" " + arr[i]);
        }
    }
}