import java.util.*;
public class MADP {
    public static void main(String args[]){
        int A[] = {4, 1, 8, 7};
        int B[] = {2, 3, 6, 5};

        Arrays.sort(A);
        Arrays.sort(B);
         
         int MADP = 0;
        for(int i = 0; i<A.length; i++){
            if(A[i] > B[i]){
                MADP += A[i] - B[i];
            }else{
                MADP += B[i] - A[i];
            }
        }

        System.out.println("Minimum Absolute Difference Pairs: " + MADP);
        
     
    }
}
