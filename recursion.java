public class recursion {

    public static int lo(int arr[], int key, int i){
        if(i == arr.length-1){
            return -1;
        }

        int isFound = lo(arr, key, i+1);

        if(isFound == -1 && arr[i] == key){
            return i;
        }

        return isFound;
    }
    public static void main(String args[]){
        int arr[] = {8,3,6,9,10,2,3};
        System.err.println(lo(arr, 5, 0));

    }
}
