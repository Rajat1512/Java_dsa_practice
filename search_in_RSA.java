public class search_in_RSA {
    public static int search(int[] nums, int target) {
        int diff = 0;
        int idx = -1;
        if(nums.length == 1){
            if(nums[0] == target){
                return 0;
            }
        }
        for(int i=0; i<nums.length-1; i++){
            
            diff = nums[i] - nums[i+1];
            if(diff > 0){
                idx = i;
                break;
            }   
        }

        

        if(idx == -1){
            for(int i=0; i<nums.length;i++){
                if(target == nums[i]){
                    return i;
                }
            }
            return -1;
        }
        else{
            if(target == nums[idx]){
                return idx;
            }
    
            if(target < nums[0]){
                //search in right part
                for(int i=idx+1; i<nums.length; i++){
                    if(nums[i] == target){
                        return i;
                    }
                }
            }
    
           if(target >= nums[0]){
                //search in left part
                for(int i=0; i<idx; i++){
                    if(nums[i] == target){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String args[]){
        int[] nums = {4,5,6,7,0,1,2,3};
        int target = 0;

         int i = search(nums, target);

         System.out.println(i);
    }

}
