public class insertionsort {
    public static void main(String[] args) {
        int arr[] = {7,8,3,1,2};
        for(int i =1; i<arr.length; i++) { // unsorted array loop
            int current = arr[i]; // Take Element from Unsorted Array
            int j = i-1; // Sorted Array Element
            while(j>=0 && current < arr[j]) { // Sorting in front
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current; 
        }
        for(int i =0; i<arr.length ; i++) {
            System.out.print(" " + arr[i]);
        }
    }
}
