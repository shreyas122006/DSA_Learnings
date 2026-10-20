import java.util.ArrayList; 
public class subsetsofsets { // Time Complexity is O(2^n)

    public static void PrintSubsets(ArrayList<Integer> Subsets) {
        for( int i = 0; i<Subsets.size(); i++) {
            System.out.print(Subsets.get(i) + " ");
        }
        System.out.println();
    }
    public static void findSubsets(int n, ArrayList<Integer> Subsets) {

        if( n == 0 ) {
            PrintSubsets(Subsets);
            return;
        }
        // if The No. Wants to Come

        Subsets.add(n);
        findSubsets(n-1,Subsets);

        // if The No. does not Want to Come

        Subsets.remove(Subsets.size() - 1);
        findSubsets(n-1,Subsets);
    }
    public static void main(String[] args) {
        int n = 3;
        ArrayList<Integer> Subsets = new ArrayList<>();
        findSubsets(n,Subsets);
    }
}
