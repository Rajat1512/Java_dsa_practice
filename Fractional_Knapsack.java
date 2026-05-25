import java.util.*;
public class Fractional_Knapsack {
    public static void main(String args[]){
        int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int capacity = 50;

        double ratio[][] = new double[value.length][2];

        for(int i = 0; i<value.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = (double)value[i]/weight[i];
        }

        //asc order sort
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int finalAns = 0;
         
        for(int i = ratio.length-1; i>=0; i--){
            int idx = (int)ratio[i][0];
            if(capacity >= weight[idx]){
              finalAns += value[idx];
              capacity -= weight[idx];
            }
            else{
                finalAns += ratio[i][1]*capacity;
                capacity = 0;
                break;
            }
        }

        System.out.println(finalAns);
    
    }
}
 