public class sum_of_subarray {
    public static void main(String args[]){
        int arr[] = {2, 4, 6, 8, 10};
        int Msum = 0;

        for(int i = 0; i<arr.length; i++){
            for(int j = i; j<arr.length; j++){
                int sum = 0;
                for(int k = i; k<=j; k++){
                    sum += arr[k];
                    Msum = Math.max(Msum, sum);
                }
                System.out.println("sum of subarray is: "+ sum);    
            }
            System.out.println();
        }
        System.out.println("Maximum sum is: " + Msum);

        
    }
}
