public class grid_ways {

    public static int gridWays(int n, int m, int i, int j){
        if(i == n-1 && j == m-1){
            return 1;
        }
        else if(i == n || j == m){
            return 0;
        }

        int w2 = gridWays(n,m,i+1,j); //down move
        int w1 = gridWays(n,m,i,j+1); //right move
       

        int total_ways = w1 + w2;

        return total_ways;

    }

    // public static int fact(int n){
    //     if(n==1){
    //         return 1;
    //     }

    //     int f = n*fact(n-1);

    //     return f;

    // }

    // public static int gridWays(int n, int m){
    //     int total = (n-1)+(m-1);

    //     int tw = fact(total)/(fact(m-1) * fact(n-1));

    //     return tw;
    // }
    public static void main(String args[]){
        int n=3, m=3; //nxn grid
        System.out.println("Total ways: "+ gridWays(n,m,0,0));
    }
}
