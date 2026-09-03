public class callguests {
    public static int callGuests(int n) {
        if(n <= 1) {
            return 1;
        }
        
        // If we call person single
        int singlePerson = callGuests(n-1);

        // if we call person in pairs
        int pairPerson = (n-1) * callGuests(n-2);

        return singlePerson + pairPerson;
    }
    public static void main(String [] args) {
        int n = 4;
        int possibleWays = callGuests(n);
        System.out.println("Total No. of Ways: " + possibleWays);
    }
}
