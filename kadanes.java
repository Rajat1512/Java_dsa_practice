public class kadanes {
    public static void main(String args[]){
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int current_sum = 0;
        int max_sum = 0;


        for(int i=0; i<arr.length; i++){

            current_sum  += arr[i];

            if(current_sum <= 0){
                current_sum  = 0;
            }

            max_sum = Math.max(current_sum , max_sum);
        }
        System.out.println(max_sum);
    }
}
