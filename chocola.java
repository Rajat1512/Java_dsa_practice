import java.util.*;
public class chocola {
    public static void main(String args[]){
        int m = 6, n = 4;
        Integer costVer[] = {2, 1, 3, 1, 4};
        Integer costHor[] = {4, 1, 2};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while(v<costVer.length && h<costHor.length){
            if(costVer[v] > costHor[h]){ //vertical cut
                cost += costVer[v] * hp;
                vp++;
                v++;
            }
            else{ //horizontal cut
                cost += costHor[h] * vp;
                hp++;
                h++;
            }
        }

        while(v<costVer.length){
          cost += costVer[v] * hp;
          vp++;
          v++;  
        }

        while(h<costHor.length){ 
            cost += costHor[h] * vp;
            hp++;
            h++;
            
        }

        System.out.println("Minimum cost = " + cost);

    }
}
