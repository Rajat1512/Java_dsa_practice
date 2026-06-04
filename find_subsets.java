public class find_subsets {

    public static void find_subsets(String str, String ans, int i){
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.print("null ");
            }
            else{
                System.out.print(ans + " ");
            }
            return;
        }

        find_subsets(str, ans+str.charAt(i), i+1); //we are adding character in ans

        find_subsets(str, ans, i+1); //we are not adding character in ans
    }
    public static void main(String args[]){
        String str = "abc";
        String ans = "";
        System.out.println("Subsets for given string are: ");
        find_subsets(str, ans, 0);
    }
}
