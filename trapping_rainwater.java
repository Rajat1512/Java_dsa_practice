public class trapping_rainwater {
    public static void main(String args[]){
        int arr[] = {4, 2, 0, 6, 3, 2, 5};
        int n = arr.length;

        //left max boundary
        int left_max[] = new int[n];
        left_max[0] = arr[0];
        for(int i = 1; i<n; i++){
            left_max[i] = Math.max(left_max[i-1], arr[i]);
        } 

        //right max boundary
        int right_max[] = new int[n];
        right_max[n-1] = arr[n-1];
        for(int i = n-2; i>=0; i--){
            right_max[i] = Math.max(right_max[i+1], arr[i]);
        }

        //trapped rainwater
        int waterlevel = 0;
        int trw = 0;
        int total_trw = 0;
        for(int i=0; i<n; i++){
            waterlevel = Math.min(left_max[i], right_max[i]);

            trw = (waterlevel - arr[i]);
            total_trw  += trw;
        }

        System.out.println("Total Trapped Rainwater = " + total_trw);
    
    }
}
