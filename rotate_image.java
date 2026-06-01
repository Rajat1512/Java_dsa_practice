import java.util.*;
public class rotate_image {
    public static void main(String args[]){
        ArrayList<Integer> ans = new ArrayList<>();
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int n = matrix.length;
        int k = n-1;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                ans.add(matrix[k-j][i]);
            }
        }
        int l = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = ans.get(l);
                System.out.print(matrix[i][j] + " ");
                l++;
            }
        }
    }
}