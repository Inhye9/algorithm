package algorithm.programmers;

import java.util.Arrays;

public class LifeBoat {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] people= {70,50,80,100};
        int limit=100;

        Arrays.sort(people);

        int s=0,e=people.length-1;
        int cnt=0;

        while(s<e) {
            if(people[s]+people[e]<=limit) {
                cnt+=1;
                s++;
                e--;
            }else{
                cnt++;
                e--;
            }
        }

        if(s==e) cnt++;

        System.out.println(cnt);
    }

}
