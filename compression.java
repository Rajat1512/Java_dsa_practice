public class compression {

    public static String compress(String str){
        String nstr = "";

        for(int i=0; i<str.length(); i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            nstr += str.charAt(i);
            if(count > 1){
                nstr += count.toString();
            }
        }
        return nstr;
    }
    public static void main(String args[]){
        String str = "aaaabbbcccccdddeeeee";
        System.out.println("Compressed string: " + compress(str));
    }
}
