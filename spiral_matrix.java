public class spiral_matrix {
    public static void main(String args[]){
        int matrix[][] = {{1,2,3,4},
                          {5,6,7,8},
                          {9,10,11,12},
                          {13,14,15,16}};
        int n = matrix.length;
        int m = matrix[0].length;

        int sr = 0; //starting row
        int sc = 0; //starting column
        int er = n-1; //ending row
        int ec = m-1; //ending column

        System.out.println("Spiral Matrix sequence: ");
        while(sr<=er && sc<=ec){

            //top
            for(int i=sc; i<=ec; i++){
                System.out.print(matrix[sr][i] + " ");
            }

            //right
            for(int i=sr+1; i<=er; i++){
                System.out.print(matrix[i][ec] + " ");
            }

            //bottom
            for(int i=ec-1; i>=sc; i--){
                System.out.print(matrix[er][i] + " ");
            }

            //left
            for(int i=er-1; i>=sr+1; i--){
               System.out.print(matrix[i][sr] + " ");
            }

            sr++;
            sc++;
            er--;
            ec--;
  
        }

    }
}
