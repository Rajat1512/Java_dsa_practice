import java.util.*;
public class Indian_Coins {
    public static void main(String args[]){
                 
        Integer coin[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int amount = 1059;

        Arrays.sort(coin, Comparator.reverseOrder());

        ArrayList<Integer> notes = new ArrayList<>();
        
        int count = 0;
        for(int i = 0; i<coin.length; i++){
            if(coin[i] <= amount){
                while(coin[i] <= amount){
                    amount -= coin[i];
                    notes.add(coin[i]); 
                    count++;
                }
            }
        }

        System.out.println("The minimum number of coins or notes required for the given amount are: " + count);
        System.out.print("And they are: ");
        for(int i = 0; i<notes.size(); i++){
            System.out.print(notes.get(i) + " " );

        }
    }
}
