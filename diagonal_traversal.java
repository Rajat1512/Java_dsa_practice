
public class diagonal_traversal {
    public static void main(String args[]){
        int mat[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16},{17,18,19,20}};
        
        int n = mat.length;
        int m = mat[0].length;
        
        //cover all diagonals starting from the first column
        for(int row=0; row<n; row++){
            int i=row, j=0;
            
            //cover each diagonal going up-right
            while(i>=0 && j<m){
                System.out.print(mat[i][j] + " ");
                i--;
                j++;
            }
            
        }

        //cover all remaining diagonals starting from the last row (except first column)
        for(int col=1; col<m; col++){
            int i = n-1, j = col;

            //cover each diagonal going up-right
            while(i>=0 && j<m){
                System.out.print(mat[i][j] + " ");
                i--;
                j++;
            }
        }
        
    }
}
//OUTPUT:
//1 5 2 9 6 3 13 10 7 4 17 14 11 8 18 15 12 19 16 20 