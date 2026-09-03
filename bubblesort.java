public class bubblesort {
    public static void main(String[] args) {
        int arr[] = {7,8,3,1,2};
        int temp =0;
        // time complexity = O(n^2)
        for(int i= 0; i<arr.length-1; i++) { // No. of Loops
            for ( int j =0 ; j<(arr.length-i-1); j++) { // Compare pairs and swap them if condition met
                if(arr[j] >= arr[j+1]) {
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for(int i =0; i<arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }
}