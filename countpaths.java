public class countpaths {
    public static int countPaths(int i, int j, int n, int m) {
        if(i == n || j == m) {
            return 0;
        }
        if(i == n-1 && j == m-1) {
            return 1;
        }
        // for Downward Paths
        int DownwardPath = countPaths(i+1,j,n,m);

        // for Right Paths
        int RightPath = countPaths(i,j+1,n,m);
        
        return DownwardPath + RightPath;
    }
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int TotalPaths = countPaths(0,0,n,m);
        System.out.println("Total No. of Paths are : " + TotalPaths);
    }
}
