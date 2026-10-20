public class totaltiles {
    public static int CountTiles(int n, int m) {
        if(n == m) {
            return 2;
        }
        if(n < m) {
            return 1;
        }

        // If Tile Placed Horizontally 
        int HorizontalTile = CountTiles(n-1,m);

        // If Tile Placed Vertically 
        int VerticalTile = CountTiles(n-m,m);
        return HorizontalTile + VerticalTile;
    }
    public static void main(String[] args) {
        int n = 4;
        int m = 2;
        int Tiles = CountTiles(n,m);
        System.out.println("The Total Possible ways to Place Tiles are: " + Tiles);
    }
}
