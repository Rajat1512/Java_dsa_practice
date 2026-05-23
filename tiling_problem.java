public class tiling_problem {

    public static int tiling(int n){ //2*n
        if(n==0 || n==1){
            return 1;
        }

        int HW = tiling(n-2); //horizontal ways
        int VW = tiling(n-1); //vertical ways
        int TW = HW + VW; //total ways

        return TW;

    }
    public static void main(String args[]){
        int n = 4;
        System.out.println("Total ways = " + tiling(n));
          
    }

    
}